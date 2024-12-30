package remote.api.auth

import okhttp3.Response
import remote.dto.auth.request.witecreaterequest
import remote.dto.auth.request.witeputequest
import remote.dto.auth.response.PostResponse
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.HeaderMap
import retrofit2.http.POST
import retrofit2.http.PUT


// Retrofit API 인터페이스
interface wireApi {
    @POST("post/create") // 엔드포인트 설정
    suspend fun createPost(

        @Body body: witecreaterequest         // 요청 바디
    )
    @GET("post")
    suspend fun getPosts(

    ): List<PostResponse>
    @PUT("post/update")
    suspend fun updatePost(
        @Body body: witeputequest
    )

}

