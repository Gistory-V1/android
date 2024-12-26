package com.kim.Dormitorymanager.datasource
import kotlinx.coroutines.flow.Flow
import remote.api.auth.AuthApi
import remote.datasource.GAuthDataSource
import remote.dto.auth.request.GAuthLoginRequestBody
import remote.dto.auth.response.GAuthLoginResponse
import util.performApiRequest
import javax.inject.Inject

class GAuthDataSourceImpl @Inject constructor(
    private val authService: AuthApi
): GAuthDataSource {
    override fun gAuthSignUp(body: GAuthLoginRequestBody): Flow<Unit> =
        performApiRequest { authService.gAuthsingup(body= body) }

    override fun gAuthLogout(): Flow<Unit> =
        performApiRequest { authService.gAuthLogout() }

    override fun gAuthLogin(body: GAuthLoginRequestBody): Flow<GAuthLoginResponse> =
        performApiRequest { authService.gAuthLogin(body = body) }

    override suspend fun gAuthAccess(refreshToken: String): Flow<GAuthLoginResponse> =
        performApiRequest { authService.gAuthAccess(
            refreshToken = refreshToken
        ) }
}
