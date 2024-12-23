package remote.dto.auth.request

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class ProfileResponse(
    @Json(name = "userid") val userid: Long,
    @Json(name = "name") val name: String,
    @Json(name = "postsCount") val postsCount: Long,
    @Json(name = "likesCount") val likesCount: Long
)