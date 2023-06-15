package com.example.jetlibrary.screens.login

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase
import kotlinx.coroutines.launch

class AuthViewModel : ViewModel() {

    private val _loading = MutableLiveData(false)
    val loading: LiveData<Boolean> = _loading

    private val auth: FirebaseAuth = Firebase.auth

    fun signInWithEmailAndPassword(email: String, password: String, onDone: () -> Unit) =
        viewModelScope.launch {
            try {
                auth.signInWithEmailAndPassword(email, password)
                    .addOnCompleteListener { task ->
                        if (task.isSuccessful) {
                            Log.d("AuthViewModel", "signInWithEmailAndPassword: Successfully Logged In ")
                            onDone()
                        }else{
                            Log.d("AuthViewModel", "signInWithEmailAndPassword: Not successful in logging in")
                        }
                    }
            }catch (e:Exception){
                Log.d("AuthViewModel", "signInWithEmailAndPassword: ${e.message}")
            }
        }
}