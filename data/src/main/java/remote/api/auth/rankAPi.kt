package remote.api.auth

import remote.dto.auth.request.PostsubResponse
import remote.dto.auth.response.top5response
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.POST


interface rankAPi {
    @GET("rank-like") // 엔드포인트 설정
    suspend fun Ranklike(

    ) :List<top5response>
}