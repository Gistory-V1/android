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
    private val gauthDatasource: GAuthDataSource
) : AuthRepository {
    override fun gAuthLogout(): Flow<Unit> {
       return gauthDatasource.gAuthLogout()
    }

    override suspend fun gAuthAccess(): Flow<GAuthLoginResponseModel> {
      return gauthDatasource.gAuthAccess().map { it.toLogin()  }
    }

    override  fun gAuthLogin(body: GAuthLoginRequestBodyModel): Flow<GAuthLoginResponseModel> {
        return gauthDatasource.gAuthLogin(body = body.toDto()).map { it.toLogin() }
    }
}