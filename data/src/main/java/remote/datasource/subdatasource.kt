package remote.datasource

import kotlinx.coroutines.flow.Flow
import remote.dto.auth.request.PostsubResponse

interface subdatasource {
    suspend fun createlike( body: PostsubResponse): Flow<Unit>

    suspend fun deltelike( body: PostsubResponse): Flow<Unit>

}