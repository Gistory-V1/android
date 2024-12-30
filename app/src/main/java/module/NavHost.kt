package com.kim.Dormitorymanager.module

import androidx.compose.animation.EnterTransition
import androidx.compose.animation.ExitTransition
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.navigation.compose.NavHost
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import component.modifier.combinationView
import component.modifier.navigateWithLoginCheck
import component.modifier.type
import view.Home.navigation.homeScreen
import view.login.navigation.navigateToSignUp
import view.login.navigation.signUp
import view.main.Screen.MainPage

import view.main.Screen.navigateToMain
import view.myblog.navigation.MyBlogs

import view.myblog.navigation.navigateToSettingScreen
import view.signup.navigation.loginScreen
import view.signup.navigation.navigateToInputLogin

import view.writing.navgiton.navigationToBookAddBook
import view.writing.navgiton.wrtiePost


@Composable
fun NavHost (
  navController: NavHostController = rememberNavController(),
  startDestination: String

) {
    val (currentDestination, setCurrentDestination) = remember { mutableStateOf(type.HOME) }

            NavHost(

                navController = navController,
                enterTransition = { EnterTransition.None },
                exitTransition = { ExitTransition.None },
                popEnterTransition = { EnterTransition.None },
                popExitTransition = { ExitTransition.None },
                startDestination = startDestination
            ) {


                signUp(
                    onBackClick = navController::popBackStack,
                    onNumberClick = navController::navigateToSignUp
                )

                combinationView(
                    currentDestination = currentDestination,
                    setCurrenDestination = setCurrentDestination,
                    MainButton = navController::navigateToMain,
                    AddButton = navController::navigationToBookAddBook,
                    MyButton = navController::navigateToSettingScreen
                )

                homeScreen(
                    onLoginClick = navController::navigateToInputLogin,
                    onSingClick = navController::navigateToSignUp,
                )


                loginScreen(
                    onBackClick = navController::popBackStack,
                    onMainClick = navController::navigateToMain,
                    navigateToMain = navController::navigateWithLoginCheck
                )



                wrtiePost(
                    navigateToBack = navController::popBackStack
                )


            }

        }
