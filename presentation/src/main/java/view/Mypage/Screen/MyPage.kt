package view.Mypage.Screen

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
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
import model.demerit.response.DemeritListResponseModel
import model.demerit.response.MyPenaltyResponseModel
import view.Mypage.component.DemeritList
import view.Mypage.component.MyDemeritList
import view.Mypage.component.MyClean

@Composable
fun MyPage(
    modifier: Modifier = Modifier,
    ) {
    Column(
        modifier = modifier
            .fillMaxSize()
            .background(color = Color(0xFF1E1E1E))
    ) {
        Column(
            modifier = Modifier.fillMaxWidth(),
            verticalArrangement = Arrangement.Top,
            horizontalAlignment = Alignment.Start,
        ) {
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(start = 20.dp, end = 235.dp),
                horizontalAlignment = Alignment.Start,
            ) {
                Text(
                    text = "안녕하세요", style = TextStyle(
                        fontSize = 20.sp,
                        fontWeight = FontWeight(600),
                        color = Color(0xFFFFFFFF),
                    )
                )
                Text(
                    text = AnnotatedString.Builder("이산님!").apply {
                        addStyle(
                            style = SpanStyle(
                                color = Color(0xFF9BFFA6), fontSize = 27.sp  // 이산 부분의 글자 크기 설정
                            ),
                            start = 0, end = 2
                        )
                    }.
                    toAnnotatedString(), style = TextStyle(
                        fontSize = 22.sp,  // 기본 글자 크기
                        fontWeight = FontWeight(900),
                        color = Color(0xFFFFFFFF),
                        textAlign = TextAlign.Start
                    )
                )
            }
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(
                        horizontal = 20.dp,
                        vertical = 16.dp,
                        ),
                verticalArrangement = Arrangement.spacedBy(10.dp, Alignment.Top),
                horizontalAlignment = Alignment.Start,
            ) {
                MyClean(
                    penaltyPoint = 1,
                    toDayClean = "3층 화장실",
                    cleanPoint = 3
                )
            }
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(start = 20.dp, end = 20.dp, bottom = 16.dp),
                verticalArrangement = Arrangement.spacedBy(10.dp, Alignment.Top),
                horizontalAlignment = Alignment.Start,
            ) {
                MyDemeritList(
                    data = MyPenaltyResponseModel(
                        myBecause = "노트북",
                        myPointList = 1,
                    )
                )
            }
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(start = 20.dp, end = 20.dp),
                verticalArrangement = Arrangement.spacedBy(10.dp, Alignment.Top),
                horizontalAlignment = Alignment.Start,
            ) {
                DemeritList(
                    data = DemeritListResponseModel(
                        because = "노트북",
                        pointList = 1,
                    )
                )
            }
        }
    }
}

@Composable
@Preview
fun PreviewMyPage() {
    MyPage()
}