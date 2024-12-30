package view.otherblog

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material.Text
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
import view.main.component.MainItem
import view.otherblog.componet.BlogHeader
import view.otherblog.componet.otherBlogItem


@Composable
fun OtherBlog(
    modifier: Modifier = Modifier,
    likes: Int,
    onCick: () -> Unit
) {
    val dummyList = List(10) { index -> "내가 피부가 까만 이유는?" }


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
                    .clickable {  }
                , // 크기를 동일하게 설정
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
        Column(
            modifier = Modifier
                .width(393.dp)
                .height(93.dp)
                .background(color = Color(0xFFF4F4F4))

                .padding(start = 24.dp, top = 25.dp, end = 24.dp, bottom = 25.dp)

        ) {
            Text(
                text = "김민준",
                style = TextStyle(
                    fontSize = 18.sp,
                    fontWeight = FontWeight(400),
                    color = Color(0xFF000000),

                    )
            )
            Text(
                text = "안녕하세요. 김민준 입니다.",
                style = TextStyle(
                    fontSize = 12.sp,
                    fontWeight = FontWeight(400),
                    color = Color(0xFF757575),

                    )
            )

        }
        Text(

            modifier = Modifier
                .padding(start = 16.dp, top = 16.dp),
            text = "김민준 님의 다른 글",
            style = TextStyle(
                fontSize = 20.sp,
                fontWeight = FontWeight(500),
                color = Color(0xFF4230FF),

                )
        )
        LazyColumn(
            modifier = Modifier
                .fillMaxWidth()
                .weight(1f) // 리스트가 남은 공간을 모두 차지하도록 설정
                .padding(horizontal = 20.dp, vertical = 8.dp),
            verticalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            itemsIndexed(dummyList) { index, item ->
                otherBlogItem(
                    index = index + 1,
                    title = item,
                    likes = 100,
                    views = 36,
                    daysAgo = "2일 전"
                )
            }
        }


        Row(
            modifier = modifier.fillMaxWidth()
            .padding(start = 24.dp, top = 12.dp, end = 24.dp, bottom = 12.dp),
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
        }

    }
}

@Preview(showBackground = true)
@Composable
fun OtherBlogPreview() {
    OtherBlog(
        likes = 100,
        onCick = {}
    )
}
