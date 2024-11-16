package Usecase.auth

import reopoistory.AuthRepository
import javax.inject.Inject

class LogoutUseCase @Inject constructor(
    private val authrepoistory: AuthRepository
) {
    operator fun  invoke()=runCatching{
        authrepoistory.gAuthLogout()

    }
}