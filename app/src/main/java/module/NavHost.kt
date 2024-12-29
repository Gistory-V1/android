package com.kim.Dormitorymanager.module

import androidx.compose.animation.EnterTransition
import androidx.compose.animation.ExitTransition
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.navigation.compose.NavHost
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import component.modifier.combinationView
import component.modifier.navigateWithLoginCheck
import component.modifier.type
import view.login.navigation.navigateToSignUp
import view.login.navigation.signUp
import view.main.Screen.navigateToMain
import view.myblog.navigation.navigateToSettingScreen
import view.signup.navigation.navigateToInputLogin
import view.writing.navgiton.navigationToBookAddBook


@Composable
fun NavHost (
  navController: NavHostController = rememberNavController(),
  startDestination: String

){
    val (currentDestination, setCurrentDestination) = remember { mutableStateOf(type.HOME) }

    NavHost(
        navController = navController,
        enterTransition = { EnterTransition.None },
        exitTransition = { ExitTransition.None },
        popEnterTransition = { EnterTransition.None },
        popExitTransition = { ExitTransition.None },
        startDestination = startDestination
    ){
        signUp(onBackClick = navController::popBackStack,
            onNumberClick =navController::navigateToSignUp
            )

        combinationView(
            currentDestination = currentDestination,
            setCurrenDestination = setCurrentDestination,
            MainButton = navController::navigateToMain,
            AddButton = navController::navigateToInputLogin,
            MyButton = navController::navigateToSettingScreen
        )









    }


}