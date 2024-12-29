package view.login.SignUpUiState

sealed interface SignUpUiState {
    object Loading : SignUpUiState
    object Success : SignUpUiState
    object PasswordNotValid : SignUpUiState
    data class Error(val exception: Throwable) : SignUpUiState
}