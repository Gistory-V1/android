package remote.dto.auth.request

import com.squareup.moshi.Json
import model.auth.request.witecreaterequestModel
import model.auth.request.writeputModel

data class witeputequest(
    @Json(name = "title") val title: String,
    @Json(name = "content") val content: String,
    @Json(name = "postId") val postId: Long
)

fun writeputModel.toDto() =witeputequest(
    title = title,
    content = content,
    postId = postId
)

fun witeputequest.toModel() = writeputModel(
    title = title,
    content = content,
    postId = postId

)