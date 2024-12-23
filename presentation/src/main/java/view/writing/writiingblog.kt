package view.writing

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.navigation.NavigationBar
import com.kim.presentation.R

@Composable
fun WritingBlogScreenWithoutBorders(
    modifier: Modifier = Modifier,
    onBackClick: () -> Unit = {}, // 뒤로가기 클릭 이벤트
    onCompleteClick: () -> Unit = {} // 완료 버튼 클릭 이벤트
) {
    var titleText by remember { mutableStateOf("") }
    var contentText by remember { mutableStateOf("") }
    Column(
        modifier = modifier
            .fillMaxWidth()
            .background(color = Color(0xFFFFFFFF))
            .padding(16.dp) // 전체 여백
    ) {
        // 상단 툴바
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = 16.dp),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            // 뒤로가기 아이콘
            Image(
                painter = painterResource(id = R.drawable.img_28),
                contentDescription = "뒤로가기 아이콘",
                modifier = Modifier
                    .size(24.dp)
                    .clickable { onBackClick() }, // 클릭 이벤트 연결
                contentScale = ContentScale.Fit
            )
            Row(
                modifier = Modifier
                    .width(90.dp)
                    .height(40.dp)
                    .border(
                        width = 0.5.dp,
                        color = Color(0xFF868686),
                        shape = RoundedCornerShape(size = 20.dp)
                    )
                    .clickable { /*TODO*/ }
                    .padding(end = 10.dp),
                horizontalArrangement = Arrangement.Center,
                verticalAlignment = Alignment.CenterVertically
            ) {
                // 완료 버튼
                Text(
                    text = "완료",
                    style = TextStyle(
                        fontSize = 16.sp,
                        fontWeight = FontWeight.Bold,
                        color = Color(0xFF000000)
                    ),
                    modifier = Modifier.clickable { onCompleteClick() } // 클릭 이벤트 연결
                )
            }
        }

        Column(
            modifier = modifier
                .fillMaxWidth()
                .padding(16.dp) // 전체 여백
        ) {
            // 제목 입력 필드
            BasicTextField(
                value = titleText,
                onValueChange = { titleText = it },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(bottom = 16.dp),
                textStyle = TextStyle(
                    fontSize = 20.sp,
                    fontWeight = FontWeight.Bold,
                    color = Color.Black
                ),
                decorationBox = { innerTextField ->
                    if (titleText.isEmpty()) {
                        Text(
                            text = "제목",
                            style = TextStyle(
                                fontSize = 20.sp,
                                fontWeight = FontWeight.Bold,
                                color = Color.Gray
                            )
                        )
                    }
                    innerTextField()
                }
            )

            // 내용 입력 필드
            BasicTextField(
                value = contentText,
                onValueChange = { contentText = it },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 8.dp),
                textStyle = TextStyle(
                    fontSize = 16.sp,
                    color = Color.Black
                ),
                decorationBox = { innerTextField ->
                    if (contentText.isEmpty()) {
                        Text(
                            text = "내용을 입력해주세요",
                            style = TextStyle(
                                fontSize = 16.sp,
                                color = Color.Gray
                            )
                        )
                    }
                    innerTextField()
                }
            )
        }
        NavigationBar(
            onClick = {}
        )
    }
}


@Preview
@Composable
fun WritingBlogScreenPreview() {
    WritingBlogScreenWithoutBorders()
}


