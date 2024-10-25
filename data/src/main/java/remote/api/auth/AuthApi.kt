package remote.api.auth;


import remote.dto.auth.request.GauthloginRequestBody
import remote.dto.auth.response.Gauthloginresponse
import retrofit2.http.*;

interface AuthApi {
    @POST("/auth/join")
    suspend fun gauthjoin(
        @Body body: GauthloginRequestBody
    ): Gauthloginresponse
    @PATCH("/auth/login")
    suspend fun gauthLogin(
       @Header("refreshToken") refreshToken: String

    ): Gauthloginresponse
    @DELETE("/auth/logout")
    fun gauthLogout()


}
