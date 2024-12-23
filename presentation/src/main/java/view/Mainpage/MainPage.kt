package view.mainpage

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.navigation.NavigationBar
import com.kim.presentation.R
import view.main.component.MainItem

@Composable
fun MainPage(
    modifier: Modifier = Modifier,
    onClick: () -> Unit
) {
    val dummyList = List(10) { index -> "내가 피부가 까만 이유는?" }

    Column(
        modifier = modifier
            .fillMaxSize()
            .background(color = Color(0xFFFFFFFF))
    ) {
        // 상단 로고 및 아이콘 영역
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 20.dp, vertical = 12.dp),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            // gistory 로고
            Image(
                modifier = Modifier
                    .width(94.dp)
                    .height(25.dp),
                painter = painterResource(id = R.drawable.img_6),
                contentDescription = "gistory 로고 이미지",
                contentScale = ContentScale.Fit
            )

            // 검색 및 아이콘
            Row(
                horizontalArrangement = Arrangement.spacedBy(12.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                IconButton(onClick = { /*TODO*/ }) {
                    Icon(
                        modifier = Modifier.size(24.dp),
                        imageVector = Icons.Default.Search,
                        contentDescription = "검색 아이콘"
                    )
                }

                Image(
                    modifier = Modifier.size(24.dp),
                    painter = painterResource(id = R.drawable.img_22),
                    contentScale = ContentScale.Fit,
                    contentDescription = "G 아이콘 이미지"
                )
            }
        }

        // 이미지 배너 영역
        Image(
            modifier = modifier
                .fillMaxWidth()
                .height(300.dp)
                .padding(horizontal = 20.dp, vertical = 12.dp),

            painter = painterResource(id = R.drawable.img_12),
            contentScale = ContentScale.Fit,
            contentDescription = "G 아이콘 이미지")

        // 리스트 영역 (LazyColumn)
        LazyColumn(
            modifier = Modifier
                .fillMaxWidth()
                .weight(1f) // 리스트가 남은 공간을 모두 차지하도록 설정
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

        // NavigationBar 하단 고정
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .background(Color.White)
        ) {
            NavigationBar(
                onClick = onClick
            )
        }
    }
}



@Composable
@Preview
fun MainPagePreview() {
    MainPage(
        onClick = {}
    )
}
