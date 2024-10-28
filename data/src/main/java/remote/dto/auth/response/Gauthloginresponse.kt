package remote.dto.auth.response

import Model.auth.response.GauthloginresponseModel
import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class Gauthloginresponse (
    @Json(name = "accessToken") val accessToken: String,
    @Json(name = "refreshToken") val refreshToken: String,
    @Json(name = "accessTokenExpiresIn") val accessTokenExpiresIn: String,
    @Json(name = "refreshTokenExpiresIn") val refreshTokenExpiresIn: String,
)
fun Gauthloginresponse.toLogin()= GauthloginresponseModel(
    accessToken=accessToken,
    refreshToken=refreshToken,
    accessTokenExpiresIn=accessTokenExpiresIn,
    refreshTokenExpiresIn=refreshTokenExpiresIn
)

