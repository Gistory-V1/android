package reopoistory

import kotlinx.coroutines.flow.Flow
import model.auth.request.likebodyModel

interface LikeRepository {
    suspend fun createlike(sessionId: String, body: likebodyModel): Flow<Unit>
    suspend fun deletelike(sessionId: String, body: likebodyModel): Flow<Unit>

}