package view.signup.navigation

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavOptions
import androidx.navigation.compose.composable
import view.signup.InputLoginRoute


const val InputLoginRoute = "Input_login_route"


fun NavController.navigateToInputLogin(navOptions: NavOptions? = null) {
    this.navigate(InputLoginRoute, navOptions)

}

fun NavGraphBuilder.loginScreen(
    onBackClick: () -> Unit,
    onMainClick: () -> Unit,
    onRePasswordClick: () -> Unit,

){
    composable(route = InputLoginRoute) {
        InputLoginRoute(
            onBackClick = onBackClick,
            onMainClick = onMainClick,
            onRePasswordClick = onRePasswordClick,

        )
    }

}