package repoistory

import Model.auth.request.GAuthLoginRequestBodyModel
import Model.auth.response.GAuthLoginResponseModel
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import remote.datasource.GAuthDataSource
import remote.dto.auth.request.toDto
import remote.dto.auth.response.toLogin
import reopoistory.AuthRepository
import javax.inject.Inject

class AuthRepositoryImpl @Inject constructor(
    private val gauthdatasource: GAuthDataSource
) : AuthRepository {
    override  fun GauthLogout(): Flow<Unit> {
       return gauthdatasource.gAuthLogout()
    }

    override suspend fun GAuthAccess(): Flow<GAuthLoginResponseModel> {
      return gauthdatasource.gAuthAccess().map { it.toLogin()  }
    }

    override  fun GAuthLogin(body: GAuthLoginRequestBodyModel): Flow<GAuthLoginResponseModel> {
        return gauthdatasource.gAuthLogin(body = body.toDto()).map { it.toLogin() }
    }
}