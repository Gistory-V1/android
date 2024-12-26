package reopoistory

import kotlinx.coroutines.flow.Flow
import model.auth.request.witecreaterequestModel
import model.auth.request.writeputModel
import model.auth.response.PostresponseModel

interface WriteRepository{
    suspend fun createPost(sessionId: String,body: witecreaterequestModel): Flow<Unit>
    suspend fun getPosts(sessionId: String, postId: Int): Flow<List<PostresponseModel>>
    suspend fun updatePost(sessionId: String,postId: Long,body: witecreaterequestModel): Flow<Unit>
}