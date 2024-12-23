package view.Home.navigation

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavOptions
import androidx.navigation.compose.composable
import view.Home.LoginRoute

const val loginRoute = "login_route"


fun NavController.navigateSignUp(navOptions: NavOptions? = null){
    this.navigate(loginRoute, navOptions)

}

fun NavGraphBuilder.homeScreen(
    onSingClick: () -> Unit,
    onLoginClick: () -> Unit,

){
    composable(route = loginRoute){
        LoginRoute(
            onSingClick = onSingClick,
            onLoginClick = onLoginClick,
        )
    }

}
