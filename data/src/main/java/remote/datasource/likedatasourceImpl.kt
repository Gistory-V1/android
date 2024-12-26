package remote.datasource

import kotlinx.coroutines.flow.Flow
import likebodyResponse
import remote.api.auth.likeApi
import util.performApiRequest
import javax.inject.Inject

class likedatasourceImpl @Inject constructor(
    private val likeService: likeApi
): likedatasource {
    override suspend fun createsub(sessionId: String, body: likebodyResponse): Flow<Unit> =
        performApiRequest { likeService.createsub(sessionId = sessionId, body = body) }



    override suspend fun deletesub(sessionId: String, body: likebodyResponse): Flow<Unit> =
        performApiRequest { likeService.deleteesub(sessionId = sessionId, body = body)}
}


