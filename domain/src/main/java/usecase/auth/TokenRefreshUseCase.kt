package usecase.auth

import model.auth.response.GAuthLoginResponseModel
import kotlinx.coroutines.flow.Flow
import repository.AuthRepository
import javax.inject.Inject

class TokenRefreshUseCase @Inject constructor(
    private val authrepoistory: AuthRepository
) {
   operator suspend fun invoke(refreshToken: String): Flow<GAuthLoginResponseModel> =
       authrepoistory.gAuthAccess(refreshToken = "Bearer $refreshToken")
}