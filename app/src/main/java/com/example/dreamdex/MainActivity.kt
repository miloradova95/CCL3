package com.example.dreamdex

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import com.example.dreamdex.navigation.Navigation
//import com.example.dreamdex.ui.theme.DreamDexTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            Surface(
                modifier = Modifier.fillMaxSize(),
                color = Color.White
            ) {
                Box(
                    modifier = Modifier.fillMaxSize()
                ) {
                    Image(
                        painter = painterResource(id = R.drawable.background_image),
                        contentDescription = null,
                        modifier = Modifier.fillMaxSize(),
                        contentScale = ContentScale.Crop // Adjust the image scaling if needed
                    )
                    Navigation()
                }
            }
        }
    }
}
