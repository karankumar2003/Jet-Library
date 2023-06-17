package com.example.jetlibrary.screens.details

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
fun DetailsScreen(
    navController: NavHostController,
    bookId: String?
) {
    Scaffold(
        topBar = {
            LibraryAppBar(
                title = "Book Details",
                isHomeScreen = false,
                navController = navController
            )
        }
    ) {
        Text(bookId.toString(),Modifier.padding(it))
    }
}