package view.writing.navgiton

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import view.writing.BookAddBookRoute


const val BookAddBookRoute = "book_add_book_route"

fun NavController.navigationToBookAddBook() {
    this.navigate(BookAddBookRoute)
}

fun NavGraphBuilder.bookAddBook(navigateToBack: () -> Unit) {
    composable(BookAddBookRoute) {
        BookAddBookRoute(navigateToBack = navigateToBack)
    }
}