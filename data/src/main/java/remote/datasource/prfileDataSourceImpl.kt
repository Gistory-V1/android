package remote.datasource

import kotlinx.coroutines.flow.Flow
import remote.api.auth.profileApi
import remote.dto.auth.response.profileresponse
import util.performApiRequest
import javax.inject.Inject

class prfileDataSourceImpl @Inject constructor(
    private val profileService: profileApi
) : prifileDataSource {
    override suspend fun getprofile(name: String): Flow<profileresponse> =
        performApiRequest { profileService.getprofile(name = name) }


}