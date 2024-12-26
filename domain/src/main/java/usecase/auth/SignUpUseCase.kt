package usecase.auth

import model.auth.request.GAuthLoginRequestBodyModel
import repository.AuthRepository
import javax.inject.Inject

class SignUpUseCase @Inject constructor(
    private val authRepository: AuthRepository
)
{
    operator fun invoke(body: GAuthLoginRequestBodyModel) = runCatching {
        authRepository.gAuthSignUp(
            body = body
        )
    }
}