package reopoistory

import Model.auth.request.GauthloginRequestBodyModel
import Model.auth.response.GauthloginresponseModel
import kotlinx.coroutines.flow.Flow

interface Authrepoistory {

     fun GAuthLogin(body: GauthloginRequestBodyModel): Flow<GauthloginresponseModel>

     suspend fun GAuthAccess(): Flow<GauthloginresponseModel>

     fun GauthLogout(): Flow<Unit>


}