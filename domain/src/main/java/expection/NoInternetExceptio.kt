package expection

class NoInternetException: RuntimeException() {
    override val message: String
        get() = "네트워크가 불안정합니다"
}