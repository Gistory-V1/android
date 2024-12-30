package view.writing.navgiton

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import view.writing.AddBookRoute



const val AddBookRoute = "add_book_route"

fun NavController.navigationToBookAddBook() {
    this.navigate(AddBookRoute)
}

fun NavGraphBuilder.wrtiePost(navigateToBack: () -> Unit) {
    composable(AddBookRoute) {
        AddBookRoute(navigateToBack = navigateToBack)
    }
}