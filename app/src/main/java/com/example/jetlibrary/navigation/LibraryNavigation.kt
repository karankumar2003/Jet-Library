package com.example.jetlibrary.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.jetlibrary.screens.details.DetailsScreen
import com.example.jetlibrary.screens.home.HomeScreen
import com.example.jetlibrary.screens.login.CreateAccountScreen
import com.example.jetlibrary.screens.login.LogInScreen
import com.example.jetlibrary.screens.search.SearchScreen
import com.example.jetlibrary.screens.splash.SplashScreen

@Composable
fun LibraryNavigation() {

    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = LibraryScreens.SplashScreen.name) {

        composable(LibraryScreens.HomeScreen.name) {

            HomeScreen(navController)
        }
        composable(LibraryScreens.SplashScreen.name) {

            SplashScreen(navController)
        }
        composable(LibraryScreens.LogInScreen.name) {

            LogInScreen(navController)
        }
        composable(LibraryScreens.DetailScreen.name) {

            DetailsScreen(navController)
        }
        composable(LibraryScreens.SearchScreen.name){

            SearchScreen(navController)
        }
        composable(LibraryScreens.CreateAccountScreen.name){

            CreateAccountScreen(navController)
        }



    }

}