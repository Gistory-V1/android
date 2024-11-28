package view.Mypage.component

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.kim.presentation.R

@Composable
fun MyClean(
    modifier: Modifier = Modifier,
    toDayClean: String,
    penaltyPoint: Int,
    cleanPoint: Int,
) {
    Row(
        modifier = modifier
            .fillMaxWidth()
            .background(color = Color(0xFF252525), shape = RoundedCornerShape(size = 10.dp))
            .padding(start = 10.dp, top = 16.dp, end = 20.dp, bottom = 16.dp),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {
        // 오늘의 청소 구역
        Column(
            verticalArrangement = Arrangement.spacedBy(4.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
        ) {
            Text(
                text = "오늘의 청소 구역",
                style = TextStyle(
                    fontSize = 13.sp,
                    fontWeight = FontWeight.W500,
                    color = Color.White,
                )
            )
            Text(
                text = toDayClean,
                style = TextStyle(
                    fontSize = 13.sp,
                    fontWeight = FontWeight.W500,
                    color = Color.White,
                )
            )
        }

        // 벌점
        Column(
            verticalArrangement = Arrangement.spacedBy(4.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
        ) {
            Text(
                text = "벌점",
                style = TextStyle(
                    fontSize = 14.sp,
                    fontWeight = FontWeight.W500,
                    color = Color.White,
                    textAlign = TextAlign.Center,
                )
            )
            Text(
                text = penaltyPoint.toString(),
                style = TextStyle(
                    fontSize = 16.sp,
                    fontWeight = FontWeight.W600,
                    color = Color.White,
                    textAlign = TextAlign.Center
                )
            )
        }

        // 남은 청소
        Column(
            verticalArrangement = Arrangement.spacedBy(4.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
        ) {
            Text(
                text = "남은 청소",
                style = TextStyle(
                    fontSize = 14.sp,
                    fontWeight = FontWeight.W500,
                    color = Color.White,
                    textAlign = TextAlign.Center,
                )
            )
            Text(
                text = stringResource(
                    R.string.CleanResource,
                    cleanPoint
                ),
                style = TextStyle(
                    fontSize = 15.sp,
                    fontWeight = FontWeight.W600,
                    color = Color.White,
                    textAlign = TextAlign.Center,
                )
            )
        }
    }
}

@Composable
@Preview
fun PreviewMyClean() {
    MyClean(
        penaltyPoint = 1,
        toDayClean = "3층 화장실",
        cleanPoint = 4
    )
}