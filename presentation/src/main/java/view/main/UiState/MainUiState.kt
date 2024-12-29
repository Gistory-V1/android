package view.main.UiState

import kotlinx.collections.immutable.ImmutableList
import model.auth.response.top5responsemodel

sealed interface MainUiState {
    object Loading : MainUiState
    object Empty : MainUiState
    data class Success(val data: List<top5responsemodel>) : MainUiState
    object Fail : MainUiState
}
