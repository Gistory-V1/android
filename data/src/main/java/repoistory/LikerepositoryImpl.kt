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

    override suspend fun createlike( body: likebodyModel): Flow<Unit> =
        likeDataSource.createsub(
            body = body.toDto()
        )

    override suspend fun deletelike( body: likebodyModel): Flow<Unit> =
        likeDataSource.deletesub(
            body = body.toDto()
        )

}