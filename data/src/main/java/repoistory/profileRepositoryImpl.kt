package repoistory

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import model.auth.response.PostresponseModel
import model.auth.response.prfilereponseModel
import remote.datasource.prifileDataSource
import remote.dto.auth.response.toModel
import reopoistory.ProfileRepository
import javax.inject.Inject

class profileRepositoryImpl @Inject constructor(
    private val profileDataSource: prifileDataSource

) : ProfileRepository{
    override suspend fun profile(name: String,): Flow<prfilereponseModel> =
        profileDataSource.getprofile(
            name = name,
        ).map { it.toModel() }
}