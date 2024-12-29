package reopoistory

import kotlinx.coroutines.flow.Flow
import model.auth.request.subrequestModel

interface subRepository {
    suspend fun createlike( body: subrequestModel): Flow<Unit>


    suspend fun deletelike( body: subrequestModel): Flow<Unit>

}