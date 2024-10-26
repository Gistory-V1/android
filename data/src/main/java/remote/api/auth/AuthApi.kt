package remote.api.auth;


import remote.dto.auth.request.GauthloginRequestBody
import remote.dto.auth.response.Gauthloginresponse
import retrofit2.http.*;

interface AuthApi {
    @POST("/auth/login")
    suspend fun gauthilogin(
        @Body body: GauthloginRequestBody
    ): Gauthloginresponse
    @PATCH("/auth/login")
    suspend fun gauthAccess(
       @Header("refreshToken") refreshToken: String

    ): Gauthloginresponse
    @DELETE("/auth/logout")
    fun gauthLogout()


}