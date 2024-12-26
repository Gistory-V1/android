package usecase.sub

import kotlinx.coroutines.flow.Flow
import model.auth.request.subrequestModel
import reopoistory.subRepository
import javax.inject.Inject

class createlikeUseCase @Inject constructor(
    private val subRepository: subRepository
) {
    suspend operator fun invoke(body: subrequestModel, sessionId: String): Flow<Unit> =
        subRepository.createlike(
            sessionId = sessionId,
            body = body
        )
}