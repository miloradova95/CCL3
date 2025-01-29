package com.example.dreamdex.navigation

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
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
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
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

@Composable
fun CharacterOfTheDayScreen(navController: NavHostController) {
    val characterViewModel = viewModel<CharacterViewModel>()
    val state = characterViewModel.state

    val randomCharacter = if (state.characters.isNotEmpty()) {
        state.characters.random()
    } else {
        null
    }

    Scaffold(
        topBar = {
            TopBar(title = "Character of the Day")
        },
        bottomBar = { BottomNavigationBar(navController) },
        containerColor = Color.Transparent,
        content = { paddingValues ->
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(top = 30.dp),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text(
                    text = "DreamDex",
                    fontFamily = FontFamily(Font(R.font.bubble_mint)),
                    textAlign = TextAlign.Center,
                    fontSize = 24.sp,
                    color = Color(0xFF00315D),
                    modifier = Modifier
                        .padding(horizontal = 16.dp, vertical = 8.dp)
                        .clickable { navController.navigate("Home Screen") }
                )
                Spacer(modifier = Modifier.height(20.dp))
                Text(
                    text = "Character",
                    fontFamily = FontFamily(Font(R.font.git_sans)),
                    textAlign = TextAlign.Center,
                    fontSize = 50.sp,
                    color = Color(0xFF00315D)
                )
                Spacer(modifier = Modifier.width(4.dp))  // Adjust the width to control the space
                Text(
                    text = "Randomizer",
                    fontFamily = FontFamily(Font(R.font.git_sans)),
                    textAlign = TextAlign.Center,
                    fontSize = 50.sp,
                    color = Color(0xFF00315D)
                )

                if (randomCharacter != null) {
                    Card(
                        modifier = Modifier
                            .padding(16.dp)
                            .clickable {
                                navController.navigate("Details screen/${randomCharacter.id}")
                            },
                        shape = RoundedCornerShape(12.dp),
                        //elevation = CardDefaults.cardElevation(8.dp),
                    ) {
                        Column(
                            modifier = Modifier
                                .fillMaxWidth()
                                .background(Color(0xFFD1C6FF))
                                .padding(10.dp),
                            horizontalAlignment = Alignment.CenterHorizontally
                        ) {
                            AsyncImage(
                                model = randomCharacter.image?.large
                                    ?: R.drawable.placeholder_image,
                                contentDescription = randomCharacter.name?.full
                                    ?: "Character of the Day",
                                modifier = Modifier
                                    .padding(8.dp)
                                    .width(200.dp)
                                    .height(260.dp)
                                    .clip(RoundedCornerShape(15.dp))
                            )
                            Text(
                                text = randomCharacter.name?.full ?: "Unknown Character",
                                fontSize = 16.sp,
                                fontWeight = FontWeight.Bold,
                                color = Color(0xFF00315D),
                                fontFamily = FontFamily(Font(R.font.inter)),
                            )
                            /*Text(
                                text = "Click to see more details about this character!",
                                fontSize = 18.sp,
                                color = Color.Gray
                            )*/
                        }
                    }
                } else {
                    Text(
                        text = "Chotto Matte!",
                        fontSize = 15.sp,
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