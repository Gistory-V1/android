package remote.datasource

import kotlinx.coroutines.flow.Flow
import remote.dto.auth.response.top5response

interface rankdatasource{
    suspend fun Ranklike(): Flow<List<top5response>>

}