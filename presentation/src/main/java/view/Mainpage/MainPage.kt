package view.mainpage

import androidx.activity.ComponentActivity
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.Image
import androidx.compose.foundation.ScrollState
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.pager.PagerState
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.foundation.rememberScrollState
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle

import com.kim.presentation.R
import com.kim.presentation.component.modifier.clickablesingle
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.delay
import model.auth.response.top5responsemodel
import view.main.UiState.MainUiState
import view.main.component.MainItem
import view.mainpage.viewmodel.MainViewModel

@Composable
internal fun MainRoute(
    modifier: Modifier = Modifier,
    MyprofileClick: () -> Unit,
    MainViewModel: MainViewModel = hiltViewModel(LocalContext.current as ComponentActivity),

    ) {
    val getRankList by MainViewModel.rankList.collectAsStateWithLifecycle()
    val (isToastVisible, setIsToastVisible) = remember { mutableStateOf(false) }

    MainPage(
        modifier = Modifier,
        MyprofileClick = MyprofileClick,
        isToastVisible = isToastVisible ,
        rankList = getRankList,
        showToast = {setIsToastVisible(true)},
        scrollState = rememberScrollState(),

    )
    LaunchedEffect(
        Unit
    ) {
        MainViewModel.getRankList()
    }
    LaunchedEffect(isToastVisible) {
        delay(2000)
        setIsToastVisible(false)

    }


}

@Composable
fun MainPage(
    modifier: Modifier = Modifier,
    MyprofileClick: () -> Unit,
    isToastVisible: Boolean,
    rankList: MainUiState,
    showToast: () -> Unit,
    scrollState: ScrollState = rememberScrollState(),
    coroutineScope: CoroutineScope = rememberCoroutineScope(),
    ) {

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
                    modifier = Modifier
                        .size(24.dp),
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

            painter = painterResource(id = R.drawable.img_34),
            contentScale = ContentScale.Fit,
            contentDescription = "G 아이콘 이미지")

        when(rankList) {
            is MainUiState.Empty -> {
                MyprofileClick()

                showToast()
                Text(text = "안됨")
            }

            is MainUiState.Fail -> {
                showToast()
                MyprofileClick()
                Text(text = "안됨")
            }

            is MainUiState.Loading -> {
                showToast()
                MyprofileClick()
                Text(text = "로딩중~~")
            }

            is MainUiState.Success -> {
                MyprofileClick()
                LazyColumn(
                    modifier = Modifier
                        .fillMaxWidth()
                        .weight(1f) // 리스트가 남은 공간을 모두 차지하도록 설정
                        .padding(horizontal = 20.dp, vertical = 8.dp),
                    verticalArrangement = Arrangement.spacedBy(8.dp)

                ) {
                    items(rankList.data) { item ->
                        MainItem(
                            data = item
                        )
                    }
                }
            }
        }



    }
}



@Composable
@Preview
fun MainPagePreview() {
    MainPage(
        MyprofileClick = {},
        rankList = MainUiState.Loading,
        showToast = {},
        scrollState = rememberScrollState(),
        coroutineScope = rememberCoroutineScope(),
        modifier = Modifier,
        isToastVisible = false,

    )
}
