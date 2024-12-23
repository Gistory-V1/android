package remote.api.auth

import okhttp3.Response
import remote.dto.auth.request.witecreaterequest
import remote.dto.auth.response.PostResponse
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.HeaderMap
import retrofit2.http.POST


// Retrofit API 인터페이스
interface wireApi {
    @POST("api/post/create") // 엔드포인트 설정
    suspend fun createPost(
        @Header("sessionId") sessionId: String, // 동적 헤더
        @Body dody: witecreaterequest         // 요청 바디
    )
    @GET("api/post")
    suspend fun getPosts(
        @Header("sessionId") sessionId: String,
        @Header("postId") postId: Int
    ): PostResponse
}

