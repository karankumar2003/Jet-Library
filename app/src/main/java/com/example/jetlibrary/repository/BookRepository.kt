package com.example.jetlibrary.repository

import com.example.jetlibrary.data.Resource
import com.example.jetlibrary.model.Item
import com.example.jetlibrary.network.BookApi
import javax.inject.Inject

class BookRepository @Inject constructor(private val bookApi: BookApi) {


    suspend fun getAllSearchedBooks(searchQuery: String): Resource<List<Item>> {
        return try {
            Resource.Loading(data = true)
            val bookList = bookApi.getAllSearchedBooks(searchQuery).items
            if (bookList.isNotEmpty()) {
                Resource.Loading(false)
            }
            Resource.Success(data = bookList)

        } catch (e: Exception) {
            Resource.Failure(data = null, message = e.message.toString())

        }
    }

    suspend fun getBook(bookId: String): Resource<Item> {
        return try {
            Resource.Loading(data = true)
            val book = bookApi.getBook(bookId)
            if (book.toString().isNotEmpty()) {
                Resource.Loading(false)
            }
            Resource.Success(data = book)

        } catch (e: Exception) {
            Resource.Failure(data = null, message = e.message.toString())

        }
    }

}