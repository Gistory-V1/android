package view.login.screen

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.kim.presentation.R
import view.login.component.DoMaSinupButton
import view.login.component.PasswordTextField
import view.login.component.GomsTextField
@Composable
internal fun SiginUpRoute(
    onBackClick: () -> Unit,
    onNumberClick: () -> Unit,

){

}

@Composable
fun SignUPScreen(
    modifier: Modifier = Modifier,
    email: String,
    onEmailChange: (String) -> Unit,
    isError1: Boolean,
    isError2: Boolean,
    onBackClick: () -> Unit,
    onNumberClick: () -> Unit,

    ) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,

        modifier = modifier
            .fillMaxSize()
            .background(color = Color(0xFFFFFFFF))

    ) {
        Row(
            modifier = modifier
                .fillMaxWidth()

                .padding(top = 70.dp, start = 34.dp, end = 34.dp),
            horizontalArrangement = Arrangement.Center




        ){

            Text(
                text = "SIGN UP",
                style = TextStyle(
                    fontSize = 32.sp,
                    fontWeight = FontWeight(600),
                    color = Color(0xFF000000),
                    textAlign = TextAlign.Center,
                    )
            )

        }
        Column(
            modifier = modifier
                .fillMaxWidth(),

        ){
            Column(
                modifier = modifier
                    .fillMaxWidth()
            ) {
                Text(
                    modifier = Modifier.padding(start = 18.dp),

                    text = "이메일",
                    style = TextStyle(
                        fontSize = 14.sp,
                        fontWeight = FontWeight(400),
                        color = Color(0xFF111111),
                        textAlign = TextAlign.Start
                    )
                )
                GomsTextField(
                    keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Email),
                    placeHolder = stringResource(id = R.string.email),
                    setText = email,
                    onValueChange = onEmailChange,
                    isError1 = isError1,
                    singleLine = true


                )
            }
            Column(
                modifier = modifier
                    .fillMaxWidth()
            ) {
                Text(
                    modifier = Modifier.padding(start = 18.dp),

                    text = "비밀번호",
                    style = TextStyle(
                        fontSize = 14.sp,
                        fontWeight = FontWeight(400),
                        color = Color(0xFF111111),
                        textAlign = TextAlign.Start
                    )
                )
                PasswordTextField(

                    placeHolder = stringResource(id = R.string.password),
                    setText = email,
                    onValueChange = onEmailChange,
                    isError2 = isError2,

                )
            }
            Column(
                modifier = modifier
                    .fillMaxWidth()
            ) {
                Text(
                    modifier = Modifier.padding(start = 18.dp),

                    text = "비밀번호 확인",
                    style = TextStyle(
                        fontSize = 14.sp,
                        fontWeight = FontWeight(400),
                        color = Color(0xFF111111),
                        textAlign = TextAlign.Start
                    )
                )
                PasswordTextField(

                    placeHolder = stringResource(id = R.string.check_password),
                    setText = email,
                    onValueChange = onEmailChange,
                    isError2 = isError2,

                    )
                }
            Spacer(modifier = Modifier.height(230.dp))

            DoMaSinupButton {
                
            }



        }

    }
}


@Preview
@Composable
fun PreviewLoginScreen() {
    SignUPScreen(
        email = "",
        onEmailChange = {},
        isError1 = false,
        isError2 = true,
        onBackClick = {},
        onNumberClick = {}
    )
}

