package com.example.jetlibrary.screens.stats

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import com.example.jetlibrary.components.LibraryAppBar

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun StatsScreen(navController: NavHostController) {
    Scaffold(
        topBar = {
        LibraryAppBar(title="Stats",isHomeScreen = false, navController = navController)
    }
    ) {
        Column(Modifier.padding(it)) {
            Text("StatsScreen")
        }
    }

}