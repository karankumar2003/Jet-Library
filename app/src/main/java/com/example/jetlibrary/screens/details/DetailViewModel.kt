package com.example.jetlibrary.screens.details

import android.util.Log
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.jetlibrary.data.Resource
import com.example.jetlibrary.model.AccessInfo
import com.example.jetlibrary.model.Epub
import com.example.jetlibrary.model.Item
import com.example.jetlibrary.model.SaleInfo
import com.example.jetlibrary.model.SearchInfo
import com.example.jetlibrary.repository.BookRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class DetailViewModel @Inject constructor(private val repository: BookRepository) : ViewModel() {

    suspend fun getBookById(bookId : String):Resource<Item>{
        return repository.getBook(bookId)
    }


}