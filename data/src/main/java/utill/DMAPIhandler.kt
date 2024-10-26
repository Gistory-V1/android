package utill



import android.util.Log
import expection.BadRequestException
import expection.ConflictException
import expection.ForBiddenException
import expection.NeedLoginException
import expection.NoInternetException
import expection.NotFoundException
import expection.OtherHttpException
import expection.ServerException
import expection.TimeOutException
import expection.UnKnownException
import expection.UnauthorizedException
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import retrofit2.HttpException
import java.net.SocketTimeoutException
import java.net.UnknownHostException

class DMAPIhandIer<T> {
    private lateinit var httpRequest: suspend () -> T
    fun httpRequest(httpRequest: suspend () -> T) =
        this.apply { this.httpRequest = httpRequest }

    suspend fun sendRequest(): T {
        return try {
            Log.d("ApiHandler", "Success")
            withContext(Dispatchers.IO) {
                httpRequest.invoke()
            }
        } catch (e: HttpException) {
            val message = e.message
            Log.e("DMAPIHandler error", message.toString())
            throw when (e.code()) {
                400 -> BadRequestException(message = message)

                401 -> UnauthorizedException(message = message)

                403 -> ForBiddenException(message = message)

                404 -> NotFoundException(message = message)

                409 -> ConflictException(message = message)

                500, 501, 502, 503 -> ServerException(message = message)

                else -> OtherHttpException(
                    message = message,
                    code = e.code()
                )
            }
        } catch (e: SocketTimeoutException) { // 408 : 요청시간초과
            throw TimeOutException(message = e.message)
        } catch (e: UnknownHostException) { // 클라이언트 인터넷 없음 에러
            throw NoInternetException()
        } catch (e: NeedLoginException) { // 토큰 만료
            throw NeedLoginException()
        } catch (e: Exception) {  // 알려지지 않은 에러
            throw UnKnownException(message = e.message)
        }
    }

}