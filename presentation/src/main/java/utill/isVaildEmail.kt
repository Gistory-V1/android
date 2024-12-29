package utill

import kotlin.text.Regex

fun isValidEmail(email: String): Boolean {
    return utill.Regex.EMAIL.toRegex().matches(email)
}