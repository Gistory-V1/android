package expection

class NeedLoginException : RuntimeException() {
    override val message: String
        get() = "토큰이 만료되었습니다. 다시 로그인 해주세요"
}