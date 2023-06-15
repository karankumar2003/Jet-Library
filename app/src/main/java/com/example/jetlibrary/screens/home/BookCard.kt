package com.example.jetlibrary.screens.home

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.FavoriteBorder
import androidx.compose.material.icons.filled.Star
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import com.example.jetlibrary.R
import com.example.jetlibrary.model.MBook

@Composable
fun BookCard(
    book: MBook,
    modifier: Modifier = Modifier,
    readingStatus:String = "Reading",
    cardOnClick: () -> Unit = {},
    onReadingStatusClick : () -> Unit = {}
) {
    Card(
        modifier = modifier
            .clickable {
                       cardOnClick()
            },
        shape = RoundedCornerShape(16.dp),
        elevation = CardDefaults.cardElevation(defaultElevation = 4.dp),

        ) {
        Column(
            modifier = Modifier.fillMaxSize()
        ) {
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(150.dp)
            ) {
                Image(
                    painterResource(id = R.drawable.ic_launcher_background),
//                    rememberImagePainter(""),
                    contentScale = ContentScale.Crop,
                    contentDescription = "Book Image",
                    modifier = Modifier.fillMaxSize()
                )
                Column(
                    modifier = Modifier.align(Alignment.BottomEnd),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {

                    IconButton(onClick = { /*TODO*/ }) {
                        Icon(
                            Icons.Default.FavoriteBorder,
                            contentDescription = "Mark as Favorite icon"
                        )
                    }


                    Icon(Icons.Default.Star, "Rating")
                    Text(text = "0.0")


                }

            }
            Text(
                text = book.title.toString(),
                style = MaterialTheme.typography.titleLarge,
                maxLines = 2,
                overflow = TextOverflow.Ellipsis,
                fontWeight = FontWeight.Bold
            )
            Text(text = book.author.toString(), maxLines = 2, overflow = TextOverflow.Ellipsis)


                Text(readingStatus,modifier.clickable {
                    onReadingStatusClick()
                })

        }
    }
}