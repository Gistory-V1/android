package remote.datasource

import kotlinx.coroutines.flow.Flow
import remote.dto.auth.request.GauthloginRequestBody
import remote.dto.auth.response.Gauthloginresponse

interface Gauthdatasource {
    fun gauthliogin(body: GauthloginRequestBody) : Flow<Gauthloginresponse>

    suspend fun gauthLogout(): Flow<Unit>

    suspend fun gauthaccess(): Flow<Gauthloginresponse>
}