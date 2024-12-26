package remote.datasource

import kotlinx.coroutines.flow.Flow
import remote.dto.auth.request.witecreaterequest
import remote.dto.auth.request.witeputequest
import remote.dto.auth.response.PostResponse
import retrofit2.http.Body
import retrofit2.http.Header

interface wirteDatasource {
    suspend fun createPost(sessionId: String,body: witecreaterequest): Flow<Unit>

    suspend fun getPosts(sessionId: String,
                         postId: Int): Flow<List<PostResponse>>

    suspend fun updatePost(sessionId: String,body: witeputequest): Flow<Unit>
}