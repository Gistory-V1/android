package remote.datasource

import kotlinx.coroutines.flow.Flow
import remote.dto.auth.request.GAuthLoginRequestBody
import remote.dto.auth.response.GAuthLoginResponse

interface GAuthDataSource {
    fun gAuthSignUp(body: GAuthLoginRequestBody): Flow<Unit>

    fun gAuthLogin(body: GAuthLoginRequestBody) : Flow<GAuthLoginResponse>

    fun gAuthLogout(): Flow<Unit>

    suspend fun gAuthAccess(refreshToken: String): Flow<GAuthLoginResponse>
}