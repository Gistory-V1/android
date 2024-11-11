package Usecase.auth

import Model.auth.request.GauthloginRequestBodyModel
import reopoistory.Authrepoistory
import javax.inject.Inject

class GAuthLoginUseCase @Inject constructor(
    private val authrepoistory: Authrepoistory
) {
     operator fun invoke(body: GauthloginRequestBodyModel) = runCatching {
        authrepoistory.GAuthLogin(body = body)

    }
}