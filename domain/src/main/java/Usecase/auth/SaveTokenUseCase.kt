package usecase.auth

import model.auth.response.GAuthLoginResponseModel
import repository.AuthRepository
import javax.inject.Inject

class SaveTokenUseCase @Inject constructor(
    private val authRepository: AuthRepository
){
    suspend operator fun invoke(data: GAuthLoginResponseModel) = runCatching{
        authRepository.saveToken(data = data)
    }
}