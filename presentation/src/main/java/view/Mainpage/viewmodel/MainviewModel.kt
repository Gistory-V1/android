package view.Mainpage.viewmodel

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.lifecycle.viewmodel.compose.viewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch
import kotlinx.collections.immutable.toImmutableList
import usecase.rank.RankUseCase
import utill.asResult
import view.main.UiState.MainUiState
import javax.inject.Inject

@HiltViewModel
class MainviewModel @Inject constructor(
    private val savedStateHandle: SavedStateHandle,
    private val  rankUseCase: RankUseCase,
): ViewModel() {
    private val _swipeRefreshLoading = MutableStateFlow(false)
    val swipeRefreshLoading = _swipeRefreshLoading.asStateFlow()

    private val _rankList = MutableStateFlow<MainUiState>(MainUiState.Loading)
    val rankList: StateFlow<MainUiState> = _rankList.asStateFlow()


    fun getRankList() = viewModelScope.launch {
        _swipeRefreshLoading.value = true
        rankUseCase()
            .asResult()
            .collectLatest { result ->
                when (result) {
                    is utill.Result.Loading -> _rankList.value = MainUiState.Loading
                    is utill.Result.Success -> if(result.data.isEmpty()){
                        _rankList.value = MainUiState.Empty
                        _swipeRefreshLoading.value=false
                    } else {
                        _rankList.value = MainUiState.Success(result.data.toImmutableList())
                    }
                    is utill.Result.Error -> {
                        _rankList.value = MainUiState.Fail
                        result.exception.printStackTrace()
                        _swipeRefreshLoading.value=false
                }

                }
            }
    }


}