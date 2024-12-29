package util


import kotlinx.coroutines.flow.first
import kotlinx.coroutines.runBlocking
import local.datasource.LocalDataSource
import okhttp3.Interceptor
import okhttp3.Response
import javax.inject.Inject

class AuthInterceptor @Inject constructor(
    private val dataSource: LocalDataSource
) : Interceptor {
    private val ignore by lazy {"/auth"}

    private companion object {
        const val POST = "POST"
        const val GET = "GET"
        const val DELETE = "DELETE"
        const val PATCH = "PATCH"
    }

    override fun intercept(chain: Interceptor.Chain): Response {
        val request = chain.request()
        val path = request.url.encodedPath
        val method = request.method
        val accessToken = runBlocking { dataSource.getAccessToken().first().replace("\"","") }
        val refreshToken = runBlocking { dataSource.getRefreshToken().first().replace("\"","") }

        val newRequest = when{
            ignore.any { path.contains(it) && method in listOf(POST, GET, DELETE)} -> {
                request
            }
            path.endsWith("/auth") && method in listOf(PATCH)-> {
                request.newBuilder().addHeader("Authorization", "$refreshToken").build()
            }
            else -> {
                request.newBuilder().addHeader("Authorization","Bearer $accessToken" ).build()
            }
        }
        val response = chain.proceed(newRequest)

        return when(response.code){
            201, 204-> response.newBuilder().code(200).build()
            else -> response
        }
    }
}









