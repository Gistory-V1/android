package usecase.auth

import model.auth.request.GAuthLoginRequestBodyModel
import repository.AuthRepository
import javax.inject.Inject

class GAuthLoginUseCase @Inject constructor(
    private val authRepository: AuthRepository
) {
     operator fun invoke(body: GAuthLoginRequestBodyModel) = runCatching {
        authRepository.gAuthLogin(body = body)

    }
}