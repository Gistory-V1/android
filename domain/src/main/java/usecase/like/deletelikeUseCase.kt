package usecase.like

import kotlinx.coroutines.flow.Flow
import model.auth.request.likebodyModel
import reopoistory.LikeRepository
import javax.inject.Inject

class deletelikeUseCase @Inject constructor(
    private val likeRepository: LikeRepository
) {
    suspend operator fun invoke(body: likebodyModel, sessionId: String): Flow<Unit> =
        likeRepository.deletelike(
            sessionId = sessionId,
            body = body
        )
}