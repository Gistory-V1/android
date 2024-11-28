package model.demerit.response

import java.util.UUID

data class DemeritResponse(
    val userId: UUID,
    val toDayClean: String,
    val name: String,
    val penaltyPoint: Int,
    val cleanPoint: Int,
    val because: String,
    val pointList: Int,
    val penaltyList: Int,
)