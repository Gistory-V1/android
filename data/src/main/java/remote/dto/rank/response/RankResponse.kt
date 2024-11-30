package remote.dto.rank.response

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass
import model.rank.response.RankResponseModel
import java.util.UUID

@JsonClass(generateAdapter = true)
data class RankResponse(
    @Json(name = "userId") val userId: UUID,
    @Json(name = "rank") val rank: Int,
    @Json(name = "name") val name: String,
    @Json(name = "penaltyPoint") val penaltyPoint: Int,
)

fun RankResponse.toRank() = RankResponseModel(
    userId = userId,
    rank = rank,
    name = name,
    penaltyPoint = penaltyPoint
)