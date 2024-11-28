package view.Mypage.navigation

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable


const val MyPage_loute = "Mypage_loute"

fun NavController.navGationToMyPage() {
    this.navigate(MyPage_loute)
}


fun NavGraphBuilder.MyScreen(
    navGationToMyPage: () -> Unit
) {
    composable(MyPage_loute) {
        MyScreen(navGationToMyPage = navGationToMyPage)
    }
}