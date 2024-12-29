package view.myblogwrie.MyBlogWriteUiState

import model.auth.response.PostresponseModel
import view.otherblog.UiState.OtherBlogUiState

sealed interface MyBlogWriteUiState {

    object Loading :MyBlogWriteUiState
    object Empty : MyBlogWriteUiState
    object Fail : MyBlogWriteUiState
    data class Success(var data: List<PostresponseModel>) : MyBlogWriteUiState
}