package remote.dto.auth.request

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass
import model.auth.request.subrequestModel

@JsonClass(generateAdapter = true)
data class PostsubResponse(
    @Json(name = "postId") val postId: Long,
    @Json(name = "subClick") val subClick: Boolean,
    @Json(name = "subCount") val subCount: Long
)
fun subrequestModel.toDto() = PostsubResponse(
    postId = postId,
    subClick = subClick,
    subCount = subCount

)



fun PostsubResponse.toModel() = subrequestModel(
    postId = postId,
    subClick = subClick,
    subCount = subCount

)