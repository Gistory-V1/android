package Model.auth.response


data class GauthloginresponseModel (
     val accessToken: String,
     val refreshToken: String,
     val accessTokenExpiresIn: String,
     val refreshTokenExpiresIn: String,

    )