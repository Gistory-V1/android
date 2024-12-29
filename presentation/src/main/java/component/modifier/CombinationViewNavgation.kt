package component.modifier

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable


const val CombinationViewRoute = "combination_view_route"
fun NavController.navigateWithLoginCheck() {
    this.navigate(CombinationViewRoute)
}
fun NavGraphBuilder.combinationView(
    currentDestination: type,
    setCurrenDestination: (type) -> Unit,
    MainButton: () -> Unit,
    AddButton: () -> Unit,
    MyButton: () -> Unit,

) {
    composable(CombinationViewRoute){
        CombinationView(
            currentDestination = currentDestination,
            setCurrentDestination = setCurrenDestination,
            MainButton = MainButton,
            AddButton = AddButton,
            MyButton = MyButton,

        )
    }

}