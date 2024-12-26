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
    override suspend fun createPost(sessionId: String,body: witecreaterequest): Flow<Unit> =
        performApiRequest { wirteService.createPost(body = body,sessionId = sessionId) }

    override suspend fun getPosts(sessionId: String,postId: Int): Flow<List<PostResponse>> =
        performApiRequest { wirteService.getPosts(sessionId = sessionId, postId = postId) }

    override suspend fun updatePost(sessionId: String,body: witeputequest): Flow<Unit> =
        performApiRequest { wirteService.updatePost(body = body,sessionId = sessionId) }







}