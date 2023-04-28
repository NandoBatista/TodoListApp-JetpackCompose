package com.fbatista.todo_list_app_jetpackcompose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.fbatista.todo_list_app_jetpackcompose.ui.SplashScreen
import com.fbatista.todo_list_app_jetpackcompose.ui.theme.TodoListAppJetpackComposeTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            TodoListAppJetpackComposeTheme {
                SplashScreen()
            }
        }
    }

    @Preview(showBackground = true)
    @Composable
    fun DefaultPreview() {
        TodoListAppJetpackComposeTheme() {
            SplashScreen()
        }
    }
}