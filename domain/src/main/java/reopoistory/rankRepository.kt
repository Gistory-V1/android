package reopoistory

import kotlinx.coroutines.flow.Flow
import model.auth.response.top5responsemodel

interface rankRepository {
    suspend fun Ranklike(): Flow<List<top5responsemodel>>
}