package view.main.component

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
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
import com.kim.presentation.R

@Composable
fun MainItem(
    modifier: Modifier = Modifier,
    index: Int,
    title: String,
    likes: Int,
    views: Int,
    daysAgo: String
) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .background(Color(0xFFFFFFFF)),
        verticalArrangement = Arrangement.spacedBy(4.dp, Alignment.Top),
        horizontalAlignment = Alignment.Start,
    ) {
        Row(
            modifier = Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.Top
        ) {
            Text(
                text = "$index / 김민준",
                style = TextStyle(
                    fontSize = 20.sp,
                    fontWeight = FontWeight(400),
                    color = Color(0xFF868686),
                    letterSpacing = 0.5.sp,
                )
            )
        }
        Column(modifier = modifier.fillMaxWidth()) {
            Text(
                text = title,
                style = TextStyle(
                    fontSize = 18.sp,
                    fontWeight = FontWeight(600),
                    color = Color(0xFF000000),
                )
            )
            Row(
                modifier = modifier.fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically
            ) {
                // 하트 아이콘
                Image(
                    modifier = Modifier
                        .size(24.dp),

                    painter = painterResource(id = R.drawable.img_21),
                    contentDescription = "하트 아이콘",
                    contentScale = ContentScale.Fit
                )
                // 숫자 텍스트
                Text(
                    text = "$likes",
                    style = TextStyle(
                        fontSize = 16.sp,
                        fontWeight = FontWeight.W400,
                        color = Color(0xFFA6A6A6)
                    )
                )
                Spacer(modifier = Modifier.width(8.dp))
                Text(
                    text = "$views 조회",
                    style = TextStyle(
                        fontSize = 16.sp,
                        fontWeight = FontWeight.W400,
                        color = Color(0xFFA6A6A6)
                    )
                )
                Spacer(modifier = Modifier.width(8.dp))
                Text(
                    text = daysAgo,
                    style = TextStyle(
                        fontSize = 14.sp,
                        fontWeight = FontWeight.W300,
                        color = Color(0xFF757575),
                    )
                )
            }
        }
    }
}
@Composable
fun MainItems(
    modifier: Modifier = Modifier,
){
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .background(Color(0xFFFFFFFF)),
        verticalArrangement = Arrangement.spacedBy(4.dp, Alignment.Top))
    {
        Row(
            modifier = Modifier
                .width(345.dp)
                .height(78.dp)
                .background(color = Color(0xFFEEEEEE), shape = RoundedCornerShape(size = 12.dp))

                .padding(start = 16.dp, top = 16.dp, end = 16.dp, bottom = 16.dp)
            ,
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically,
        ) {
            Column (
                modifier = Modifier,
            ) {
                Text(
                    text = "김승찬",
                    style = TextStyle(
                        fontSize = 20.sp,
                        fontWeight = FontWeight(600),
                        color = Color(0xFF000000),

                        letterSpacing = 0.5.sp,
                    )

                )
                Text(
                    text = "✅ 구독자 68명",
                    style = TextStyle(
                        fontSize = 12.sp,
                        fontWeight = FontWeight(400),
                        color = Color(0xFF757575),

                        letterSpacing = 0.3.sp,
                    )
                )

            }
            Row(
                modifier = Modifier
                    .width(90.dp)
                    .height(40.dp)
                    .border(
                        width = 0.5.dp,
                        color = Color(0xFF868686),
                        shape = RoundedCornerShape(size = 20.dp)
                    )
                    .clickable {  }
                    .padding(end = 10.dp),
                horizontalArrangement = Arrangement.Center,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Image(
                    painter = painterResource(id = R.drawable.img_31),
                    contentDescription = "image description",
                    contentScale = ContentScale.None
                )
                // 완료 버튼
                Text(
                    text = "구독하기",
                    style = TextStyle(
                        fontSize = 16.sp,
                        fontWeight = FontWeight.Bold,
                        color = Color(0xFF000000)
                    ),
                    modifier = Modifier.clickable { } // 클릭 이벤트 연결
                )
            }

        }
    }

}


@Preview
@Composable
fun MainItemPreview() {
    MainItem(
        index = 1,
        title = "내가 피부가 까만 이유는?",
        likes = 100,
        views = 36,
        daysAgo = "2일 전"
    )
    MainItems()

}