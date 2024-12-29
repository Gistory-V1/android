package repoistory

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import model.auth.request.witecreaterequestModel

import model.auth.response.PostresponseModel
import model.wirte.request.writeputModel
import remote.datasource.wirteDatasource
import remote.datasource.writeDatasouceImpl
import remote.dto.auth.request.toDto
import remote.dto.auth.response.toModel
import reopoistory.WriteRepository
import javax.inject.Inject

class WriteRepositoryImpl @Inject constructor(
    private val writeDatasource: wirteDatasource

) : WriteRepository {
    override suspend fun createPost(body: witecreaterequestModel): Flow<Unit> =
        writeDatasource.createPost(body= body.toDto(), )


    override suspend fun getPosts(): Flow<List<PostresponseModel>> =
        writeDatasource.getPosts().map { list -> list.map { it.toModel() } }

    override suspend fun updatePost(
        body: model.auth.request.writeputModel
    ): Flow<Unit> =
        writeDatasource.updatePost(
            body = body.toDto(),

        )




}