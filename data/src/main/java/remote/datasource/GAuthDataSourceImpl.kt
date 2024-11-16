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
    override fun gAuthLogout(): Flow<Unit> =
        performApiRequest { authService.gAuthLogout() }

    override fun gAuthLogin(body: GAuthLoginRequestBody): Flow<GAuthLoginResponse> =
        performApiRequest { authService.gAuthiLogin(body=body) }

    override suspend fun gAuthAccess(): Flow<GAuthLoginResponse> =
        performApiRequest { authService.gAuthAccess() }
}
