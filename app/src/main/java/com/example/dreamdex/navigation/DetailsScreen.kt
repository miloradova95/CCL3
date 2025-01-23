package com.example.dreamdex.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import coil.compose.AsyncImage
import com.example.dreamdex.db.CharactersViewModel
import com.example.dreamdex.db.FavoriteCharacter
import com.example.dreamdex.models.Data
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


    // Fetch the character data using the id

    if (character.value == null) {
        // Show an error or loading message if character not found
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
        // Display character details in a scrollable column
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp)
                .verticalScroll(rememberScrollState()),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            // Name of the character
            Text(
                text = character.value!!.name,
                style = MaterialTheme.typography.headlineMedium,
                textAlign = TextAlign.Center,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 24.dp)
                    .padding(bottom = 16.dp)

            )

            // Image of the character
            AsyncImage(
                model = character.value!!.image,
                contentDescription = character.value!!.name,
                modifier = Modifier
                    .width(200.dp)
                    .height(300.dp)
                    .padding(bottom = 16.dp),
                contentScale = ContentScale.Crop
            )

            // Description (at the end)
            character.value!!.title.let {
                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .background(MaterialTheme.colorScheme.surface, RoundedCornerShape(8.dp))
                        .padding(16.dp)
                ) {
                    Text(
                        text = it,
                        style = MaterialTheme.typography.bodyMedium,
                        textAlign = TextAlign.Justify
                    )
                }
            }
            character.value!!.description?.let {
                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .background(MaterialTheme.colorScheme.surface, RoundedCornerShape(8.dp))
                        .padding(16.dp)
                ) {
                    Text(
                        text = it,
                        style = MaterialTheme.typography.bodyMedium,
                        textAlign = TextAlign.Justify
                    )
                }
            }
        }
    }
}
