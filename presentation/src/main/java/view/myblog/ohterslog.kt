package view.myblog

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
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.navigation.NavigationBar
import com.kim.presentation.R
import view.main.component.MainItem
import view.otherblog.componet.otherBlogItem

@Composable
fun MyBlogs(
    modifier: Modifier = Modifier,
    onCick: () -> Unit
) {
    val dummyList = List(10) { index -> "내가 피부가 까만 이유는?" }

    Column(
        modifier = modifier
            .fillMaxWidth()
            .background(color = Color(0xFFFFFFFF))
    ) {
        // 상단 배너
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .height(276.dp)
                .background(
                    brush = Brush.verticalGradient(
                        colors = listOf(Color(0xFFBBBBBB), Color(0xFF111111))
                    )
                )
                .padding(horizontal = 20.dp, vertical = 16.dp),
            horizontalAlignment = Alignment.Start,
            verticalArrangement = Arrangement.SpaceBetween
        ) {
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.End,
                verticalAlignment = Alignment.CenterVertically
            ) {
                IconButton(onClick = { /* TODO */ }) {
                    Icon(
                        modifier = Modifier.size(24.dp),
                        imageVector = Icons.Default.Search,
                        contentDescription = "검색 아이콘"
                    )
                }

                Spacer(modifier = Modifier.width(8.dp))

                Image(
                    modifier = Modifier.size(24.dp),
                    painter = painterResource(id = R.drawable.img_22),
                    contentScale = ContentScale.Fit,
                    contentDescription = "G 아이콘 이미지"
                )
            }

            Spacer(modifier = Modifier.height(16.dp))

            Text(
                text = "모태환\n님의 블로그",
                style = TextStyle(
                    fontSize = 28.sp,
                    fontWeight = FontWeight.SemiBold,
                    color = Color(0xFFFFFFFF),
                    textAlign = TextAlign.Start
                ),
            )

            Spacer(modifier = Modifier.height(4.dp))

            Text(
                text = "구독자 20",
                style = TextStyle(
                    fontSize = 12.sp,
                    fontWeight = FontWeight.Normal,
                    color = Color(0xFFD9D9D9),
                )
            )

            Spacer(modifier = Modifier.height(4.dp))

            Text(
                text = "모태환 님의 블로그 입니다.",
                style = TextStyle(
                    fontSize = 12.sp,
                    fontWeight = FontWeight.Normal,
                    color = Color(0xFFD9D9D9),
                )
            )

            Spacer(modifier = Modifier.height(16.dp))
            Row(

            ) {
                Row(
                    modifier = Modifier
                        .width(90.dp)
                        .height(40.dp)
                        .background(color = Color(0xFFEEEEEE), shape = RoundedCornerShape(20.dp))
                        .clickable { /* TODO */ },
                    horizontalArrangement = Arrangement.Center,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Text(
                        text = "로그아웃",
                        style = TextStyle(
                            fontSize = 14.sp,
                            fontWeight = FontWeight.Medium,
                            color = Color(0xFF111111),
                        )
                    )
                }
                Spacer(modifier = Modifier.width(16.dp))
                Row(
                    modifier = Modifier
                        .width(90.dp)
                        .height(40.dp)
                        .background(color = Color(0xFFEEEEEE), shape = RoundedCornerShape(20.dp))
                        .clickable { /* TODO */ },
                    horizontalArrangement = Arrangement.Center,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Text(
                        text = "회원탈퇴",
                        style = TextStyle(
                            fontSize = 14.sp,
                            fontWeight = FontWeight.Medium,
                            color = Color(0xFF111111),
                        )
                    )
                }
            }
            Text(
                text = "MY BLOG",
                style = TextStyle(
                    fontSize = 18.sp,
                    fontWeight = FontWeight.Bold,
                    color = Color(0xFF000000),
                ),
                modifier = Modifier.padding(horizontal = 20.dp, vertical = 8.dp)
            )



        }


        // "MY BLOG" 헤더
        // 게시물 리스트
        LazyColumn(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 20.dp, vertical = 8.dp),
            verticalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            itemsIndexed(dummyList) { index, item ->
                MainItem(
                    index = index + 1,
                    title = item,
                    likes = 100,
                    views = 36,
                    daysAgo = "2일 전"
                )
            }
        }

        // 하단 네비게이션 바
        NavigationBar(
            onClick = onCick
        )
    }
}

@Preview
@Composable
fun MyblogPreview() {
    MyBlogs(
        onCick = {}
    )
}
