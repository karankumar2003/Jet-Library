package com.example.jetlibrary.screens.home

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.example.jetlibrary.components.LibraryAppBar
import com.example.jetlibrary.model.MBook
import com.example.jetlibrary.navigation.LibraryScreens

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeScreen(navController: NavHostController) {

    Scaffold(
        modifier = Modifier.fillMaxSize(),
        topBar = {
            LibraryAppBar(
                modifier = Modifier
                    .fillMaxWidth()
                    .background(Color.Magenta),
                title = "Home",
                isHomeScreen = true,
                navController = navController
            )
        },
        floatingActionButton = {
            FloatingActionButton(
                onClick = {
                    navController.navigate(LibraryScreens.SearchScreen.name)
                }
            ) {
                Icon(Icons.Default.Add, "Add Books")
            }
        }
    ) {
        Column(
            modifier = Modifier
                .padding(it)
                .fillMaxSize()
                .padding(10.dp)
                .verticalScroll(rememberScrollState())
        ) {
            Spacer(modifier = Modifier.height(20.dp))
            Text("Your reading activity", modifier = Modifier, fontSize = 25.sp)
            Spacer(modifier = Modifier.height(20.dp))

            BookCard(
                book = MBook(),
                modifier = Modifier.size(180.dp, 250.dp)
            )

            Spacer(modifier = Modifier.height(20.dp))
            Text("Reading List", modifier = Modifier, fontSize = 25.sp)
            Spacer(modifier = Modifier.height(20.dp))

            ReadingListSection(bookList = listOf(
                MBook(null, "Android", "Karan", null),
                MBook(null, "Kotlin", "Karan", null),
                MBook(null, "Java", "Karan", null),
                MBook(null, "Jetpack Compose", "Karan", null),
                MBook(null, "Dependency Injection", "Karan", null),
                MBook(null, "Artificial Intelligence", "Karan", null),
            ))
        }

    }
}

@Composable
fun ReadingListSection(
    modifier: Modifier = Modifier,
    bookList:List<MBook>
) {
    LazyRow(modifier = modifier){
        items(bookList){
            BookCard(book = it, modifier = Modifier.size(180.dp, 250.dp))
            Spacer(modifier = Modifier.width(5.dp))
        }
    }
}