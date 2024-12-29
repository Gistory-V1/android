package repoistory

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import model.auth.response.top5responsemodel
import remote.datasource.rankdatasource
import remote.dto.auth.response.toModel
import reopoistory.rankRepository
import javax.inject.Inject

class RankRepositoryImpl @Inject constructor(
    private val rankService: rankdatasource
): rankRepository {
    override suspend fun Ranklike(): Flow<List<top5responsemodel>> =
        rankService.Ranklike().map { list -> list.map { it.toModel() } }

}