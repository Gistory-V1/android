package view.serch

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.kim.presentation.R
import view.login.component.PasswordTextField
import view.login.component.PasswordTextFields
import view.serch.componet.TaskRow


@Composable
fun serchview(
    modifier: Modifier = Modifier,
    email: String,
    isError2: Boolean,
    recentSearches: List<Pair<String, String>>, // 최근 검색어 리스트 추가
    onDeleteTask: (Int) -> Unit // 삭제 클릭 콜백 추가
) {
    Column(
        modifier = modifier
            .fillMaxSize()
            .background(color = Color(0xFFFFFFFF))
    ) {
        // 상단 검색바와 이미지
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.spacedBy(12.dp, Alignment.Start),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Image(
                modifier = Modifier.padding(start = 10.dp),
                painter = painterResource(id = R.drawable.img_28),
                contentDescription = "뒤로가기"
            )
            PasswordTextFields(
                placeHolder = stringResource(id = R.string.serchview),
                setText = email,
                isError2 = isError2
            ) {
            }
        }

        // "최근 검색어" 텍스트
        Text(
            modifier = Modifier.padding(vertical = 15.dp, horizontal = 10.dp),
            text = "최근 검색어",
            style = TextStyle(
                fontSize = 18.sp,
                lineHeight = 22.sp,
                fontWeight = FontWeight(600),
                color = Color(0xFF000000)
            )
        )

        // LazyColumn으로 최근 검색어 리스트 표시
        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
                .padding(horizontal = 16.dp)
        ) {
            itemsIndexed(recentSearches) { index, item ->
                TaskRow(
                    title = item.first,
                    date = item.second,
                    onDeleteClick = { onDeleteTask(index) }
                )
            }
        }
    }
}


@Preview(showBackground = true)
@Composable
fun PreviewserchScreen() {
    val sampleSearches = listOf(
        "타투" to "12. 17.",
        "검색어 2" to "12. 18.",
        "검색어 3" to "12. 19."
    )

    serchview(
        email = "",
        isError2 = true,
        recentSearches = sampleSearches,
        onDeleteTask = { index ->
            println("Task at index $index deleted")
        }
    )
}
