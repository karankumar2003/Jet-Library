package com.example.jetlibrary.screens.search

import android.util.Log
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.jetlibrary.data.Resource
import com.example.jetlibrary.model.Item
import com.example.jetlibrary.repository.BookRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class SearchViewModel @Inject constructor(private val bookRepository: BookRepository) : ViewModel(){

    var books by mutableStateOf<List<Item>>(emptyList())


    private fun loadBooks(searchQuery: String) {
        viewModelScope.launch {
            if(searchQuery.isNotBlank()){
                try{
                    val response = bookRepository.getAllSearchedBooks(searchQuery)
                    when(response){
                        is Resource.Success ->{
                            books = response.data!!
                        }
                        is Resource.Failure ->{
                            Log.d("SearchViewModel", "loadBooks: Error Loading books")
                        }
                        else ->{
                        }
                    }
                }catch (e:Exception){
                    Log.d("SearchViewModel", "loadBooks: ${e.message}")
                }
            }
        }

    }


}