package usecase.rank

import kotlinx.coroutines.flow.Flow
import model.auth.response.top5responsemodel
import reopoistory.rankRepository
import javax.inject.Inject

class RankUseCase @Inject constructor(
    private val rankRepository: rankRepository
) {
    suspend operator fun invoke(): Flow<List<top5responsemodel>> =
        rankRepository.Ranklike()

}