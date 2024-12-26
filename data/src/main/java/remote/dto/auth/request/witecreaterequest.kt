package remote.dto.auth.request

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass
import model.auth.request.witecreaterequestModel

data class witecreaterequest(

    @Json(name = "title") val title: String,
    @Json(name = "content") val content: String
)


fun witecreaterequest.toModel() = witecreaterequestModel(
    title = title,
    content = content
)

fun witecreaterequestModel.toDto() = witecreaterequest(
    title = title,
    content = content
)

