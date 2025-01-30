package com.example.dreamdex.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.Alignment
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Color.Companion.White
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import coil.compose.AsyncImage
import com.example.dreamdex.R
import com.example.dreamdex.db.CharactersViewModel
import com.example.dreamdex.db.FavoriteCharacter
import com.example.dreamdex.models.Data
import com.example.dreamdex.navigation.BottomNavigationBar
import com.example.dreamdex.viewModel.CharacterViewModel

@Composable
fun DetailsScreen(
    id: Int,
    characterViewModel: CharacterViewModel = viewModel(),
    charactersViewModel: CharactersViewModel = viewModel()
) {
    val character = remember { mutableStateOf<FavoriteCharacter?>(null) }
    charactersViewModel.isFavorite(id, callback = { isFav ->

            if(isFav) {
                character.value = charactersViewModel.favorites.value.find { it.id == id }
            }
            else {
                val characterData = characterViewModel.state.characters.find { it.id == id }
                if (characterData != null) {
                    character.value = FavoriteCharacter(
                        characterData.id,
                        characterData.name.full,
                        characterData.image.large,
                        characterData.description,
                        characterData.media.nodes[0].title.english ?: characterData.media.nodes[0].title.romaji,
                    )
                }
            }
        }
    )




    if (character.value == null) {
        Box(
            modifier = Modifier.fillMaxSize(),
            contentAlignment = Alignment.Center
        ) {
            Text(
                text = "Character not found",
                style = MaterialTheme.typography.headlineMedium,
                textAlign = TextAlign.Center
            )
        }
    } else {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(25.dp)
                .padding(top = 50.dp)
                .verticalScroll(rememberScrollState()),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            // Name of the character
            Text(
                text = character.value!!.name,
                fontFamily = FontFamily(Font(R.font.git_sans)),
                color = Color(0xFF00315D),
                fontSize = 45.sp,
                style = MaterialTheme.typography.headlineMedium,
                textAlign = TextAlign.Center,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(bottom = 16.dp)

            )

            Card(
                modifier = Modifier
                    .width(180.dp)
                    .height(260.dp)
                    .padding(bottom = 16.dp),
                elevation = CardDefaults.cardElevation(8.dp)
            ) {
                AsyncImage(
                    model = character.value!!.image,
                    contentDescription = character.value!!.name,
                    modifier = Modifier
                        .fillMaxSize()
                        .width(200.dp)
                        .height(260.dp)
                        .clip(RoundedCornerShape(15.dp)),
                    contentScale = ContentScale.Crop
                )
            }

            character.value!!.title.let {
                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .background(color = Color.White.copy(0.5f), RoundedCornerShape(20.dp))
                        .border(0.5.dp, Color.White, RoundedCornerShape(20.dp))
                        .padding(15.dp)
                        .padding(horizontal = 25.dp),
                    contentAlignment = Alignment.Center
                ) {
                    Text(
                        text = it,
                        style = MaterialTheme.typography.bodyMedium,
                        textAlign = TextAlign.Center, // Center-align text
                        fontSize = 15.sp,
                        fontWeight = FontWeight.Bold,
                        fontFamily = FontFamily(Font(R.font.inter)),
                        color = Color(0xFF00315D)
                    )
                }
            }
            Spacer(modifier = Modifier.height(10.dp))
            character.value!!.description?.let {
                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .background(color = Color.White.copy(0.5f), RoundedCornerShape(20.dp))
                        .border(0.5.dp, Color.White, RoundedCornerShape(20.dp))
                        .padding(18.dp),
                ) {
                    Text(
                        text = it,
                        style = MaterialTheme.typography.bodyMedium,
                        textAlign = TextAlign.Justify,
                        fontWeight = FontWeight.Normal,
                        color = Color(0xFF00315D)
                    )
                }
            }
        }
    }
}
