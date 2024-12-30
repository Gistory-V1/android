package view.myblog.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavOptions
import androidx.navigation.compose.composable
import usecase.auth.LogoutUseCase
import view.myblog.SettingRoute


const val settingRoute = "setting_route"


fun NavController.navigateToSettingScreen(navOptions: NavOptions? = null) {
    this.navigate(settingRoute, navOptions)
}

fun NavGraphBuilder.MyBlogs(
    onBackClick:() -> Unit
) {

    composable(route = settingRoute) {
        SettingRoute(
            onBackClick = onBackClick,


            )

    }
}
