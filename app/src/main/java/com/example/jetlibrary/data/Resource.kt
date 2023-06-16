package com.example.jetlibrary.data

sealed class Resource<T>(val data:T?= null, val message:String? = null ){
    class Success<T>(data: T): Resource<T>(data)
    class Failure<T>(data: T?=null,message: String): Resource<T>(data,message)
    class Loading<T>(data:T? = null): Resource<T>(data)
}