package view.signup.viewmodel

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch
import model.auth.request.GAuthLoginRequestBodyModel
import model.auth.response.GAuthLoginResponseModel
import usecase.auth.GAuthLoginUseCase
import usecase.auth.SaveTokenUseCase
import utill.ResourceKeys
import utill.asResult
import utill.errorHandling
import utill.isValidEmail
import view.signup.UiState.LoginUiState
import view.signup.UiState.SaveTokenUiState
import javax.inject.Inject

@HiltViewModel
class Loginviewmodel @Inject constructor(
    private val savedStateHandle: SavedStateHandle,
    private val gAuthLoginUseCase: GAuthLoginUseCase,
    private val saveTokenUseCase: SaveTokenUseCase
) : ViewModel() {
    private val _loginUiState = MutableStateFlow<LoginUiState>(LoginUiState.Loading)
    internal val loginUiState = _loginUiState.asStateFlow()

    private val _saveTokenUiState = MutableStateFlow<SaveTokenUiState>(SaveTokenUiState.Loading)
    internal val saveTokenUiState = _saveTokenUiState.asStateFlow()


    internal var email = savedStateHandle.getStateFlow(key = EMAIL, initialValue = ResourceKeys.EMPTY)
    internal var password = savedStateHandle.getStateFlow(key = PASSWORD, initialValue = ResourceKeys.EMPTY)

    internal fun login(body: GAuthLoginRequestBodyModel) = viewModelScope.launch {
        if (!isValidEmail(body.email)) {
            _loginUiState.value = LoginUiState.EmailNotValid
        } else {
            gAuthLoginUseCase(body = body)
                .asResult()
                .collectLatest {
                    result ->
                    when (result) {
                        is utill.Result.Loading -> _loginUiState.value = LoginUiState.Loading
                        is utill.Result.Success -> {
                            _loginUiState.value = LoginUiState.Success(result.data)
                            saveToken(result.data)
                        }
                        is utill.Result.Error -> {
                            _loginUiState.value = LoginUiState.Error(result.exception)
                            result.exception.errorHandling(
                                badRequestAction = { _loginUiState.value = LoginUiState.BadRequest },
                                notFoundAction = { _loginUiState.value = LoginUiState.NotFound }
                            )
                        }
                    }
                }
        }
    }

    private fun saveToken(data: GAuthLoginResponseModel) = viewModelScope.launch {
        _saveTokenUiState.value = SaveTokenUiState.Loading
        saveTokenUseCase(data = data)
            .onSuccess {
                _saveTokenUiState.value = SaveTokenUiState.Success
            }.onFailure {
                _saveTokenUiState.value = SaveTokenUiState.Error(it)
            }
    }
    internal fun onEmailChange(value: String) {
        savedStateHandle[EMAIL] = value
    }

    internal fun onPasswordChange(value: String) {
        savedStateHandle[PASSWORD] = value
    }
}

private const val EMAIL = "email"
private const val PASSWORD = "password"