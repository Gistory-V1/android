package remote.datasource

import kotlinx.coroutines.flow.Flow
import remote.dto.auth.request.GAuthLoginRequestBody
import remote.dto.auth.response.GAuthLoginResponse

interface GAuthDataSource {
    fun gAuthLogin(body: GAuthLoginRequestBody) : Flow<GAuthLoginResponse>

    fun gAuthLogout(): Flow<Unit>

    suspend fun gAuthAccess(): Flow<GAuthLoginResponse>
}