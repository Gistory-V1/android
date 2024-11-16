package repoistory

import Model.auth.request.GAuthLoginRequestBodyModel
import Model.auth.response.GAuthLoginResponseModel
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import local.datasource.LocalDataSource
import remote.datasource.GAuthDataSource
import remote.dto.auth.request.toDto
import remote.dto.auth.response.toLogin
import reopoistory.AuthRepository
import javax.inject.Inject

class AuthRepositoryImpl @Inject constructor(
    private val gAuthDatasource: GAuthDataSource,
    private val localDataSource: LocalDataSource

) : AuthRepository {
    override fun gAuthLogout(): Flow<Unit> {
       return gAuthDatasource.gAuthLogout()
    }

    override suspend fun gAuthAccess(): Flow<GAuthLoginResponseModel> {
      return gAuthDatasource.gAuthAccess().map { it.toLogin()  }
    }

    override  fun gAuthLogin(body: GAuthLoginRequestBodyModel): Flow<GAuthLoginResponseModel> {
        return gAuthDatasource.gAuthLogin(body = body.toDto()).map { it.toLogin() }
    }

    override fun getRefreshToken(): Flow<String> {
      return localDataSource.getRefreshToken()
    }

    override suspend fun saveToken(data: GAuthLoginResponseModel) {
        localDataSource.setAccessToken(data.accessToken)
        localDataSource.setRefreshToken(data.refreshToken)
        localDataSource.setAccessTime(data.accessTokenExpiresIn)
        localDataSource.setRefreshTime(data.refreshTokenExpiresIn)
    }

    override suspend fun deleteToken() {
        localDataSource.deleteAccessToken()
        localDataSource.deleteRefreshToken()
        localDataSource.deleteAccessTime()
        localDataSource.deleteRefreshTime()
    }
}