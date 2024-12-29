package com.kim.Dormitorymanager

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.flow.firstOrNull
import kotlinx.coroutines.launch
import local.datasource.LocalDataSource
import usecase.auth.SaveTokenUseCase
import usecase.auth.TokenRefreshUseCase
import utill.asResult
import javax.inject.Inject

@HiltViewModel
class MainActivityViewModel @Inject constructor(
    private val saveTokenUseCase: SaveTokenUseCase,
    private val tokenRefreshUseCase: TokenRefreshUseCase,
    private val localAuthDataSource: LocalDataSource
) : ViewModel() {

    private val _uiState = mutableStateOf<MainActivityUiState>(MainActivityUiState.Loading)
    val uiState: State<MainActivityUiState> = _uiState

    init {
        tokenRefresh()
    }

    private fun tokenRefresh() = viewModelScope.launch {
        val refreshToken = localAuthDataSource.getRefreshToken().firstOrNull()

        if (refreshToken.isNullOrEmpty()) {
            _uiState.value = MainActivityUiState.Fail
        } else {
            tokenRefreshUseCase(refreshToken)
                .asResult()
                .collectLatest { result ->
                    when (result) {
                        is utill.Result.Error -> _uiState.value = MainActivityUiState.Fail

                        is utill.Result.Loading -> _uiState.value = MainActivityUiState.Loading
                        is utill.Result.Success -> {
                            saveTokenUseCase(result.data).onSuccess {
                                _uiState.value = MainActivityUiState.Success
                            }
                        }
                    }
                }
        }
    }

}

sealed interface MainActivityUiState {
    object Loading : MainActivityUiState
    object Success : MainActivityUiState
    object Fail : MainActivityUiState
}