package view.myblog.UiState

import model.auth.response.prfilereponseModel


sealed interface ProfileUiState {
    object Loading : ProfileUiState
    object Empty : ProfileUiState
    object Fail : ProfileUiState
    data class Success(val data: prfilereponseModel) : ProfileUiState
}
