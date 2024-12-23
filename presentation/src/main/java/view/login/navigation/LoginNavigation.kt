package view.login.navigation


import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavOptions
import androidx.navigation.compose.composable
import view.login.screen.SiginUpRoute

const val siginUpRoute = "sign_up_route"

fun NavController.navigateToSignUp(navOptions: NavOptions? = null) {
    this.navigate(siginUpRoute, navOptions)
}

fun NavGraphBuilder.signUp(
    onBackClick: () -> Unit,
    onNumberClick: () -> Unit,
) {
    composable(route = siginUpRoute)  {
        SiginUpRoute(
            onBackClick = onBackClick,
            onNumberClick = onNumberClick,
        )
    }
}