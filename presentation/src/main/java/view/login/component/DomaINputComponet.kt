package view.login.component

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.MaterialTheme.colors
import androidx.compose.material.MaterialTheme.typography
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.ArrowDropDown
import androidx.compose.material.icons.filled.Done
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.DisposableEffect
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.Stable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.focus.FocusManager
import androidx.compose.ui.focus.FocusRequester
import androidx.compose.ui.focus.focusRequester
import androidx.compose.ui.focus.onFocusChanged
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.kim.presentation.R
import com.kim.presentation.component.modifier.clickablesingle


const val EMPTY = ""

@Composable
fun GomsTextField(
    modifier: Modifier = Modifier,
    isError1: Boolean = false,
    isEmail: Boolean = true,
    placeHolder: String = EMPTY,
    readOnly: Boolean = false,
    focusRequester: FocusRequester = FocusRequester(),
    setText: String,
    keyboardOptions: KeyboardOptions = KeyboardOptions.Default,
    keyboardActions: KeyboardActions = KeyboardActions.Default,
    maxLines: Int = Int.MAX_VALUE,
    singleLine: Boolean = false,
    maxLength: Int = if (isEmail) 6 else Int.MAX_VALUE,
    visualTransformation: VisualTransformation = VisualTransformation.None,
    onValueChange: (String) -> Unit = {},
) {
    val isFocused = remember { mutableStateOf(false) }
    val focusManager = LocalFocusManager.current

    DisposableEffect(Unit) {
        onDispose { focusManager.clearFocus() }
    }

    Column {
        OutlinedTextField(
            value = setText,
            onValueChange = {
                val filteredText = it.filterNot { text -> text.isWhitespace() }
                if (filteredText.length <= maxLength) onValueChange(filteredText)
            },
            keyboardOptions = keyboardOptions,
            keyboardActions = keyboardActions,
            placeholder = {
                Text(
                    text = placeHolder,
                    color = Color(0xFFBDBDBD),
                    style = MaterialTheme.typography.bodyMedium
                )
            },

            modifier = modifier
                .fillMaxWidth()
                .padding(start = 15.dp, top = 13.dp, end = 15.dp)
                .height(55.dp)
                .focusRequester(focusRequester)
                .clip(RoundedCornerShape(8.dp))
                .background(Color.White) // 배경색 흰색
                .border(
                    width = 1.dp,
                    color = if (isError1) Color(0xFFFF5A5A) else Color(0xFFA6A6A6), // 테두리 색상: 에러 시 빨간색
                    shape = RoundedCornerShape(7.dp)
                )
                .onFocusChanged { isFocused.value = it.isFocused },
            maxLines = maxLines,
            singleLine = singleLine,
            textStyle = TextStyle(fontSize = 16.sp, color = Color(0xFF212121)),
            colors = OutlinedTextFieldDefaults.colors(
                focusedTextColor = if (isError1) Color(0xFFEF5350) else Color.Black,
                unfocusedTextColor = if (isError1) Color(0xFFEF5350) else Color.Black,
                focusedPlaceholderColor = Color(0xFFBDBDBD),
                unfocusedPlaceholderColor = Color(0xFFBDBDBD),
                focusedBorderColor = Color.Transparent,
                unfocusedBorderColor = Color.Transparent,
                cursorColor = Color(0xFF1E88E5)
            ),
            trailingIcon = {
                if (isEmail) {
                    Text(
                        modifier = Modifier.padding(end = 16.dp),
                        text = "@gsm.hs.kr",
                        color = Color(0xFFE0E0E0)
                    )
                }
            },
            readOnly = readOnly,
            visualTransformation = visualTransformation
        )
        if (isError1) {
            Text(
                text = "이메일을 입력해주세요",
                color = Color(0xFFFF5A5A), // 빨간색
                style = MaterialTheme.typography.bodySmall,
                modifier = Modifier.padding(start = 15.dp, top = 4.dp)
            )
        }
    }
}


