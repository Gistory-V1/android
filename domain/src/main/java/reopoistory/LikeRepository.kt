package reopoistory

import kotlinx.coroutines.flow.Flow
import model.auth.request.likebodyModel

interface LikeRepository {
    suspend fun createlike( body: likebodyModel): Flow<Unit>
    suspend fun deletelike(body: likebodyModel): Flow<Unit>

}