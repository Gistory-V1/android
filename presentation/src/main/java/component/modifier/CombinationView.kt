package component.modifier

import androidx.activity.ComponentActivity
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.material.ModalBottomSheetValue
import androidx.compose.material.ExperimentalMaterialApi

import androidx.compose.material.Scaffold
import androidx.compose.material.rememberModalBottomSheetState

import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.navigation.NavigationBar
import kotlinx.coroutines.CoroutineScope
import view.mainpage.MainRoute
import view.myblog.SettingRoute
import view.myblog.viewModel.otherProfileViewModel
import view.writing.BookAddBookRoute
import view.writing.navgiton.BookAddBookRoute


@OptIn(ExperimentalMaterialApi::class)
@Composable
fun CombinationView(
    modifier: Modifier= Modifier,
    otherProfileViewModel: otherProfileViewModel= hiltViewModel(LocalContext.current as ComponentActivity),
    coroutine : CoroutineScope = rememberCoroutineScope(),
    currentDestination: type,
    setCurrentDestination: (type) -> Unit,
    MainButton: () -> Unit,
    AddButton: () -> Unit,
    MyButton: () -> Unit,

    ){




    Scaffold(
        bottomBar = {
            NavigationBar(
                currentDestination = currentDestination,
                setCurrenDestination = setCurrentDestination
            )
        }
    ){
        paddingValues ->
        Box(modifier = modifier.padding(paddingValues)){
            when(currentDestination){
                type.HOME -> MainRoute(MyprofileClick = MainButton)
                type.ADD -> BookAddBookRoute(navigateToBack = AddButton)
                type.MY -> SettingRoute(onBackClick = MyButton)

            }
        }

    }

}