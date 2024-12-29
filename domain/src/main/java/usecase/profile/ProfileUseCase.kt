package usecase.profile

import kotlinx.coroutines.flow.Flow
import model.auth.response.prfilereponseModel
import reopoistory.ProfileRepository
import javax.inject.Inject

class ProfileUseCase @Inject constructor(
    private val profileRepository: ProfileRepository
) {
    operator suspend fun  invoke(name: String): Flow<prfilereponseModel> =
        profileRepository.profile(name = name)
}