package com.example.dreamdex.navigation

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shadow
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import coil.compose.AsyncImage
import com.example.dreamdex.R
import com.example.dreamdex.models.Data
import com.example.dreamdex.viewModel.CharacterViewModel
import kotlin.random.Random

@Composable
fun CharacterOfTheDayScreen(navController: NavHostController) {
    val characterViewModel = viewModel<CharacterViewModel>()
    val state = characterViewModel.state

    // Select a random character
    val randomCharacter = if (state.characters.isNotEmpty()) {
        state.characters.random()
    } else {
        null // Handle when no characters are available
    }

    Scaffold(
        topBar = {
            TopBar(title = "Character of the Day") // The top bar remains unchanged
        },
        bottomBar = { BottomNavigationBar(navController) }, // The bottom navigation bar remains unchanged
        containerColor = Color.Transparent, // Make the scaffold container transparent
        content = { paddingValues ->
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(paddingValues)
                    .background(Color.Transparent),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text(
                    text = " Random Character Generator ",
                    fontSize = 28.sp,
                    style = TextStyle(
                        fontSize = 34.sp,
                        shadow = Shadow(
                            color = Color(0xFFFC5A03),
                        ),
                        fontFamily = FontFamily(Font(R.font.metal_mania)),
                        textAlign = TextAlign.Center
                    ),
                    modifier = Modifier.padding(16.dp)
                )

                // Content
                if (randomCharacter != null) {
                    Card(
                        modifier = Modifier
                            .padding(16.dp)
                            .clickable {
                                // Navigate to the DetailsScreen with the selected character's ID
                                navController.navigate("Details screen/${randomCharacter.id}")
                            },
                        shape = RoundedCornerShape(12.dp),
                        elevation = CardDefaults.cardElevation(8.dp), // Card elevation remains the same
                    ) {
                        Column(
                            modifier = Modifier
                                .background(Color.White)
                                .padding(16.dp),
                            horizontalAlignment = Alignment.CenterHorizontally
                        ) {
                            AsyncImage(
                                model = randomCharacter.image?.large ?: R.drawable.placeholder_image,
                                contentDescription = randomCharacter.name?.full ?: "Character of the Day",
                                modifier = Modifier
                                    .padding(8.dp)
                                    .width(200.dp)
                                    .height(300.dp)
                            )
                            Text(
                                text = randomCharacter.name?.full ?: "Unknown Character",
                                fontSize = 24.sp,
                                fontWeight = FontWeight.Bold,
                                color = Color.Black
                            )
                            Text(
                                text = "Click to see more details about this character!",
                                fontSize = 16.sp,
                                color = Color.Gray
                            )
                        }
                    }
                } else {
                    // Show a fallback message if no characters are available
                    Text(
                        text = "No characters available for the day!",
                        fontSize = 18.sp,
                        color = Color.Gray
                    )
                }
            }
        }
    )
}



@Preview(showBackground = true)
@Composable
fun PreviewCharacterOfTheDayScreen() {
    val navController = rememberNavController()
    CharacterOfTheDayScreen(navController = navController)
}
