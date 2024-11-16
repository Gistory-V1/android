package reopoistory

import Model.auth.request.GAuthLoginRequestBodyModel
import Model.auth.response.GAuthLoginResponseModel
import kotlinx.coroutines.flow.Flow

interface AuthRepository {

     fun gAuthLogin(body: GAuthLoginRequestBodyModel): Flow<GAuthLoginResponseModel>

     suspend fun gAuthAccess(): Flow<GAuthLoginResponseModel>

     fun gAuthLogout(): Flow<Unit>

     fun getRefreshToken() : Flow<String>

     suspend fun saveToken(data: GAuthLoginResponseModel)

     suspend fun deleteToken()




}