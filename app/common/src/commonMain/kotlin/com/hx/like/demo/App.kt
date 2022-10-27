package com.hx.like.demo

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyHorizontalGrid
import androidx.compose.material.FloatingActionButton
import androidx.compose.material.Icon
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Face
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Lock
import androidx.compose.material.icons.filled.Notifications
import androidx.compose.material.icons.filled.Phone
import androidx.compose.material.icons.filled.Place
import androidx.compose.material.icons.filled.ThumbUp
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import like.LikeButton
import like.rememberLikeButtonState

@Composable
fun App() {
  ComposeLikeButtonTheme {
    Scaffold(
      floatingActionButton = {
        FloatingActionButton(onClick = { }) {
          Icon(Icons.Filled.Add, null)
        }
      },
      topBar = {
        TopAppBar(
          title = {
            Text("Compose like button")
          }
        )
      }
    ) { innerPadding ->
      Box(Modifier.padding(innerPadding)) {
        Content()
      }
    }
  }
}

val icons = listOf(
  Icons.Default.Favorite,
  Icons.Default.Email,
  Icons.Default.Lock,
  Icons.Default.Phone,
  Icons.Default.Place,
  Icons.Default.ThumbUp,
  Icons.Default.Face,
  Icons.Default.Notifications,
  Icons.Default.Home,
)

@Composable
private fun Content() {
  LazyHorizontalGrid(
    rows = GridCells.Fixed(3),
    horizontalArrangement = Arrangement.Center,
    verticalArrangement = Arrangement.Center,
  ) {
    items(icons.size) { index ->
      LikeButton(
        modifier = Modifier.padding(30.dp),
        size = 60.dp,
        likeButtonState = rememberLikeButtonState(
          initIsLiked = false,
        ),
        likeContent = {
          Icon(
            modifier = Modifier.size(60.dp),
            imageVector = icons[index],
            contentDescription = "",
            tint = if (it) Color.Red else Color.Gray,
          )
        }
      )
    }
  }
}
