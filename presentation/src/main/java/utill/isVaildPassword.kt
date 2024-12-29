package utill

import kotlin.text.Regex

fun isValidPassword(password: String): Boolean {
    return utill.Regex.PASSWORD.toRegex().matches(password)
}