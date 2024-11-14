package remote.api.auth;


import remote.dto.auth.request.GauthloginRequestBody
import remote.dto.auth.response.Gauthloginresponse
import retrofit2.http.*;

interface AuthApi {
    @POST("/auth")
    suspend fun gauthilogin(
        @Body body: GauthloginRequestBody
    ): Gauthloginresponse

    @PATCH("/auth")
    suspend fun gauthAccess(): Gauthloginresponse

    @DELETE("/auth")
    fun gauthLogout()
}