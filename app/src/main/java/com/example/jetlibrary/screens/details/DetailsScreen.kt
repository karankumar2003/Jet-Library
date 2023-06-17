package com.example.jetlibrary.screens.details

import android.content.Context
import android.util.Log
import android.widget.Toast
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.produceState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Alignment.Companion.Center
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import coil.compose.rememberImagePainter
import com.example.jetlibrary.components.LibraryAppBar
import com.example.jetlibrary.data.Resource
import com.example.jetlibrary.model.Item
import com.example.jetlibrary.model.MBook
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.FirebaseFirestore

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DetailsScreen(
    navController: NavHostController,
    bookId: String?,
    detailViewModel: DetailViewModel = hiltViewModel()
) {
    Scaffold(
        topBar = {
            LibraryAppBar(
                title = "Book Details",
                isHomeScreen = false,
                navController = navController
            )
        }
    ) {
        val book = produceState<Resource<Item>>(initialValue = Resource.Loading()) {
            value = detailViewModel.getBookById(bookId!!)
        }.value

        Column(
            modifier = Modifier
                .padding(it)
                .verticalScroll(rememberScrollState()),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {


            Log.d("DetailsScreen", "DetailsScreen:${book.data.toString()}")

            if (book.data == null) {
                Box(modifier = Modifier.fillMaxSize()) {
                    CircularProgressIndicator(Modifier.align(Center))
                }

            } else {
                Spacer(Modifier.height(10.dp))
                Image(
                    rememberImagePainter(book.data.volumeInfo.imageLinks?.thumbnail),
                    "Book Image",
                    modifier = Modifier
                        .size(100.dp, 130.dp),
                    contentScale = ContentScale.Crop
                )
                Spacer(Modifier.height(10.dp))

                Text(book.data.volumeInfo.title, style = MaterialTheme.typography.titleLarge)
                Text(
                    "Author: " + book.data.volumeInfo.authors,
                    style = MaterialTheme.typography.labelMedium
                )
                Text(
                    "Pages: " + book.data.volumeInfo.pageCount,
                    style = MaterialTheme.typography.labelMedium
                )

                Spacer(Modifier.height(10.dp))

                Text(
                    "Categories: " + book.data.volumeInfo.categories.toString(),
                    style = MaterialTheme.typography.labelMedium,
                    modifier = Modifier.align(Alignment.Start)
                )
                Text(
                    "Published: " + book.data.volumeInfo.publishedDate,
                    style = MaterialTheme.typography.labelMedium,
                    modifier = Modifier.align(Alignment.Start)
                )

                Spacer(Modifier.height(10.dp))
                Text("Description", style = MaterialTheme.typography.titleLarge)


                Text(
                    book.data.volumeInfo.description,
                    style = MaterialTheme.typography.labelMedium,
                    modifier = Modifier.align(Alignment.Start)
                )

                Spacer(Modifier.height(10.dp))

                Row(Modifier.fillMaxSize(), horizontalArrangement = Arrangement.SpaceEvenly) {
                    Button(onClick = { navController.navigateUp() }) {
                        Text("Cancel")
                    }

                    val context = LocalContext.current

                    Button(
                        onClick = {
                            val mBook = MBook(
                                title = book.data.volumeInfo.title,
                                author = book.data.volumeInfo.authors.toString(),
                                notes = "",
                                photoUrl = book.data.volumeInfo.imageLinks?.thumbnail,
                                categories = book.data.volumeInfo.categories.toString(),
                                publishedDate = book.data.volumeInfo.publishedDate,
                                rating = 0.0,
                                description = book.data.volumeInfo.description,
                                pageCount = book.data.volumeInfo.pageCount.toString(),
                                userId = FirebaseAuth.getInstance().currentUser?.uid.toString(),
                                googleBookId = book.data.id

                            )

                            saveBookInFirebase(mBook, context, navController)
                        }
                    ) {
                        Text("Save")
                    }
                }

            }

            Log.d("DetailsScreen", "DetailsScreen:${book.data.toString()}")


        }
    }
}

fun saveBookInFirebase(book: MBook, context: Context, navController: NavHostController) {

    val db = FirebaseFirestore.getInstance()
    val bookCollection = db.collection("books")

    if (book.toString().isNotEmpty()) {

        bookCollection.add(book)
            .addOnSuccessListener { documentReference ->
                val docId = documentReference.id
                bookCollection.document(docId).update(hashMapOf("id" to docId) as Map<String, Any>)
                    .addOnCompleteListener { task ->
                        if (task.isSuccessful) {
                            navController.navigateUp()
                            Toast.makeText(context, "Book Saved", Toast.LENGTH_SHORT).show()
                        }
                    }.addOnFailureListener {
                        Log.d(
                            "DetailsScreen",
                            "saveBookInFirebase: Error uploading Book to firebase"
                        )
                    }
            }
    }
}