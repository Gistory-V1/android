package repoistory

import Model.auth.request.GauthloginRequestBodyModel
import Model.auth.response.GauthloginresponseModel
import kotlinx.coroutines.flow.Flow
import reopoistory.Authrepoistory
import javax.inject.Inject

class Authrepoistoryimpl @Inject constructor(
) : Authrepoistory {
    override fun GauthLogout(): Flow<Unit> {
        TODO("Not yet implemented")
    }

    override  fun GAuthAccess(refreshToken: String): Flow<GauthloginresponseModel> {
        TODO("Not yet implemented")
    }

    override  fun GAuthLogin(body: GauthloginRequestBodyModel): Flow<GauthloginresponseModel> {
        TODO("Not yet implemented")
    }
}