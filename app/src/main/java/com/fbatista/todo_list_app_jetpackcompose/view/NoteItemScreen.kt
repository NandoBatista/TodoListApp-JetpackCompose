package com.fbatista.todo_list_app_jetpackcompose.view


import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import com.fbatista.todo_list_app_jetpackcompose.model.Note
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.fbatista.todo_list_app_jetpackcompose.ui.theme.ColorNote
import java.text.SimpleDateFormat
import java.util.Date
import java.util.Locale

@Composable
@Preview
fun NoteItemScreen() {
    var note = Note("Lorem ipsum","Neque porro quisquam est qui dolorem ipsum quia dolor sit amet, consectetur, adipisci velit...", Date())
    val dateFormat = SimpleDateFormat("dd/MM/yyyy", Locale.getDefault())
    val createdDateStr = dateFormat.format(note.createdDate)

    Surface(
        modifier = Modifier
            .padding(start = 4.dp, top = 16.dp, end = 4.dp)
            .fillMaxWidth(),
        shape = RoundedCornerShape(12.dp),
        elevation = 8.dp,
        color = ColorNote
    ) {
        Column(
            modifier = Modifier
                .padding(16.dp)
        ) {
            Text(
                text = note.title,
                style = TextStyle(color = Color.White),
                modifier = Modifier.padding(bottom = 8.dp)
            )
            Text(
                text = note.description,
                style = TextStyle(color = Color.White),
                modifier = Modifier.padding(bottom = 8.dp)
            )
            Text(
                text = "Criado em $createdDateStr",
                style = TextStyle(color = Color.White),
            )
        }
    }
}