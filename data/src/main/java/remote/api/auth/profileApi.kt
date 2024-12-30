package remote.api.auth

import remote.dto.auth.response.profileresponse
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.Header

interface profileApi {


    @GET("profile")
    suspend fun getprofile(
        @Header("name") name: String,
    ): profileresponse
}