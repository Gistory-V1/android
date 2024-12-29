package remote.datasource

import kotlinx.coroutines.flow.Flow
import likebodyResponse

interface  likedatasource {
    suspend fun createsub( body: likebodyResponse): Flow<Unit>

    suspend fun  deletesub( body: likebodyResponse): Flow<Unit>


}