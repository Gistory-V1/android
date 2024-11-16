package Model.auth.response

data class GAuthLoginResponseModel (
     val accessToken: String,
     val refreshToken: String,
     val accessTokenExpiresIn: String,
     val refreshTokenExpiresIn: String,

    )