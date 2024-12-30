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
import component.modifier.HomeICON
import component.modifier.addICON
import component.modifier.myICON
import component.modifier.type

@Composable
fun Navigation(
    modifier: Modifier = Modifier,
    currentDestination: type,
    setCurrenDestination: (type) -> Unit,
) {
    Row(
        horizontalArrangement = Arrangement.SpaceEvenly,
        verticalAlignment = Alignment.CenterVertically,
        modifier = modifier
            .fillMaxWidth()
            .height(60.dp)
            .background(color = Color.White)
    ) {
        type.values().forEach { item ->
            when (item) {
                type.HOME -> {
                    HomeICON(
                        modifier = Modifier.then(
                            if (currentDestination != item) {
                                Modifier.clickablesingle(onClick = { setCurrenDestination(item) })
                            } else {
                                Modifier
                            }
                        ),
                        isSelected = currentDestination == item
                    )
                }

                type.ADD -> {
                    addICON(
                        modifier = Modifier.then(
                            if (currentDestination != item) {
                                Modifier.clickablesingle(onClick = { setCurrenDestination(item) })
                            } else {
                                Modifier
                            }
                        ),
                        isSelected = currentDestination == item
                    )
                }

                type.MY -> {
                    myICON(
                        modifier = Modifier.then(
                            if (currentDestination != item) {
                                Modifier.clickablesingle(onClick = { setCurrenDestination(item) })
                            } else {
                                Modifier
                            }
                        ),
                        isSelected = currentDestination == item
                    )
                }
            }
        }
    }
}





@Preview
@Composable
fun NavigationBarPreview() {
    Navigation(
        currentDestination = type.ADD,
        setCurrenDestination = {}
    )
}
