package utill

object Regex {
    const val EMAIL = "^s\\d{5}@gsm\\.hs\\.kr$"
    const val PASSWORD = "^(?=.*[a-zA-Z])(?=.*[!@#\\\$%^*+=-?<>])(?=.*[0-9]).{6,}\$"
}