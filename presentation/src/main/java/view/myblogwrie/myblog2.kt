package view.myblogwrie

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.MoreVert
import androidx.compose.runtime.Composable
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
import view.otherblog.componet.BlogHeader
import view.otherblog.componet.otherBlogItem

@Composable
fun mybolg2(
    modifier: Modifier = Modifier,
    likes: Int,
    views: Int,
    onCick: () -> Unit
) {
    Column(
        modifier = modifier
            .fillMaxWidth()
            .background(color = Color(0xFFFFFFFF))

    ) {

        Row(
            modifier = modifier
                .fillMaxWidth()
                .height(32.dp),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            // 뒤로가기 아이콘
            Image(
                modifier = Modifier
                    .padding(start = 8.dp)
                    .size(24.dp)
                    .clickable { }, // 크기를 동일하게 설정
                painter = painterResource(id = R.drawable.img_28), // 뒤로가기 아이콘 리소스
                contentScale = ContentScale.Fit,
                contentDescription = "뒤로가기 아이콘"
            )

            // 오른쪽 Google 아이콘
            Image(
                modifier = Modifier
                    .padding(end = 8.dp)
                    .size(32.dp), // 크기를 동일하게 설정
                painter = painterResource(id = R.drawable.img_12), // Google 아이콘 리소스
                contentScale = ContentScale.Fit,
                contentDescription = "Google 아이콘"
            )

        }
        BlogHeader(
            title = "내가 피부가 까만 이유는?",
            author = "김민준",
            date = "2024. 12. 16."
        )
        Column(
            modifier = Modifier
                .height(303.dp)
                .fillMaxWidth(),
            horizontalAlignment = Alignment.Start,

            ) {
            Text(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(start = 16.dp, top = 16.dp),
                text = "dkdld",
                style = TextStyle(
                    fontSize = 16.sp,
                    fontWeight = FontWeight(300),
                    color = Color(0xFF000000),
                    textAlign = TextAlign.Center

                )
            )
        }
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .height(48.dp),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            // 왼쪽: 하트 아이콘과 숫자
            Row(
                verticalAlignment = Alignment.CenterVertically
            ) {
                Image(
                    modifier = Modifier.size(24.dp),
                    painter = painterResource(id = R.drawable.img_21),
                    contentDescription = "하트 아이콘",
                    contentScale = ContentScale.Fit
                )
                Spacer(modifier = Modifier.width(8.dp)) // 아이콘과 숫자 간격
                Text(
                    text = "$likes",
                    style = TextStyle(
                        fontSize = 16.sp,
                        fontWeight = FontWeight.W400,
                        color = Color(0xFFA6A6A6)
                    )
                )
                Spacer(modifier = Modifier.width(16.dp)) // 좋아요와 조회수 간격
                Text(
                    text = "$views 조회",
                    style = TextStyle(
                        fontSize = 14.sp,
                        fontWeight = FontWeight.W400,
                        color = Color(0xFFA6A6A6)
                    )
                )
            }

            // 오른쪽: 메뉴 아이콘
            Icon(
                modifier = Modifier.size(24.dp),
                imageVector = Icons.Default.MoreVert,
                contentDescription = "메뉴 아이콘",
                tint = Color(0xFFA6A6A6)
            )

        }

    }
}



@Preview(showBackground = true)
@Composable
fun mybolg2Preview() {
    mybolg2(
        likes = 100,
        onCick = {},
        views = 36
    )
}
