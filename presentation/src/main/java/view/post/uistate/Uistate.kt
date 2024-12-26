package view.post.uistate


sealed interface PostUistate{
    object Loading : PostUistate
    object Success : PostUistate
    object Fail : PostUistate
    
}