package usecase.auth

import kotlinx.coroutines.flow.Flow
import model.auth.request.GAuthLoginRequestBodyModel
import model.auth.response.GAuthLoginResponseModel
import repository.AuthRepository
import javax.inject.Inject

class GAuthLoginUseCase @Inject constructor(
    private val authRepository: AuthRepository
) {
     operator fun invoke(body: GAuthLoginRequestBodyModel): Flow<GAuthLoginResponseModel> =
        authRepository.gAuthLogin(body = body)

}