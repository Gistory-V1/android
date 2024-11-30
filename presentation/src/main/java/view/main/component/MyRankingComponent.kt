package view.main.component

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
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
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.kim.presentation.R
import model.rank.response.RankResponseModel
import java.util.UUID

@Composable
fun MyRankingComponent(
    modifier: Modifier = Modifier,
    data: RankResponseModel,
) {
    Column(
        modifier = modifier
            .fillMaxWidth()
            .height(57.dp)
            .background(color = Color(0xFF252525), shape = RoundedCornerShape(size = 10.dp))
            .padding(start = 24.dp, top = 5.dp, end = 24.dp, bottom = 5.dp),
        verticalArrangement = Arrangement.spacedBy(10.dp, Alignment.CenterVertically),
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .height(25.dp),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically,
        ) {
            Text(
                text = "나의 랭킹은...",
                style = TextStyle(
                    fontSize = 16.sp,
                    fontWeight = FontWeight(700),
                    color = Color(0xFFFFFFFF),
                )
            )
            Text(
                text = stringResource(
                    R.string.Rank,
                    data.rank
            ),
                style = TextStyle(
                    fontSize = 20.sp,
                    fontWeight = FontWeight(700),
                    color = Color(0xFF9BFFA6),
                )
            )
        }
    }
}

@Composable
@Preview
fun PreviewMyRankingComponent() {
    MyRankingComponent(
        data = RankResponseModel(
            rank = 3,
            name = "김재관",
            penaltyPoint = 5,
            userId = UUID.randomUUID()
        )

    )
}