package model.auth.response

data class PostresponseModel(
     val postId: Int,
    val title: String,
    val content: String,
    val likeCount: Long,
    val author: String,
    val views: Long,
    val createdAt: String
)