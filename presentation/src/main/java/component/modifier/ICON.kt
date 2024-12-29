package component.modifier

import androidx.compose.material.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import com.kim.presentation.R


@Composable
fun HomeICON(
    modifier: Modifier = Modifier,
    isSelected: Boolean = false,
    ){
    Icon(
        painter = painterResource(id = R.drawable.img_24),
        contentDescription = "Home Icon",
        tint = Color(0xFF6A00FF)
    )
}
@Composable
fun addICON(
    modifier: Modifier = Modifier,
    isSelected: Boolean = false,
){
    Icon(
        painter = painterResource(id = R.drawable.img_25),
        contentDescription = "Add Icon",
        tint = Color.Black
    )
}

@Composable
fun myICON(
    modifier: Modifier = Modifier,
    isSelected: Boolean = false,
) {
    Icon(
        painter = painterResource(id = R.drawable.img_27),
        contentDescription = "Settings Icon",
        tint = Color.Black
    )

}