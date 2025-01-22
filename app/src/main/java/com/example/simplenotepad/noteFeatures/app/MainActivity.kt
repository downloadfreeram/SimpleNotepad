package com.example.simplenotepad.noteFeatures.app

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.example.simplenotepad.ui.theme.SimpleNotepadTheme

class MainActivity : ComponentActivity() {
    @SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            SimpleNotepadTheme {
                MainScreen()
            }
        }
    }
}

@Composable
fun MainScreen() {
    Text(
        text = "Simple Notepad",
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    SimpleNotepadTheme {
        MainScreen()
    }
}