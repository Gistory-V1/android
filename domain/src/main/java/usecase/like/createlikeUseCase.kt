package usecase.like

import kotlinx.coroutines.flow.Flow
import model.auth.request.likebodyModel
import reopoistory.LikeRepository
import javax.inject.Inject

class createlikeUseCase @Inject constructor(
    private val likeRepository: LikeRepository
){
    operator suspend fun invoke(body: likebodyModel,sessionId: String): Flow<Unit> =
        likeRepository.createlike(
            sessionId = sessionId,
            body = body
        )

}
