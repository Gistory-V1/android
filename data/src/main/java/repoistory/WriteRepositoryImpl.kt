package repoistory

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import model.auth.request.witecreaterequestModel
import model.auth.request.writeputModel
import model.auth.response.PostresponseModel
import remote.datasource.wirteDatasource
import remote.datasource.writeDatasouceImpl
import remote.dto.auth.request.toDto
import remote.dto.auth.response.toModel
import reopoistory.WriteRepository
import javax.inject.Inject

class WriteRepositoryImpl @Inject constructor(
    private val writeDatasource: wirteDatasource

) : WriteRepository {
    override suspend fun createPost(sessionId: String,body: witecreaterequestModel): Flow<Unit> =
        writeDatasource.createPost(body= body.toDto(), sessionId = sessionId)


    override suspend fun getPosts(sessionId: String, postId: Int): Flow<List<PostresponseModel>> =
        writeDatasource.getPosts(sessionId=sessionId, postId=postId).map { list -> list.map { it.toModel() } }

    override suspend fun updatePost(
        sessionId: String,
        body: writeputModel
    ): Flow<Unit> =
        writeDatasource.updatePost(
           body = body.toDto(),
            sessionId = sessionId
        )

}