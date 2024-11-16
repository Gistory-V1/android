package Usecase.auth

import Model.auth.response.GAuthLoginResponseModel
import kotlinx.coroutines.flow.Flow
import reopoistory.AuthRepository
import javax.inject.Inject

class TokenRefreshUseCase @Inject constructor(
    private val authrepoistory: AuthRepository
) {
   operator suspend fun invoke(refreshToken: String): Flow<GAuthLoginResponseModel> =
       authrepoistory.GAuthAccess()
}