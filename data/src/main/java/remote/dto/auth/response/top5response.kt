package remote.dto.auth.response

import com.squareup.moshi.Json
import model.auth.response.prfilereponseModel
import model.auth.response.top5responsemodel

data class top5response(
    @Json(name = "rank") val rank: Int,
    @Json(name = "name") val name: String,
    @Json(name = "title") val title: String,
    @Json(name = "likeCount") val likeCount: Long,
    @Json(name = "views") val views: Long,
    @Json(name = "createdAt") val createdAt: String
)

fun top5response.toModel() = top5responsemodel(
    rank = rank,
    name = name,
    title = title,
    likeCount = likeCount,
    views = views,
    createdAt = createdAt




)