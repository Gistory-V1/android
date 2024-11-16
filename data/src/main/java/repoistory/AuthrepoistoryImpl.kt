package repoistory

import Model.auth.request.GauthloginRequestBodyModel
import Model.auth.response.GauthloginresponseModel
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import remote.datasource.Gauthdatasource
import remote.dto.auth.request.toDto
import remote.dto.auth.response.toLogin
import reopoistory.Authrepoistory
import javax.inject.Inject

class AuthrepoistoryImpl @Inject constructor(
    private val gauthdatasource: Gauthdatasource
) : Authrepoistory {
    override  fun GauthLogout(): Flow<Unit> {
       return gauthdatasource.gauthLogout()
    }

    override suspend fun GAuthAccess(): Flow<GauthloginresponseModel> {
      return gauthdatasource.gauthaccess().map { it.toLogin()  }
    }

    override  fun GAuthLogin(body: GauthloginRequestBodyModel): Flow<GauthloginresponseModel> {
        return gauthdatasource.gauthliogin(body = body.toDto()).map { it.toLogin() }
    }
}