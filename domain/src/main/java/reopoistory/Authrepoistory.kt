package reopoistory

import Model.auth.request.GauthloginRequestBodyModel
import Model.auth.response.GauthloginresponseModel
import kotlinx.coroutines.flow.Flow

interface Authrepoistory {

     fun GAuthLogin(body: GauthloginRequestBodyModel): Flow<GauthloginresponseModel>

     fun GAuthAccess(refreshToken: String): Flow<GauthloginresponseModel>

     fun GauthLogout(): Flow<Unit>

}