package reopoistory

import Model.auth.request.GauthloginRequestBodyModel
import Model.auth.response.GauthloginresponseModel
import kotlinx.coroutines.flow.Flow

interface Authrepoistory {

    suspend fun GAuthLogin(body: GauthloginRequestBodyModel): Flow<GauthloginresponseModel>

    suspend fun GAuthAccess(refreshToken: String): Flow<GauthloginresponseModel>

    suspend fun GauthLogout(): Flow<Unit>

}