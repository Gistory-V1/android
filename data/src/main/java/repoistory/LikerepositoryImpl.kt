package repoistory

import kotlinx.coroutines.flow.Flow
import model.auth.request.likebodyModel
import remote.datasource.likedatasource
import reopoistory.LikeRepository
import toDto
import javax.inject.Inject

class LikerepositoryImpl @Inject constructor(
    private val likeDataSource: likedatasource
): LikeRepository {

    override suspend fun createlike(sessionId: String, body: likebodyModel): Flow<Unit> =
        likeDataSource.createsub(
            sessionId = sessionId,
            body = body.toDto()
        )

    override suspend fun deletelike(sessionId: String, body: likebodyModel): Flow<Unit> =
        likeDataSource.deletesub(
            sessionId = sessionId,
            body = body.toDto()
        )

}