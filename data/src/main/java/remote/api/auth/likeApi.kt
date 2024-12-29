package remote.api.auth

import likebodyResponse
import retrofit2.http.Body
import retrofit2.http.DELETE
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.POST

interface likeApi{
    @POST("api/like") // 엔드포인트 설정
    suspend fun createsub( // 동적 헤더
        @Body body: likebodyResponse      // 요청 바디
    )
    @DELETE("api/like")
    suspend fun deleteesub( // 동적 헤더
        @Body body: likebodyResponse      // 요청 바디
    )


}