@Composable
fun PasswordTextField(
    modifier: Modifier = Modifier,
    isDescription: Boolean = false,
    isError2: Boolean = false,
    placeHolder: String = EMPTY,
    readOnly: Boolean = false,
    focusManager: FocusManager = LocalFocusManager.current,
    focusRequester: FocusRequester = FocusRequester(),
    setText: String,
    keyboardOptions: KeyboardOptions = KeyboardOptions.Default,
    keyboardActions: KeyboardActions = KeyboardActions.Default,
    maxLines: Int = Int.MAX_VALUE,
    singleLine: Boolean = false,
    onValueChange: (String) -> Unit = {},
) {
    // 상태 관리: 비밀번호 표시/숨김 여부
    var passwordVisibility by remember { mutableStateOf(false) }

    // 에러 상태에 따른 색상 정의
    val isFocused = remember { mutableStateOf(false) }    // 빨간색 또는 흰색


    DisposableEffect(Unit) {
        onDispose {
            focusManager.clearFocus()
        }
    }
    Column(modifier = modifier.fillMaxWidth()) {
        OutlinedTextField(
            value = setText,
            onValueChange = {
                // 공백 제거 및 값 업데이트
                val filteredText = it.filterNot { char -> char.isWhitespace() }
                onValueChange(filteredText)
            },
            keyboardOptions = keyboardOptions,
            keyboardActions = keyboardActions,

            placeholder = {
                Text(
                    text = placeHolder,
                    color = if (isError2) Color(0xFF9E9E9E) else Color(0xFFFF0000), // 문자열 대신 Color 객체 사용
                    style = MaterialTheme.typography.bodyMedium
                )
            },
            modifier = Modifier
                .padding(start = 15.dp, top = 13.dp, end = 15.dp)
                .fillMaxWidth()
                .height(55.dp)
                .clip(RoundedCornerShape(8.dp))
                .background(Color(0xFFF5F5F5)) // 입력 필드 배경색
                .border(
                    1.dp,
                    color = if (isError2) Color(0xFF9E9E9E) else Color(0xFFFF5A5A), // 에러 시 테두리 빨간색
                    RoundedCornerShape(7.dp)
                )
                .onFocusChanged { isFocused.value = it.isFocused },
            maxLines = maxLines,
            singleLine = singleLine,
            textStyle = MaterialTheme.typography.bodyMedium,
            colors = OutlinedTextFieldDefaults.colors(
                focusedTextColor = if (isError2) Color(0xFF9E9E9E) else Color(0xFFFFFFFF), // N5: 회색, WHITE: 흰색
                unfocusedTextColor = if (isError2) Color(0xFF9E9E9E) else Color(0xFFFFFFFF), // N5: 회색, WHITE: 흰색 G7: 초록색
                focusedBorderColor = Color.Transparent,
                unfocusedBorderColor = Color.Transparent,
                cursorColor = Color(0xFFFF5722) // I5: 주황색
            ),

            trailingIcon = {
                IconButton(onClick = { passwordVisibility = !passwordVisibility }) {
                }

            },
            readOnly = readOnly,
            visualTransformation = if (passwordVisibility) VisualTransformation.None else PasswordVisualTransformation()
        )

        // 에러 메시지 추가 (필드 하단에 표시)
        if (isDescription) {
            Text(
                text = stringResource(id = R.string.password_conditions),
                style = typography.button
            )
        }
    }
}
@Composable
fun PasswordTextFields(
    modifier: Modifier = Modifier,
    isDescription: Boolean = false,
    isError2: Boolean = false,
    placeHolder: String = EMPTY,
    readOnly: Boolean = false,
    focusManager: FocusManager = LocalFocusManager.current,
    focusRequester: FocusRequester = FocusRequester(),
    setText: String,
    keyboardOptions: KeyboardOptions = KeyboardOptions.Default,
    keyboardActions: KeyboardActions = KeyboardActions.Default,
    maxLines: Int = Int.MAX_VALUE,
    singleLine: Boolean = false,
    onValueChange: (String) -> Unit = {},
) {

    // 에러 상태에 따른 색상 정의
    val isFocused = remember { mutableStateOf(false) }    // 빨간색 또는 흰색


    DisposableEffect(Unit) {
        onDispose {
            focusManager.clearFocus()
        }
    }
    Column(modifier = modifier.fillMaxWidth()) {
        OutlinedTextField(
            value = setText,
            onValueChange = {
                // 공백 제거 및 값 업데이트
                val filteredText = it.filterNot { char -> char.isWhitespace() }
                onValueChange(filteredText)
            },
            keyboardOptions = keyboardOptions,
            keyboardActions = keyboardActions,

            placeholder = {
                Text(
                    text = placeHolder,
                    color = if (isError2) Color(0xFF9E9E9E) else Color(0xFFFF0000), // 문자열 대신 Color 객체 사용
                    style = MaterialTheme.typography.bodyMedium
                )
            },
            modifier = Modifier
                .padding(start = 15.dp, top = 13.dp, end = 15.dp)
                .fillMaxWidth()
                .height(55.dp)
                .clip(RoundedCornerShape(16.dp))
                .background(Color(0xFFF5F5F5), RoundedCornerShape(16.dp)) // 입력 필드 배경색
                .border(
                    1.dp,
                    color = if (isError2) Color(0xFF9E9E9E) else Color(0xFFFF5A5A), // 에러 시 테두리 빨간색
                    RoundedCornerShape(7.dp)
                )
                .onFocusChanged { isFocused.value = it.isFocused },
            maxLines = maxLines,
            singleLine = singleLine,
            textStyle = MaterialTheme.typography.bodyMedium,
            colors = OutlinedTextFieldDefaults.colors(
                focusedTextColor = if (isError2) Color(0xFF9E9E9E) else Color(0xFFFFFFFF), // N5: 회색, WHITE: 흰색
                unfocusedTextColor = if (isError2) Color(0xFF9E9E9E) else Color(0xFFFFFFFF), // N5: 회색, WHITE: 흰색 G7: 초록색
                focusedBorderColor = Color.Transparent,
                unfocusedBorderColor = Color.Transparent,
                cursorColor = Color(0xFFFF5722) // I5: 주황색
            ),

            trailingIcon = {
                IconButton(onClick = {}) {
                    Image(
                        modifier = Modifier
                            .size(24.dp),
                        painter = painterResource(id = R.drawable.img_8), contentDescription = "돋보기")
                }

            },
            readOnly = readOnly,
        )

        // 에러 메시지 추가 (필드 하단에 표시)
        if (isDescription) {
            Text(
                text = stringResource(id = R.string.password_conditions),
                style = typography.button
            )
        }
    }
}







@Preview
@Composable
fun DoMaGAuthBduttonPreview() {
    Column {

        GomsTextField(
            modifier = Modifier.fillMaxWidth(),
            placeHolder = "GOMS",
            isError1 = false,
            onValueChange = {},
            setText = EMPTY
        )
        PasswordTextField(
            modifier = Modifier.fillMaxWidth(),
            isError2 = false,
            onValueChange = {},
            setText = EMPTY
        )
        PasswordTextFields(
            modifier = Modifier.fillMaxWidth(),
            isError2 = false,
            onValueChange = {},
            setText = EMPTY
        )



    }

}