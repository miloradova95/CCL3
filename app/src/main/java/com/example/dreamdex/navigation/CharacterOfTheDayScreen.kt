package com.example.dreamdex.navigation

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import coil.compose.AsyncImage
import com.example.dreamdex.R

@Composable
fun CharacterOfTheDayScreen(navController: NavHostController) {
    Scaffold(
        topBar = {
            TopBar(title = "Character of the Day") // The top bar remains unchanged
        },
        bottomBar = { BottomNavigationBar(navController) }, // The bottom navigation bar remains unchanged
        containerColor = Color.Transparent, // Make the scaffold container transparent
        content = { paddingValues ->
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(paddingValues)
                    .background(Color.Transparent), // Set the Box background to transparent
                contentAlignment = Alignment.Center
            ) {
                Card(
                    modifier = Modifier.padding(16.dp),
                    shape = RoundedCornerShape(12.dp),
                    elevation = CardDefaults.cardElevation(8.dp), // Card elevation remains the same
                ) {
                    Column(
                        modifier = Modifier
                            .background(Color.White)
                            .padding(16.dp),
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {
                        // Placeholder Image (since no character data is passed now)
                        AsyncImage(
                            model = R.drawable.placeholder_image, // Placeholder image used in place of character image
                            contentDescription = "Placeholder Character",
                            modifier = Modifier.padding(8.dp)
                        )
                        // Title for the Character of the Day section
                        Text(
                            text = "Character of the Day",
                            fontSize = 24.sp,
                            fontWeight = FontWeight.Bold,
                            color = Color.Black
                        )
                        // Some static text or additional information (optional)
                        Text(
                            text = "Stay tuned for today's featured character!",
                            fontSize = 16.sp,
                            color = Color.Gray
                        )
                    }
                }
            }
        }
    )
}
