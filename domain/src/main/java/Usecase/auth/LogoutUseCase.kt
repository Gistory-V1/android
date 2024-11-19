package usecase.auth

import repository.AuthRepository
import javax.inject.Inject

class LogoutUseCase @Inject constructor(
    private val authrepoistory: AuthRepository
) {
    operator fun invoke()=runCatching{
        authrepoistory.gAuthLogout()

    }
}