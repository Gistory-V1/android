package usecase.like

import kotlinx.coroutines.flow.Flow
import model.auth.request.likebodyModel
import reopoistory.LikeRepository
import javax.inject.Inject

class createlikeUseCase @Inject constructor(
    private val likeRepository: LikeRepository
){
    suspend operator fun invoke(body: likebodyModel): Flow<Unit> =
        likeRepository.createlike(

            body = body
        )

}
