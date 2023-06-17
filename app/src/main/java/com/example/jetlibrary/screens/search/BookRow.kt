package com.example.jetlibrary.screens.search

import android.util.Log
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import coil.compose.rememberImagePainter
import com.example.jetlibrary.model.Item

@Composable
fun BookRow(
    modifier: Modifier = Modifier,
    book: Item
) {
    Row(
        modifier = modifier
    ) {
        Image(
            rememberImagePainter(book.volumeInfo.imageLinks?.thumbnail),
            "Book Image",
            modifier = Modifier.size(100.dp, 130.dp),
            contentScale = ContentScale.Crop
        )

        Column {
            Text(
                text = book.volumeInfo.title,
                maxLines = 3,
                overflow = TextOverflow.Visible,
                modifier = Modifier.padding(4.dp)
            )
            Text(
                text = book.volumeInfo.authors[0],
                modifier = Modifier.padding(4.dp),
                style = MaterialTheme.typography.labelSmall
            )
        }
        Log.d("BookRow", "BookRow: ${book.volumeInfo.imageLinks?.thumbnail} ")

    }
}