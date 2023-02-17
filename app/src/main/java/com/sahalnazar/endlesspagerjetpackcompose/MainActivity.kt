package com.sahalnazar.endlesspagerjetpackcompose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material.Text
import com.sahalnazar.endlesspagerjetpackcompose.ui.theme.EndlesspagerjepackcomposeTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            EndlesspagerjepackcomposeTheme {
              Text(text = "Hello :)")  
            }
        }
    }
}
