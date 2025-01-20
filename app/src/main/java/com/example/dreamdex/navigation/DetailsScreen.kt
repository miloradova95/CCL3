package com.example.dreamdex.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import coil.compose.AsyncImage
import com.example.dreamdex.models.Data
import com.example.dreamdex.viewModel.CharacterViewModel

@Composable
fun DetailsScreen(
    id: Int,
    characterViewModel: CharacterViewModel = viewModel()
) {
    // Fetch the character data using the id
    val character: Data? = characterViewModel.state.characters.find { it.id == id }

    if (character == null) {
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
        // Display character details
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp)
        ) {
            // Name of the character
            Text(
                text = character.name.full,
                style = MaterialTheme.typography.headlineMedium,
                textAlign = TextAlign.Center,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(bottom = 16.dp)
            )

            // Image of the character
            AsyncImage(
                model = character.image.large,
                contentDescription = character.name.full,
                modifier = Modifier
                    .fillMaxWidth()
                    .height(300.dp)
                    .padding(bottom = 16.dp),
                contentScale = ContentScale.Crop
            )

            // Display character attributes first
            Column(modifier = Modifier.padding(bottom = 16.dp)) {
                character.gender?.let {
                    Text(
                        text = "Gender: $it",
                        style = MaterialTheme.typography.bodyLarge,
                        modifier = Modifier.padding(bottom = 8.dp)
                    )
                }
                character.age?.let {
                    Text(
                        text = "Age: $it",
                        style = MaterialTheme.typography.bodyLarge,
                        modifier = Modifier.padding(bottom = 8.dp)
                    )
                }
                character.dateOfBirth?.let {
                    Text(
                        text = "Date of Birth: $it",
                        style = MaterialTheme.typography.bodyLarge,
                        modifier = Modifier.padding(bottom = 8.dp)
                    )
                }
                character.bloodType?.let {
                    Text(
                        text = "Blood Type: $it",
                        style = MaterialTheme.typography.bodyLarge,
                        modifier = Modifier.padding(bottom = 8.dp)
                    )
                }
            }

            // Description (at the end)
            character.description?.let {
                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(16.dp)
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
