package com.example.jetlibrary.screens.search

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
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
        Column {
            Text(text = book.volumeInfo.title)
        }
        Image(
            rememberImagePainter(book.volumeInfo.imageLinks.thumbnail),
            contentDescription = "Book Image",
            modifier.width(100.dp)
        )

    }
}