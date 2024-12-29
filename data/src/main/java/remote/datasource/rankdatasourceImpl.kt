package remote.datasource

import kotlinx.coroutines.flow.Flow
import remote.api.auth.rankAPi
import remote.dto.auth.response.top5response
import util.performApiRequest
import javax.inject.Inject

class rankdatasourceImpl @Inject constructor(
    private val rankAPi: rankAPi
) : rankdatasource {
    override suspend fun Ranklike(): Flow<List<top5response>> =
        performApiRequest { rankAPi.Ranklike() }
}