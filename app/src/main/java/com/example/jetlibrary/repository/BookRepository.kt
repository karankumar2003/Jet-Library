package com.example.jetlibrary.repository

import android.util.Log
import com.example.jetlibrary.data.DataOrException
import com.example.jetlibrary.model.Item
import com.example.jetlibrary.network.BookApi
import javax.inject.Inject

class BookRepository @Inject constructor(private val bookApi: BookApi) {

    private val dataOrException = DataOrException<List<Item>,Boolean,Exception>()
    private val bookDataOrException = DataOrException<Item,Boolean,Exception>()

    suspend fun getAllSearchedBooks(searchQuery:String) {
        try{
            dataOrException.loading = true
            dataOrException.data = bookApi.getAllSearchedBooks(searchQuery).items
            if(dataOrException.data!!.isNotEmpty()){
                dataOrException.loading = false
            }

        }catch (e: Exception){
            dataOrException.exception = e

        }
    }

    suspend fun getBook(bookId:String) {
        try{
            bookDataOrException.loading = true
            bookDataOrException.data = bookApi.getBook(bookId)
            if(bookDataOrException.data!!.toString().isNotEmpty()){
                bookDataOrException.loading = false
            }

        }catch (e: Exception){
            dataOrException.exception = e

        }
    }

}