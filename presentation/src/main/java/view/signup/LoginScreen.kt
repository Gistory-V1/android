package view.signup

import android.content.pm.ActivityInfo
import androidx.compose.animation.core.animateDpAsState
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
import androidx.compose.runtime.DisposableEffect
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.kim.presentation.R
import model.auth.request.GAuthLoginRequestBodyModel
import utill.ResourceKeys
import utill.keyboardAsState
import utill.lockScreenOrientation
import view.login.component.DoMaGAthButton
import view.login.component.DoMaSinupButton
import view.login.component.GomsTextField
import view.login.component.PasswordTextField
import view.signup.UiState.LoginUiState
import view.signup.UiState.SaveTokenUiState
import view.signup.viewmodel.Loginviewmodel


@Composable
internal fun InputLoginRoute(
    onBackClick: () -> Unit,
    onMainClick: () -> Unit,
    navigateToMain: () -> Unit,
    viewModel: Loginviewmodel = hiltViewModel()
){
    val loginUiState by viewModel.loginUiState.collectAsStateWithLifecycle()
    val saveTokenUiState by viewModel.saveTokenUiState.collectAsStateWithLifecycle()
    val email by viewModel.email.collectAsStateWithLifecycle()
    val password by viewModel.password.collectAsStateWithLifecycle()
    LoginScreen(
        email = email,
        onEmailChange = viewModel::onEmailChange,
        isError1 = false,
        isError2 = false,
        onBackClick = onBackClick,
        loginUiState = loginUiState,
        saveTokenUiState = saveTokenUiState,
        onPasswordChange = viewModel::onPasswordChange,
        passward = password,
        navigateToMain = navigateToMain,
        onMainClick= {
            viewModel.login(
                body = GAuthLoginRequestBodyModel(
                    "${viewModel.email.value}${ResourceKeys.EMAIL_DOMAIN}",
                    viewModel.password.value
                )


                )
        }
    )

    }


@Composable
fun LoginScreen(
    modifier: Modifier = Modifier,
    email: String,
    navigateToMain: () -> Unit,
    passward: String,
    onEmailChange: (String) -> Unit,
    loginUiState: LoginUiState,
    isError1: Boolean,
    isError2: Boolean,
    saveTokenUiState: SaveTokenUiState,
    onBackClick: () -> Unit,
    onMainClick: () -> Unit,
    onPasswordChange: (String) -> Unit,

    ) {
    val focusManager = LocalFocusManager.current
    val isKeyboardOpen by keyboardAsState()
    val animatedSpacerHeight by animateDpAsState(targetValue = if (!isKeyboardOpen) 100.dp else 16.dp)
    var isLoading by remember { mutableStateOf(false) }
    var isError by remember { mutableStateOf(false) }

    LaunchedEffect(isKeyboardOpen) {
        if (!isKeyboardOpen) {
            focusManager.clearFocus()
        }
    }

    DisposableEffect(loginUiState, saveTokenUiState) {
        when (loginUiState) {
            is LoginUiState.Loading -> Unit
            is LoginUiState.Success ->  {
                when (saveTokenUiState) {
                    is SaveTokenUiState.Loading -> Unit
                    is SaveTokenUiState.Success -> navigateToMain()
                    is SaveTokenUiState.Error -> {
                        isLoading = false
                        isError = true
                    }
                }
            }

            is LoginUiState.BadRequest -> {
                isLoading = false
                isError = true

            }

            is LoginUiState.NotFound -> {
                isLoading = false
                isError = true

            }

            is LoginUiState.EmailNotValid -> {
                isLoading = false
                isError = true

            }

            is LoginUiState.Error -> {
                isLoading = false
                isError = true

            }
        }
        onDispose {}
    }
    lockScreenOrientation(orientation = ActivityInfo.SCREEN_ORIENTATION_PORTRAIT)
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
                text = "Login",
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
                    isError1 = isError,
                    singleLine = true


                )
            }
            Column(
                modifier = modifier
                    .fillMaxWidth()
            ) {
                Text(
                    modifier = Modifier.padding(start = 18.dp),

                    text = "",
                    style = TextStyle(
                        fontSize = 14.sp,
                        fontWeight = FontWeight(400),
                        color = Color(0xFF111111),
                        textAlign = TextAlign.Start
                    )
                )
            }
            Column(
                modifier = modifier
                    .fillMaxWidth()
            ) {
                PasswordTextField(
                    isDescription = false,
                    keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Text),
                    placeHolder = stringResource(id = R.string.check_password),
                    setText = passward,
                    singleLine = true,
                    onValueChange = onPasswordChange,
                    isError2 = isError,

                    )
            }
            Spacer(modifier = Modifier.height(230.dp))

            DoMaGAthButton{
                onMainClick()
                isLoading = true
            }
            if (isLoading){
                Text(
                    text = "로그인중입니다.",
                )

            }
        }
    }
}
@Preview
@Composable
fun PreviewLoginScreen() {
    LoginScreen(
        email = "",
        onEmailChange = {},
        isError1 = true,
        isError2 = false,
        onBackClick = {},
        onMainClick = {},
        loginUiState = LoginUiState.Loading,
        saveTokenUiState = SaveTokenUiState.Loading,
        onPasswordChange = {},
        passward = "",
        navigateToMain = {}



    )
}