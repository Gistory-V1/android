package view.otherblog.UiState


import kotlinx.collections.immutable.ImmutableList
import model.auth.response.PostresponseModel

sealed interface OtherBlogUiState {
    object Loading : OtherBlogUiState
    object Empty : OtherBlogUiState
    object Fail : OtherBlogUiState
    data class Success(var data: List<PostresponseModel>) : OtherBlogUiState
}
