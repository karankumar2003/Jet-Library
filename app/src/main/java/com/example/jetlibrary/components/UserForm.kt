package com.example.jetlibrary.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Lock
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.unit.dp
import com.example.jetlibrary.R

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun UserForm(
    modifier: Modifier = Modifier,
    onButtonClick: (String, String) -> Unit,
    buttonText: String
) {
    var email by rememberSaveable {
        mutableStateOf("")
    }
    var password by rememberSaveable {
        mutableStateOf("")
    }
    var isPasswordVisible by rememberSaveable {
        mutableStateOf(false)
    }
    val isValid = remember(email, password) {
        email.trim().isNotEmpty() && password.trim().length >= 6
    }
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = modifier.fillMaxSize()
    ) {

        Text(text = "Please enter your email and password",modifier = Modifier.padding(4.dp))


        OutlinedTextField(
            value = email,
            onValueChange = {
                email = it
            },
            leadingIcon = {
                Icon(Icons.Default.Email, "Email")
            },
            label = {
                Text("Email")
            }

        )

        Spacer(Modifier.height(20.dp))

        OutlinedTextField(
            value = password,
            onValueChange = {
                password = it
            },
            leadingIcon = {
                Icon(Icons.Default.Lock, "Password")
            },
            trailingIcon = {
                Icon(
                    painterResource(id = R.drawable.visibility_icon),
                    null,
                    modifier = Modifier
                        .size(24.dp)
                        .clickable {
                            isPasswordVisible = !isPasswordVisible
                        })
            },

            visualTransformation = if (isPasswordVisible) VisualTransformation.None else PasswordVisualTransformation(),
            label = {
                Text("Password")
            }

        )

        Spacer(modifier = Modifier.height(20.dp))

        Button(
            onClick = {
                onButtonClick(email,password)
            },
            enabled = isValid,

        ){
            Text(text = buttonText)
        }


    }
}