import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass
import model.auth.request.likebodyModel

@JsonClass(generateAdapter = true)
data class likebodyResponse(
    @Json(name = "postId") val postId: Long,
    @Json(name = "likeClick") val likeClick: Boolean,
    @Json(name = "likeCount") val likeCount: Long,

)

fun likebodyModel.toDto() = likebodyResponse(
    postId = postId,
    likeClick = likeClick,
    likeCount = likeCount,

)

fun likebodyResponse.toModel() = likebodyModel(
    postId = postId,
    likeClick = likeClick,
    likeCount = likeCount,
)
