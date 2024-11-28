package remote.dto.auth.request

import model.auth.request.GAuthLoginRequestBodyModel
import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
 data class GAuthLoginRequestBody(
    @Json(name = "code") val code: String
 )

fun GAuthLoginRequestBodyModel.toDto() = GAuthLoginRequestBody(code = code)
