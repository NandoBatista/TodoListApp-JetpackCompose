package com.fbatista.todo_list_app_jetpackcompose.ui

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import com.fbatista.todo_list_app_jetpackcompose.R

@Composable
fun SplashScreen() {
    ImageBackground()
    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Image(
            painter = painterResource(id = R.drawable.noteone_logo),
            contentDescription = "NoteOne Icon",
        )
    }
}

@Composable
fun ImageBackground() {
    val backgroundPainter = painterResource(id = R.drawable.noteone_background)
    Box(modifier = Modifier.fillMaxSize()) {
        Image(
            modifier = Modifier.fillMaxSize(),
            contentScale = ContentScale.Crop,
            painter = backgroundPainter,
            contentDescription = "backgroundImage"
        )
    }
}