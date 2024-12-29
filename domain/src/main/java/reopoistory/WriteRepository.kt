package reopoistory

import kotlinx.coroutines.flow.Flow
import model.auth.request.witecreaterequestModel
import model.auth.request.writeputModel
import model.auth.response.PostresponseModel

interface WriteRepository{
    suspend fun createPost(body: witecreaterequestModel): Flow<Unit>
    suspend fun getPosts(): Flow<List<PostresponseModel>>
    suspend fun updatePost(body: writeputModel): Flow<Unit>
}