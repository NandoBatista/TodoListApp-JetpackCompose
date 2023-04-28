package com.fbatista.todo_list_app_jetpackcompose.view

import android.util.Log
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
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
import com.fbatista.todo_list_app_jetpackcompose.model.Note
import com.fbatista.todo_list_app_jetpackcompose.ui.ImageBackground
import com.fbatista.todo_list_app_jetpackcompose.ui.theme.ColorSearchBar
import java.util.Date

@Composable
@Preview
fun HomeScreen() {
    val listNotes = listOf(Note("Palmeiras","SPFC, consectetur, adipisci velit...", Date()), Note("Lorem ipsum","Neque porro quisquam est qui dolorem ipsum quia dolor sit amet, consectetur, adipisci velit...", Date()))
    ImageBackground()
    Column(
        modifier = Modifier
            .padding(16.dp)
    ) {
        SearchNotes(listNotes)
    }
}

@Composable
fun SearchNotes(notes: List<Note>) {
    val (value, onValueChange) = remember { mutableStateOf("") }
    val maxLength = 30
    val filteredNotes = if (value.isEmpty()) {
        notes
    } else {
        notes.filter {
            it.title.contains(value, ignoreCase = true) ||
                    it.description.contains(value, ignoreCase = true) ||
                    it.createdDate.toString().contains(value, ignoreCase = true)
        }
    }

    Column(
        modifier = Modifier.fillMaxSize()
    ) {
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
                .padding(start = 4.dp, top = 16.dp, end = 4.dp, bottom = 22.dp)
                .background(ColorSearchBar, RoundedCornerShape(12.dp))
                .fillMaxWidth(),
            placeholder = { Text(text = "Procurar anotação") },
            colors = TextFieldDefaults.textFieldColors(
                focusedIndicatorColor = Color.Transparent,
                unfocusedIndicatorColor = Color.Transparent,
                backgroundColor = Color.Transparent,
                cursorColor = Color.DarkGray
            )
        )
        LazyColumn {
            items(filteredNotes) { note ->
                NoteItemScreen(note)
            }
        }
    }
}