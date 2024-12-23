package remote.api.auth

import remote.dto.auth.request.PostsubResponse
import retrofit2.http.Body
import retrofit2.http.Header
import retrofit2.http.POST


interface rankAPi {
    @POST("api/sub") // 엔드포인트 설정
    suspend fun createsub(
        @Header("name") name: String, // 동적 헤더
        @Body body: PostsubResponse      // 요청 바디
    )
}