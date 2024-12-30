package view.main.Screen

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavOptions
import androidx.navigation.compose.composable
import view.mainpage.MainRoute


const val mainRoute = "main_route"


fun NavController.navigateToMain(navOptions: NavOptions? = null) {
    this.navigate(mainRoute, navOptions)
}

fun NavGraphBuilder.MainPage(
    MyprofileClick: () -> Unit,
){
    composable(route = mainRoute){
        MainRoute(
            MyprofileClick = MyprofileClick,
        )

    }
}

