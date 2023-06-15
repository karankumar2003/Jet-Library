package com.example.jetlibrary.components

import androidx.compose.foundation.clickable
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.ExitToApp
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import com.example.jetlibrary.navigation.LibraryScreens
import com.google.firebase.auth.FirebaseAuth

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun LibraryAppBar(
    modifier: Modifier = Modifier,
    title: String = "Jet Library",
    isHomeScreen: Boolean,
    navController: NavHostController
) {
    CenterAlignedTopAppBar(
        title = {
            Text(title)
        },
        modifier = modifier,
        navigationIcon = {
            if (isHomeScreen) {
                IconButton(
                    onClick = {
                        navController.navigate(LibraryScreens.StatsScreen.name)
                    }
                ) {
                    Icon(Icons.Default.AccountCircle, contentDescription = "Account")
                }
            } else {
                IconButton(
                    onClick = {
                        navController.navigateUp()
                    }
                ) {
                    Icon(Icons.Default.ArrowBack, contentDescription = "Navigate Back")
                }

            }
        },
        actions = {

            if (isHomeScreen) {


                IconButton(
                    onClick = {
                        FirebaseAuth
                            .getInstance()
                            .signOut()
                        navController.navigate(LibraryScreens.LogInScreen.name) {
                            popUpTo(navController.graph.startDestinationId) {
                                inclusive = true
                            }
                        }
                    })
                {
                    Icon(Icons.Default.ExitToApp, contentDescription = "Log out icon")
                }

            }else{

            }

        }
    )
}