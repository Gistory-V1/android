package view.Mypage.component
import androidx.compose.runtime.Composable
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
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
import model.demerit.response.DemeritListResponseModel


@Composable
fun DemeritList(
    modifier: Modifier = Modifier,
    data: DemeritListResponseModel
){
    Column (
        modifier = modifier
            .fillMaxWidth()
            .background(color = Color(0xFF252525), shape = RoundedCornerShape(size = 10.dp))
            .padding(
                horizontal = 16.dp,
                vertical = 12.dp
            ),
        verticalArrangement = Arrangement.spacedBy(10.dp, Alignment.Top),
        horizontalAlignment = Alignment.Start,
        ){
        Column(
            modifier = Modifier.fillMaxWidth(),
            verticalArrangement = Arrangement.spacedBy(8.dp, Alignment.Top),
            horizontalAlignment = Alignment.Start,
            ){
            Column (
                modifier = Modifier.fillMaxWidth()
            ){
                Text(
                    text = "벌점 리스트",
                    style = TextStyle(
                        fontSize = 16.sp,
                        fontWeight = FontWeight(600),
                        color = Color(0xFFFFFFFF),
                        )
                )
            }
            Column(
                modifier = Modifier.fillMaxWidth(),
                verticalArrangement = Arrangement.spacedBy(2.dp, Alignment.Top),
                horizontalAlignment = Alignment.Start,
            ){
                Text(
                    text = stringResource(
                        R.string.stringResource,
                        data.because,
                        data.pointList
                    ),
                    style = TextStyle(
                        fontSize = 14.sp,
                        fontWeight = FontWeight(500),
                        color = Color(0xFFC1C1C1),
                        )
                )
            }
        }
    }
}
@Composable
@Preview
fun PreviewDemeritList(){
    DemeritList(
        data = DemeritListResponseModel(
            because = "노트북",
            pointList = 1,
        )
    )
}