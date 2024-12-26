package remote.datasource

import kotlinx.coroutines.flow.Flow
import likebodyResponse

interface  likedatasource {
    suspend fun createsub(sessionId: String, body: likebodyResponse): Flow<Unit>

    suspend fun  deletesub(sessionId: String, body: likebodyResponse): Flow<Unit>


}