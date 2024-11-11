package Usecase.auth

import Model.auth.response.GauthloginresponseModel
import kotlinx.coroutines.flow.Flow
import reopoistory.Authrepoistory
import javax.inject.Inject

class TokenRefreshUsecase @Inject constructor(
    private val authrepoistory: Authrepoistory
) {

   operator suspend fun invoke(refreshToken: String): Flow<GauthloginresponseModel> =
       authrepoistory.GAuthAccess(refreshToken=refreshToken)
}