package com.kim.Dormitorymanager.datasource
import kotlinx.coroutines.flow.Flow
import remote.api.auth.AuthApi
import remote.datasource.Gauthdatasource
import remote.dto.auth.request.GauthloginRequestBody
import remote.dto.auth.response.Gauthloginresponse
import utill.performApiRequest
import javax.inject.Inject

class Gauthdatasourceimpl @Inject constructor(
    private val authService: AuthApi
): Gauthdatasource {
    override suspend fun gauthLogout(): Flow<Unit> =
        performApiRequest { authService.gauthLogout() }

    override suspend fun gauthliogin(body: GauthloginRequestBody): Flow<Gauthloginresponse> =
        performApiRequest { authService.gauthilogin(body=body) }


    override suspend fun gauthaccess(refreshToken: String): Flow<Gauthloginresponse> =
        performApiRequest { authService.gauthAccess(refreshToken=refreshToken) }



}
