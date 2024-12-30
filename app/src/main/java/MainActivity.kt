package com.kim.Dormitorymanager

import android.os.Bundle
import android.view.Window
import android.view.WindowManager
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import androidx.navigation.compose.rememberNavController
import com.kim.Dormitorymanager.module.NavHost
import component.modifier.CombinationViewRoute
import dagger.hilt.android.AndroidEntryPoint
import view.Home.navigation.loginRoute


@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    private val viewModel: MainActivityViewModel by viewModels()
    override fun onCreate(savedInstanceState: Bundle?) {
        requestWindowFeature(Window.FEATURE_NO_TITLE)
        super.onCreate(savedInstanceState)
        window.setFlags(
            WindowManager.LayoutParams.FLAG_FULLSCREEN,
            WindowManager.LayoutParams.FLAG_FULLSCREEN
        )
        installSplashScreen().setKeepOnScreenCondition {
            viewModel.uiState.value is MainActivityUiState.Loading
        }
        setContent{
            val startDestination = when(viewModel.uiState.value){
                is MainActivityUiState.Success ->
                    CombinationViewRoute
                else -> loginRoute
            }
            NavHost(startDestination = startDestination)

        }
    }


}