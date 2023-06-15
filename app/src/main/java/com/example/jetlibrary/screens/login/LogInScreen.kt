package com.example.jetlibrary.screens.login

import android.widget.Toast
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import com.example.jetlibrary.components.UserForm
import com.example.jetlibrary.navigation.LibraryScreens

@Composable
fun LogInScreen(
    navController: NavHostController,
    authViewModel: AuthViewModel = viewModel()
    ) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier
            .fillMaxSize()
            .verticalScroll(
                rememberScrollState()
            )
    ) {

        Text("Jet Library", modifier = Modifier.padding(4.dp), fontSize = 50.sp)
        Text("Sign In", modifier = Modifier.padding(4.dp), fontSize = 25.sp)

        val context = LocalContext.current
        UserForm(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp),
            buttonText = "Sign In",
            onButtonClick = { email, password ->
                authViewModel.signInWithEmailAndPassword(email,password){
                    navController.navigate(LibraryScreens.HomeScreen.name)
                }
            },
            newUserText = "Don't have an account? ",
            signUpText = "Sign Up",
            signUpTextOnClick = {
                navController.navigate(LibraryScreens.CreateAccountScreen.name)
            }
        )
    }
}