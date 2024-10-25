package remote.dto.auth.request

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass
@JsonClass(generateAdapter = true)
 data class GauthloginRequestBody(
    @Json(name = "code") val code: String


 )