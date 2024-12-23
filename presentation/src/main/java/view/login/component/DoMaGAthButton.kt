package view.login.component

import androidx.compose.foundation.background
import androidx.compose.foundation.border

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.Stable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.kim.presentation.component.modifier.clickablesingle

@Stable
@Composable
fun DoMaGAthButton(
    modifier: Modifier = Modifier,
    onClick: () -> Unit,
) {
    Row(
        horizontalArrangement = Arrangement.spacedBy(10.dp, Alignment.CenterHorizontally),
        verticalAlignment = Alignment.CenterVertically,
        modifier = modifier
            .fillMaxWidth()
            .padding(start = 15.dp, top = 13.dp, end = 15.dp, bottom = 16.dp)
            .height(55.dp)
            .border(width = 0.5.dp, color = Color(0xFF000000), shape = RoundedCornerShape(size = 7.dp))
            .clickablesingle(onClick = onClick)
            .background(color = Color(0xFFFFFFFFF), shape = RoundedCornerShape(size = 10.dp))


    ) {
        Text(
            text = "로그인",
            style = TextStyle(
                fontSize = 20.sp,
                fontWeight = FontWeight(700),
                color = Color(0xFF000000),
            )
        )
    }
}


@Composable
fun DoMaSinupButton(
    modifier: Modifier = Modifier,
    onClick: () -> Unit,
) {
    Row(
        horizontalArrangement = Arrangement.spacedBy(10.dp, Alignment.CenterHorizontally),
        verticalAlignment = Alignment.CenterVertically,
        modifier = modifier
            .fillMaxWidth()
            .padding(start = 15.dp, top = 13.dp, end = 15.dp, bottom = 16.dp)
            .height(55.dp)
            .border(
                width = 0.5.dp,
                color = Color(0xFF000000),
                shape = RoundedCornerShape(size = 7.dp)
            )
            .clickablesingle(onClick = onClick)
            .background(color = Color(0xFFFFFFFFF), shape = RoundedCornerShape(size = 10.dp))


    ) {
        Text(
            text = "회원가입",
            style = TextStyle(
                fontSize = 20.sp,
                fontWeight = FontWeight(700),
                color = Color(0xFF000000),
            )
        )

    }
}


@Preview
@Composable
fun DoMaGAuthButtonPreview() {
    DoMaGAthButton {}
}