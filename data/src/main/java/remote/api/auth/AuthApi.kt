package remote.api.auth;


import remote.dto.auth.request.GAuthLoginRequestBody
import remote.dto.auth.response.GAuthLoginResponse
import retrofit2.http.*;

interface AuthApi {
    @POST("/auth")
    suspend fun gAuthLogin(
        @Body body: GAuthLoginRequestBody
    ): GAuthLoginResponse

    @PATCH("/auth")
    suspend fun gAuthAccess(): GAuthLoginResponse

    @DELETE("/auth")
    suspend fun gAuthLogout()
}