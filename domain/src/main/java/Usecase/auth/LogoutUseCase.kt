package Usecase.auth

import reopoistory.Authrepoistory
import javax.inject.Inject

class LogoutUseCase @Inject constructor(
    private val authrepoistory: Authrepoistory
) {
    operator fun  invoke()=runCatching{
        authrepoistory.GauthLogout()

    }
}