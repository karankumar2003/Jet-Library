package com.example.jetlibrary.screens.splash

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.airbnb.lottie.compose.LottieAnimation
import com.airbnb.lottie.compose.LottieCompositionSpec
import com.airbnb.lottie.compose.rememberLottieComposition
import com.example.jetlibrary.R
import com.example.jetlibrary.navigation.LibraryScreens
import kotlinx.coroutines.delay

@Composable
fun SplashScreen(navController: NavHostController) {
    Box(modifier=Modifier.fillMaxSize()){
        Lottie(modifier=Modifier.size(250.dp).align(Alignment.Center))
    }


    LaunchedEffect(key1 = true){
        delay(2500L)
        navController.navigate(LibraryScreens.LogInScreen.name)
    }

}

@Composable
fun Lottie(modifier: Modifier=Modifier) {
    val composition by rememberLottieComposition(spec = LottieCompositionSpec.RawRes(R.raw.splash_lottie))
    LottieAnimation(composition = composition, iterations = 1,modifier= modifier, speed = 1.5f)
}