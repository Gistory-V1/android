package view.login.screen

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import view.login.component.DoMaGAthButton

@Composable
internal fun LoginRoute(
    navigateToHome: () -> Unit

) {
    //구현할 예정입니다.
}

@Composable
fun LoginScreen(
    modifier: Modifier = Modifier,
    ClickButton: () -> Unit,
    navigateToHome: () -> Unit

    ) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
        modifier = modifier
            .fillMaxSize()
            .background(color = Color(0xFF1E1E1E))
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth(),
            verticalArrangement = Arrangement.spacedBy(32.dp, Alignment.Top),
            horizontalAlignment = Alignment.Start
        ) {
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(40.dp),
                horizontalAlignment = Alignment.Start
            ) {
                Text(
                    text = "안녕하세요!", style = TextStyle(
                        fontSize = 22.sp,
                        fontWeight = FontWeight(700),
                        color = Color(0xFFFFFFFF),
                        textAlign = TextAlign.Start
                    )
                )
                Text(
                    text = AnnotatedString.Builder("로그인을 해볼까요?").apply {
                        addStyle(
                            style = SpanStyle(color = Color(0xFF9BFFA6)), start = 0, end = 3
                        )
                    }.toAnnotatedString(), style = TextStyle(
                        fontSize = 22.sp,
                        fontWeight = FontWeight(900),
                        color = Color(0xFFFFFFFF),
                        textAlign = TextAlign.Start
                    )
                )

                Row(
                    horizontalArrangement = Arrangement.spacedBy(
                        10.dp,
                        Alignment.CenterHorizontally
                    ),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    DoMaGAthButton(onClick = ClickButton)
                }
            }
        }
    }
}


@Preview
@Composable
fun PreviewLoginScreen() {
    LoginScreen(ClickButton = {}, navigateToHome = {})
}

