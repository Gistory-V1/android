package view.login.viewmodel



import androidx.compose.ui.graphics.RectangleShape
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.launch
import model.auth.request.GAuthLoginRequestBodyModel
import usecase.auth.SignUpUseCase
import utill.Regex.EMAIL
import utill.Regex.PASSWORD
import utill.ResourceKeys
import utill.isValidPassword
import view.login.SignUpUiState.SignUpUiState
import javax.inject.Inject

class SignUpViewModel @Inject constructor(
    private val signUpUseCase: SignUpUseCase,
    private val savedStateHandle: SavedStateHandle,
): ViewModel() {

    private val _signUpState = MutableStateFlow<SignUpUiState>(SignUpUiState.Loading)
    val signUpState: StateFlow<SignUpUiState> = _signUpState.asStateFlow()


    var email = savedStateHandle.getStateFlow(key = view.login.viewmodel.EMAIL, initialValue = ResourceKeys.EMPTY)
    var password = savedStateHandle.getStateFlow(key = view.login.viewmodel.PASSWORD, initialValue = ResourceKeys.EMPTY)
    internal var checkPassword = savedStateHandle.getStateFlow(key = CHECK_PASSWORD, initialValue = ResourceKeys.EMPTY)
    internal fun signUp(body: GAuthLoginRequestBodyModel) = viewModelScope.launch {
        _signUpState.value = SignUpUiState.Loading
        when{
            password.value != checkPassword.value -> {
                _signUpState.value = SignUpUiState.Error(Exception("비밀번호가 일치하지 않습니다."))

            }
            !isValidPassword(body.password) -> {
                _signUpState.value = SignUpUiState.PasswordNotValid
            }

            else -> {
                signUpUseCase(body = body)
                    .onSuccess {
                        it.catch {
                            _signUpState.value = SignUpUiState.Error(it)
                        }.collect { result ->
                            _signUpState.value = SignUpUiState.Success
                        }
                    }.onFailure {
                        _signUpState.value = SignUpUiState.Error(it)
                    }



            }
        }
    }

    internal fun initSignUP() {
        _signUpState.value= SignUpUiState.Loading
    }
    internal fun onEmailChange(value: String) {
        savedStateHandle[EMAIL] = value
    }
    internal fun onPasswordChange(value: String) {
        savedStateHandle[PASSWORD] = value
    }

    internal fun onCheckPasswordChange(value: String) {
        savedStateHandle[CHECK_PASSWORD] = value
    }





}
private const val EMAIL = "email"
private const val GENDER = "gender"
private const val MAJOR = "major"
private const val NUMBER = "number"
private const val PASSWORD = "password"
private const val CHECK_PASSWORD = "check password"