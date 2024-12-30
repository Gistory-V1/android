package remote.api.auth

import remote.dto.auth.request.PostsubResponse
import remote.dto.auth.request.witecreaterequest
import retrofit2.http.Body
import retrofit2.http.DELETE
import retrofit2.http.Header
import retrofit2.http.POST
interface subApi{
    @POST("subs") // 엔드포인트 설정
    suspend fun createlike (
    @Body body: PostsubResponse      // 요청 바디
)
     @DELETE("subs")
     suspend fun deletelike(
         @Body body: PostsubResponse
)
}