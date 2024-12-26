package remote.datasource

import kotlinx.coroutines.flow.Flow
import remote.dto.auth.response.profileresponse
import javax.inject.Inject

interface prifileDataSource{
    suspend fun getprofile(name: String): Flow<profileresponse>
}