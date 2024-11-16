package Usecase.auth

import Model.auth.request.GAuthLoginRequestBodyModel
import reopoistory.AuthRepository
import javax.inject.Inject

class GAuthLoginUseCase @Inject constructor(
    private val authrepoistory: AuthRepository
) {
     operator fun invoke(body: GAuthLoginRequestBodyModel) = runCatching {
        authrepoistory.GAuthLogin(body = body)

    }
}