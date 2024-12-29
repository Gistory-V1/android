package usecase.sub

import kotlinx.coroutines.flow.Flow
import model.auth.request.subrequestModel
import reopoistory.subRepository
import javax.inject.Inject

class createlikeUseCase @Inject constructor(
    private val subRepository: subRepository
) {
    suspend operator fun invoke(body: subrequestModel, ): Flow<Unit> =
        subRepository.createlike(
            body = body
        )
}