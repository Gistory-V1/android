package repoistory

import kotlinx.coroutines.flow.Flow
import model.auth.request.subrequestModel
import remote.datasource.subdatasource
import remote.dto.auth.request.toDto
import reopoistory.subRepository
import javax.inject.Inject

class SubrepositoryImpl @Inject constructor(
    private val subrDataSource: subdatasource

): subRepository{

    override suspend fun createlike(sessionId: String, body: subrequestModel): Flow<Unit> = subrDataSource.createlike(
        sessionId = sessionId,
        body = body.toDto()
    )
    override suspend fun deletelike(sessionId: String, body: subrequestModel): Flow<Unit> = subrDataSource.deltelike(
        sessionId = sessionId,
        body = body.toDto()
    )

}