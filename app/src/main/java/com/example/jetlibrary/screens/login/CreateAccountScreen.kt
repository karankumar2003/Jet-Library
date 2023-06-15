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
import androidx.navigation.NavHostController
import com.example.jetlibrary.components.UserForm

@Composable
fun CreateAccountScreen(navController: NavHostController) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier
            .fillMaxSize()
            .verticalScroll(
                rememberScrollState()
            )
    ) {

        Text("Jet Library", modifier = Modifier.padding(4.dp), fontSize = 50.sp)
        val context = LocalContext.current
        UserForm(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp),
            onButtonClick = { email, password ->
                Toast.makeText(context, "Account Created", Toast.LENGTH_SHORT).show()
            },
            buttonText = "Create Account",
            newUserText = "Already have an account? ",
            signUpText = "Sign In",
            signUpTextOnClick = {
                navController.navigateUp()
            }
        )
    }
}