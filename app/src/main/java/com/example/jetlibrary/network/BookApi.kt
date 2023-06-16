package com.example.jetlibrary.network

import com.example.jetlibrary.model.Book
import com.example.jetlibrary.model.Item
import retrofit2.http.GET
import retrofit2.http.Query
import javax.inject.Singleton

@Singleton
interface BookApi {

    @GET("volumes")
   suspend fun getAllSearchedBooks(@Query("q") searchQuery: String) : Book

    @GET("volumes/{bookId}")
    suspend fun getBook(@Query("bookId") bookId: String) : Item

}