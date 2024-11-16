package reopoistory

import Model.auth.request.GAuthLoginRequestBodyModel
import Model.auth.response.GAuthLoginResponseModel
import kotlinx.coroutines.flow.Flow

interface AuthRepository {

     fun GAuthLogin(body: GAuthLoginRequestBodyModel): Flow<GAuthLoginResponseModel>

     suspend fun GAuthAccess(): Flow<GAuthLoginResponseModel>

     fun GauthLogout(): Flow<Unit>
}