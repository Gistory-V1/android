package utill

import expection.NeedLoginException
import java.util.Locale
import java.text.SimpleDateFormat
import java.util.Calendar

private val dataFormat = SimpleDateFormat("yyyy-MM-DD'T'HH:mm:ss", Locale.getDefault())

fun String.toDate() = runCatching {
    dataFormat.parse(this)
}.getOrElse {
    throw NeedLoginException()
} ?: throw NeedLoginException()

fun getDate() = dataFormat.format(Calendar.getInstance().time).toDate()
