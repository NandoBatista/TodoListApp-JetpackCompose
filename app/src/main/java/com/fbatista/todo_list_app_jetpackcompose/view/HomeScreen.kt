package com.fbatista.todo_list_app_jetpackcompose.view

import android.util.Log
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.material.TextFieldDefaults
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.fbatista.todo_list_app_jetpackcompose.ui.ImageBackground
import com.fbatista.todo_list_app_jetpackcompose.ui.theme.ColorBackgroundNote

@Composable
@Preview
fun HomeScreen() {
    ImageBackground()
    Column(
        modifier = Modifier
            .padding(16.dp)
    ) {
        SearchBar()
        NoteItemScreen()
        NoteItemScreen()
        NoteItemScreen()
        NoteItemScreen()
        NoteItemScreen()
    }
}

@Composable
fun SearchBar() {
    val (value, onValueChange) = remember { mutableStateOf("") }
    val maxLength = 30

    TextField(
        value = value,
        onValueChange = { newValue ->
            if (newValue.length <= maxLength) {
                onValueChange(newValue)
                Log.d("SearchBar", "onValueChange: $newValue")
            }
        },
        textStyle = TextStyle(fontSize = 18.sp),
        leadingIcon = { Icon(Icons.Filled.Search, null, tint = Color.Gray) },
        modifier = Modifier
            .padding(start = 4.dp, top = 16.dp, end = 4.dp, bottom = 44.dp)
            .background(ColorBackgroundNote, RoundedCornerShape(12.dp))
            .fillMaxWidth(),
        placeholder = { Text(text = "Procurar anotação") },
        colors = TextFieldDefaults.textFieldColors(
            focusedIndicatorColor = Color.Transparent,
            unfocusedIndicatorColor = Color.Transparent,
            backgroundColor = Color.Transparent,
            cursorColor = Color.DarkGray
        )
    )
}