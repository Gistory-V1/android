package view.signup.UiState

import model.auth.response.GAuthLoginResponseModel

sealed interface LoginUiState {
    object Loading : LoginUiState
    data class Success(val gAuthLoginResponseModel: GAuthLoginResponseModel) : LoginUiState {

    }
    object BadRequest : LoginUiState
    object NotFound : LoginUiState
    object EmailNotValid : LoginUiState
    data class Error(val exception: Throwable) : LoginUiState
}