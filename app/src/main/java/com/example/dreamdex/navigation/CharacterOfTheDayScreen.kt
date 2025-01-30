package com.example.dreamdex.navigation

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shadow
import androidx.compose.ui.layout.ContentScale
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


    var randomCharacter by remember { mutableStateOf<Data?>(null) }


    fun randomizeCharacter() {
        if (state.characters.isNotEmpty()) {
            randomCharacter = state.characters.random()
        }
    }


    LaunchedEffect(Unit) {
        randomizeCharacter()
    }

    Scaffold(
        bottomBar = { BottomNavigationBar(navController) },
        containerColor = Color.Transparent,
        content = { paddingValues ->
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(top = 30.dp)
            ) {
                Column(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(horizontal = 16.dp)
                        .padding(bottom = 100.dp),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    // Title Text
                    Text(
                        text = "DreamDex",
                        fontFamily = FontFamily(Font(R.font.bubble_mint)),
                        textAlign = TextAlign.Center,
                        fontSize = 20.sp,
                        color = Color(0xFF00315D),
                        modifier = Modifier
                            .padding(horizontal = 16.dp, vertical = 8.dp)
                            .clickable { navController.navigate("Home Screen") }
                    )
                    Spacer(modifier = Modifier.height(30.dp))
                    Text(
                        text = "Characters",
                        fontFamily = FontFamily(Font(R.font.git_sans)),
                        textAlign = TextAlign.Center,
                        fontSize = 45.sp,
                        color = Color(0xFF00315D),
                        modifier = Modifier
                    )

                    Text(
                        text = "Randomizer",
                        fontFamily = FontFamily(Font(R.font.git_sans)),
                        textAlign = TextAlign.Center,
                        fontSize = 45.sp,
                        color = Color(0xFF00315D),
                        modifier = Modifier
                    )

                    Spacer(modifier = Modifier.height(15.dp))

                    if (randomCharacter != null) {
                        Card(
                            modifier = Modifier
                                .width(180.dp)
                                .height(260.dp)
                                .padding(bottom = 16.dp)
                                .clickable {
                                    navController.navigate("Details screen/${randomCharacter!!.id}")
                                },
                            elevation = CardDefaults.cardElevation(8.dp)
                        ) {
                            AsyncImage(
                                model = randomCharacter!!.image?.large ?: R.drawable.placeholder_image,
                                contentDescription = randomCharacter!!.name?.full ?: "Character of the Day",
                                modifier = Modifier
                                    .fillMaxSize()
                                    .clip(RoundedCornerShape(15.dp)),
                                contentScale = ContentScale.Crop
                            )
                            Text(
                                text = randomCharacter!!.name?.full ?: "Unknown Character",
                                fontSize = 16.sp,
                                fontWeight = FontWeight.Bold,
                                color = Color(0xFF00315D),
                                fontFamily = FontFamily(Font(R.font.inter)),
                                modifier = Modifier.padding(8.dp)
                            )
                        }
                    } else {

                        Text(
                            text = "Press Randomize to get a character!",
                            fontSize = 15.sp,
                            color = Color.Gray,
                            modifier = Modifier.padding(bottom = 16.dp)
                        )
                    }

                    Button(
                        onClick = { randomizeCharacter() },
                        colors = ButtonDefaults.buttonColors(containerColor = Color.Transparent),
                        modifier = Modifier
                            .padding(8.dp)
                            .wrapContentWidth()
                            .height(50.dp)
                            .background(
                                color = Color.White.copy(0.5f),
                                shape = RoundedCornerShape(20.dp)
                            )
                            .border(
                                0.5.dp,
                                Color.White,
                                shape = RoundedCornerShape(20.dp)
                            )
                            .clip(RoundedCornerShape(20.dp))
                    ) {
                        Text(
                            text = "Randomize",
                            color = Color(0xFF00315D),
                            fontSize = 18.sp,
                            fontWeight = FontWeight.SemiBold
                        )
                    }
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
