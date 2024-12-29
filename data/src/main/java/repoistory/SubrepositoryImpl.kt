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

    override suspend fun createlike( body: subrequestModel): Flow<Unit> = subrDataSource.createlike(

        body = body.toDto()
    )
    override suspend fun deletelike( body: subrequestModel): Flow<Unit> = subrDataSource.deltelike(

        body = body.toDto()
    )

}