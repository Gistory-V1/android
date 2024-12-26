package remote.dto.auth.response

import com.squareup.moshi.Json
import model.auth.response.prfilereponseModel

data class profileresponse(
    @Json(name = "userId") val userId: Long,
    @Json(name = "name") val name: String,
    @Json(name = "postsCount") val postsCount: Long,
    @Json(name = "likeCount") val likeCount: Long,
)

fun profileresponse.toModel() = prfilereponseModel(
    userid = userId,
    name = name,
    postsCount = postsCount,
    likesCount = likeCount



)