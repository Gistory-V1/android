package remote.dto.auth.response

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass
import model.auth.response.PostresponseModel

@JsonClass(generateAdapter = true)
data class PostResponse(
    @Json(name = "postId") val postId: Int,
    @Json(name = "title") val title: String,
    @Json(name = "content") val content: String,
    @Json(name = "likeCount") val likeCount: Long,
    @Json(name = "author") val author: String,
    @Json(name = "views") val views: Long,
    @Json(name = "createdAt") val createdAt: String
)
fun PostResponse.toModel() = PostresponseModel(
    postId = postId,
    title = title,
    content = content,
    likeCount = likeCount,
    author = author,
    views = views,
    createdAt = createdAt

)