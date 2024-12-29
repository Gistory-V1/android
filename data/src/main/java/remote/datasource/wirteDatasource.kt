package remote.datasource

import kotlinx.coroutines.flow.Flow
import remote.dto.auth.request.witecreaterequest
import remote.dto.auth.request.witeputequest
import remote.dto.auth.response.PostResponse
import retrofit2.http.Body
import retrofit2.http.Header

interface wirteDatasource {
    suspend fun createPost(body: witecreaterequest): Flow<Unit>

    suspend fun getPosts(
    ): Flow<List<PostResponse>>

    suspend fun updatePost(body: witeputequest): Flow<Unit>
}