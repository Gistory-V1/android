package remote.datasource

import kotlinx.coroutines.flow.Flow
import remote.api.auth.wireApi
import remote.dto.auth.request.witecreaterequest
import remote.dto.auth.request.witeputequest
import remote.dto.auth.response.PostResponse
import util.performApiRequest
import javax.inject.Inject

class writeDatasouceImpl @Inject constructor(
    private val wirteService: wireApi
): wirteDatasource {
    override suspend fun createPost(body: witecreaterequest): Flow<Unit> =
        performApiRequest { wirteService.createPost(body = body) }

    override suspend fun getPosts(): Flow<List<PostResponse>> =
        performApiRequest { wirteService.getPosts() }

    override suspend fun updatePost(body: witeputequest): Flow<Unit> =
        performApiRequest { wirteService.updatePost(body = body) }







}