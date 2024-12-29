package view.login.screen

import android.content.pm.ActivityInfo
import androidx.activity.ComponentActivity
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
import androidx.compose.ui.platform.LocalContext
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
import view.login.SignUpUiState.SignUpUiState
import view.login.component.DoMaSinupButton
import view.login.component.PasswordTextField
import view.login.component.GomsTextField
import view.login.viewmodel.SignUpViewModel

@Composable
internal fun SiginUpRoute(
    onBackClick: () -> Unit,
    onNumberClick: () -> Unit,
    viewModel: SignUpViewModel = hiltViewModel(LocalContext.current as ComponentActivity)
) {
    val email by viewModel.email.collectAsStateWithLifecycle()
    val password by viewModel.password.collectAsStateWithLifecycle()
    val signUpUiState by viewModel.signUpState.collectAsStateWithLifecycle()
    val checkPassword by viewModel.checkPassword.collectAsStateWithLifecycle()
    SignUPScreen(
        password = password,
        checkPassword = checkPassword,
        onPasswordChange = viewModel::onPasswordChange,
        onCheckPasswordChange = viewModel::onCheckPasswordChange,
        email = email,
        SignUpUiState = signUpUiState,
        onEmailChange = viewModel::onEmailChange,
        isError1 = false,
        isError2 = false,
        onBackClick = onBackClick,
        onNumberClick = onNumberClick,
        signUpCallBack = {
            viewModel.signUp(
                body = GAuthLoginRequestBodyModel(
                    "${viewModel.email.value}${ResourceKeys.EMAIL_DOMAIN}",
                    viewModel.password.value,
                )
            )
        },
        initCallBack = {
            viewModel.initSignUP()
        }
    )
}

@Composable
fun SignUPScreen(
    modifier: Modifier = Modifier,
    SignUpUiState: SignUpUiState,
    email: String,
    password: String,
    checkPassword: String,
    onPasswordChange: (String) -> Unit,
    onCheckPasswordChange: (String) -> Unit,
    onEmailChange: (String) -> Unit,
    isError1: Boolean,
    isError2: Boolean,
    onBackClick: () -> Unit,
    onNumberClick: () -> Unit,
    signUpCallBack: () -> Unit,
    initCallBack: () -> Unit
) {
    val focusManager = LocalFocusManager.current
    val isKeyboardOpen by keyboardAsState()
    var isLoading by remember { mutableStateOf(false) }
    var isPasswordMismatch by remember { mutableStateOf(false) }

    LaunchedEffect(isKeyboardOpen) {
        if (!isKeyboardOpen) {
            focusManager.clearFocus()
        }
    }

    DisposableEffect(SignUpUiState) {
        when (SignUpUiState) {
            is SignUpUiState.Loading -> Unit
            is SignUpUiState.Success -> onNumberClick()
            is SignUpUiState.PasswordNotValid -> {
                isLoading = false
            }
            is SignUpUiState.Error -> {
                isLoading = false
            }
        }
        onDispose { initCallBack() }
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
        ) {
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
            modifier = modifier.fillMaxWidth()
        ) {
            Column(
                modifier = modifier.fillMaxWidth()
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
                    singleLine = true
                )
            }
            Column(
                modifier = modifier.fillMaxWidth()
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
                    isDescription = false,
                    keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password),
                    placeHolder = stringResource(id = R.string.password),
                    singleLine = true,
                    setText = password,
                    onValueChange = onPasswordChange,
                    isError2 = isError2,
                )
            }
            Column(
                modifier = modifier.fillMaxWidth()
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
                    isDescription = true,
                    isError2 = isError2,
                    keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password),
                    placeHolder = stringResource(id = R.string.check_password),
                    setText = checkPassword,
                    onValueChange = onCheckPasswordChange,
                    singleLine = true
                )
                if (isPasswordMismatch) {
                    Text(
                        text = "비밀번호가 일치하지 않습니다.",
                        color = Color.Red,
                        fontSize = 12.sp,
                        modifier = Modifier.padding(start = 18.dp)
                    )
                }
            }
            Spacer(modifier = Modifier.height(230.dp))

            DoMaSinupButton {
                if (password != checkPassword) {
                    isPasswordMismatch = true
                } else {
                    isPasswordMismatch = false
                    signUpCallBack()
                    isLoading = true
                }
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
        onNumberClick = {},
        signUpCallBack = {},
        initCallBack = {},
        SignUpUiState = SignUpUiState.Loading,
        password = "",
        checkPassword = "",
        onPasswordChange = {},
        onCheckPasswordChange = {}
    )
}
