package remote.datasource

import kotlinx.coroutines.flow.Flow
import likebodyResponse
import remote.api.auth.likeApi
import util.performApiRequest
import javax.inject.Inject

class likedatasourceImpl @Inject constructor(
    private val likeService: likeApi
): likedatasource {
    override suspend fun createsub( body: likebodyResponse): Flow<Unit> =
        performApiRequest { likeService.createsub( body = body) }



    override suspend fun deletesub( body: likebodyResponse): Flow<Unit> =
        performApiRequest { likeService.deleteesub( body = body)}
}


