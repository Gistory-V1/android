package util

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn

internal inline fun <reified T> performApiRequest(crossinline apiCall: suspend () -> T):
        Flow<T> = flow {
    emit(
        DMAPIHandier<T>()
            .httpRequest{ apiCall() }
            .sendRequest()
    )
}.flowOn(Dispatchers.IO)