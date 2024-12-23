package view.Home

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.Stable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.kim.presentation.R
import view.login.component.DoMaGAthButton
import view.login.component.DoMaSinupButton
@Composable
internal fun LoginRoute(
    onSingClick: () -> Unit,
    onLoginClick: () -> Unit,
){
    HomeScreen(
        onSingClick = onSingClick,
        onLoginClick = onLoginClick
    )

}
@Stable
@Composable
fun HomeScreen(
    modifier: Modifier = Modifier,
    onSingClick: () -> Unit,
    onLoginClick: () -> Unit,
) {
    Column(
        modifier = modifier
            .fillMaxSize()
            .background(color = Color(0xFFFFFFFF)), // 배경 흰색
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.SpaceBetween
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 60.dp, start = 34.dp, end = 34.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            // 로고 이미지
            Image(
                modifier = Modifier
                    .width(188.dp)
                    .height(50.dp)
                ,
                painter = painterResource(id = R.drawable.img_6),
                contentDescription = "gistory 로고 이미지",
                contentScale = ContentScale.Fit
            )

            // 텍스트
            Text(
                modifier = Modifier
                    .padding(top = 20.dp)
                ,
                text = "GSM에서만 볼 수 있는 특별한 블로그",
                style = TextStyle(
                    fontSize = 16.sp,
                    fontWeight = FontWeight.W300,
                    color = Color(0xFF636262),
                    textAlign = TextAlign.Center
                )
            )

            // 메인 이미지
            Image(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(400.dp)
                    .padding(top = 20.dp),
                painter = painterResource(id = R.drawable.img_1),
                contentDescription = "메인 이미지",
                contentScale = ContentScale.Fit
            )
        }

        // 버튼 영역
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = 50.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            DoMaGAthButton {
                onLoginClick()

            }
            DoMaSinupButton {
                onSingClick()

            }
        }
    }
}


@Preview
@Composable
fun PreviewHomeScreen() {
    HomeScreen(
        onSingClick = {},
        onLoginClick = {}
    )
}


