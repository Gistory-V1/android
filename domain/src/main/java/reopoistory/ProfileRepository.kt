package reopoistory

import kotlinx.coroutines.flow.Flow
import model.auth.request.subrequestModel
import model.auth.response.prfilereponseModel

interface ProfileRepository {
      suspend fun profile(name: String): Flow<prfilereponseModel>
}