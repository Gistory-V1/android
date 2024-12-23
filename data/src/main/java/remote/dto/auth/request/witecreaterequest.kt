package remote.dto.auth.request

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

data class witecreaterequest(
    @Json(name = "title") val title: String,
    @Json(name = "content") val content: String
)

