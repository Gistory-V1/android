package view.myblog.viewModel

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch
import usecase.auth.LogoutUseCase
import utill.asResult
import usecase.profile.ProfileUseCase
import view.myblog.UiState.ProfileUiState
import javax.inject.Inject

@HiltViewModel
class otherProfileViewModel @Inject constructor(
    private val savedStateHandle: SavedStateHandle,
    private val profileUseCase: ProfileUseCase,
    private val logoutUseCase: LogoutUseCase
) : ViewModel() {



    private val _profileState = MutableStateFlow<ProfileUiState>(ProfileUiState.Loading)
    val profileState: StateFlow<ProfileUiState> = _profileState.asStateFlow()

    fun getOtherProfile(name: String) = viewModelScope.launch {
        profileUseCase(name = name)
            .asResult()
            .collectLatest { result ->
                when (result) {
                    is utill.Result.Loading -> _profileState.value = ProfileUiState.Loading
                    is utill.Result.Success ->
                        _profileState.value = ProfileUiState.Success(result.data)
                    is utill.Result.Error -> {
                        _profileState.value = ProfileUiState.Fail
                        result.exception.printStackTrace()

                    }
                }
            }

        fun logout() = viewModelScope.launch {
            logoutUseCase()

        }
    }
}
