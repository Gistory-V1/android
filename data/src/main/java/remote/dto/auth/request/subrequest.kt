package remote.dto.auth.request

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class PostsubResponse(
    @Json(name = "postId") val postId: Long,
    @Json(name = "subClick") val subClick: Boolean,
    @Json(name = "subCount") val subCount: Long
)