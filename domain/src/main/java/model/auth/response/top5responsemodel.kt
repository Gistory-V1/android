package model.auth.response

data class top5responsemodel (
    val rank: Int,
    val name: String,
    val title: String,
    val likeCount: Long,
    val views: Long,
    val createdAt: String
    )