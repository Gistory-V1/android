package remote.dto.auth.request

import model.auth.request.GAuthLoginRequestBodyModel
import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
 data class GAuthLoginRequestBody(
     val email: String,
     val password: String,
 )

fun GAuthLoginRequestBodyModel.toDto() = GAuthLoginRequestBody(
    email = email,
    password = password,
)
