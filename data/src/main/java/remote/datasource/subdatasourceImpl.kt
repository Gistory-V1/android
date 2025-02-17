package remote.datasource

import kotlinx.coroutines.flow.Flow
import remote.api.auth.subApi
import remote.dto.auth.request.PostsubResponse
import util.performApiRequest
import javax.inject.Inject

class subdatasourceImpl @Inject constructor(
    private val subService: subApi
): subdatasource {
    override suspend fun createlike( body: PostsubResponse): Flow<Unit> =
        performApiRequest { subService.createlike( body = body)}


    override suspend fun deltelike( body: PostsubResponse): Flow<Unit> =
        performApiRequest { subService.deletelike( body = body)}




}