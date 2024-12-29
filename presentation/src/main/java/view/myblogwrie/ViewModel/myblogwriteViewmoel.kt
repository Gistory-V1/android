package view.myblogwrite.viewmodel

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch
import kotlinx.collections.immutable.toImmutableList
import usecase.book.getPostUseCase
import utill.asResult
import view.myblogwrie.MyBlogWriteUiState.MyBlogWriteUiState

import javax.inject.Inject

@HiltViewModel
class myblogwriteViewmoel @Inject constructor(
    private val savedStateHandle: SavedStateHandle,
    private val getPostUseCase: getPostUseCase,

) : ViewModel() {

    companion object {
        private const val TITLE_KEY = "title"
        private const val WRITE_KEY = "write"
    }

    private val _uiState = MutableStateFlow<MyBlogWriteUiState>(MyBlogWriteUiState.Loading)
    val uiState: StateFlow<MyBlogWriteUiState> = _uiState.asStateFlow()

    val titleTextState = savedStateHandle.getStateFlow(TITLE_KEY, "")
    val writeTextState = savedStateHandle.getStateFlow(WRITE_KEY, "")

    fun getPostList() = viewModelScope.launch {
        getPostUseCase()
            .asResult()
            .collectLatest { result ->
                when (result) {
                    is utill.Result.Loading -> _uiState.value = MyBlogWriteUiState.Loading
                    is utill.Result.Success -> if (result.data.isEmpty()) {
                        _uiState.value = MyBlogWriteUiState.Empty
                    } else {
                        _uiState.value = MyBlogWriteUiState.Success(result.data.toImmutableList())
                    }
                    is utill.Result.Error -> {
                        _uiState.value = MyBlogWriteUiState.Fail
                        result.exception.printStackTrace()
                    }
                }
            }
    }


}
