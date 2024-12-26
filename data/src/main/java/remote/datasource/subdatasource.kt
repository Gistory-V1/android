package remote.datasource

import kotlinx.coroutines.flow.Flow
import remote.dto.auth.request.PostsubResponse

interface subdatasource {
    suspend fun createlike(sessionId: String, body: PostsubResponse): Flow<Unit>

    suspend fun deltelike(sessionId: String, body: PostsubResponse): Flow<Unit>

}