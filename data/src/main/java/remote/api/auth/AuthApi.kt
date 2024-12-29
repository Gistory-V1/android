package remote.api.auth;


import remote.dto.auth.request.GAuthLoginRequestBody
import remote.dto.auth.response.GAuthLoginResponse
import retrofit2.http.*;

interface AuthApi {
    @POST("auth/signup")
    suspend fun gAuthsingup(
        @Body body: GAuthLoginRequestBody
    )

    @POST("auth/login")
    suspend fun gAuthLogin(
        @Body body: GAuthLoginRequestBody
    ): GAuthLoginResponse

    @PATCH("auth/reissue")
    suspend fun gAuthAccess(
        @Header("refreshToken") refreshToken: String
    ): GAuthLoginResponse

    @DELETE("/logout")
    suspend fun gAuthLogout()
}