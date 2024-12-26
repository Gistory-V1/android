package model.auth.request

import android.provider.ContactsContract.CommonDataKinds.Email

data class GAuthLoginRequestBodyModel(
    val email:  String,
    val password: String,
)