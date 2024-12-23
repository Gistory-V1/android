package com.example.navigation

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.kim.presentation.R
import com.kim.presentation.component.modifier.clickablesingle

@Composable
fun NavigationBar(
    modifier: Modifier = Modifier,
    onClick: () -> Unit // onClick 파라미터 추가
) {
    Row(
        modifier = modifier
            .fillMaxWidth()
            .height(60.dp)
            .background(color = Color.White),
        horizontalArrangement = Arrangement.SpaceEvenly,
        verticalAlignment = Alignment.CenterVertically
    ) {
        IconButton(onClick = { onClick() }) { // 클릭 이벤트 추가
            Icon(
                painter = painterResource(id = R.drawable.img_24),
                contentDescription = "Home Icon",
                tint = Color(0xFF6A00FF)
            )
        }
        IconButton(onClick = { onClick() }) {
            Icon(
                painter = painterResource(id = R.drawable.img_25),
                contentDescription = "Add Icon",
                tint = Color.Black
            )
        }
        IconButton(onClick = { onClick() }) {
            Icon(
                painter = painterResource(id = R.drawable.img_26),
                contentDescription = "Bell Icon",
                tint = Color.Black
            )
        }
        IconButton(onClick = { onClick() }) {
            Icon(
                painter = painterResource(id = R.drawable.img_27),
                contentDescription = "Settings Icon",
                tint = Color.Black
            )
        }
    }
}


@Preview
@Composable
fun NavigationBarPreview() {
    NavigationBar(
        onClick = {}
    )
}
