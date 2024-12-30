package util

import kotlinx.coroutines.flow.first
import kotlinx.coroutines.runBlocking
import local.datasource.LocalDataSource
import okhttp3.Authenticator
import okhttp3.Request
import okhttp3.Response
import okhttp3.Route
import remote.api.auth.AuthApi
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import javax.inject.Inject

class TokenAuthenticator @Inject constructor(
    private val localDataSource: LocalDataSource
) : Authenticator {
    override fun authenticate(route: Route?, response: Response): Request? {
        val refreshToken = runBlocking { localDataSource.getRefreshToken().first().replace("\"","") }
        val newAccessToken = refreshAccessToken(refreshToken)
        return if (newAccessToken.isNullOrEmpty()){
            null
        }else{
            response.request.newBuilder()
                .header("Authorization","Bearer $newAccessToken")
                .build()
        }
    }
    private fun refreshAccessToken(refreshToken: String): String? {
        return try {
            val retrofit = Retrofit.Builder()
                .baseUrl("https://port-0-gistory-server-v1-m47qofx19aae55ab.sel4.cloudtype.app/")
                .addConverterFactory(MoshiConverterFactory.create())
                .build()

            val authApi = retrofit.create(AuthApi::class.java)
            val response = runBlocking { authApi.gAuthAccess(
                refreshToken = refreshToken
            ) }
            runBlocking {
                with(localDataSource){
                    setAccessToken(response.accessToken)
                    setAccessTime(response.accessTokenExpiresIn)
                    setRefreshToken(response.refreshToken)
                    setRefreshTime(response.refreshTokenExpiresIn)
                }

            }
            response.accessToken
        }catch (e: Exception){
            null
        }
    }
}
