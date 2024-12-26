package reopoistory

import kotlinx.coroutines.flow.Flow
import model.auth.request.subrequestModel

interface subRepository {
    suspend fun createlike(sessionId: String, body: subrequestModel): Flow<Unit>


    suspend fun deletelike(name: String, body: subrequestModel): Flow<Unit>

}