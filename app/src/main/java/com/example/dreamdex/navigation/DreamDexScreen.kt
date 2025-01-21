package com.example.dreamdex.navigation

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Text
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.foundation.clickable
import androidx.navigation.NavHostController
import com.example.dreamdex.models.CharacterEntity
import com.example.dreamdex.viewModel.CharacterViewModel

@Composable
fun DreamDexScreen(navController: NavHostController, characterViewModel: CharacterViewModel) {
    val dreamDexList = characterViewModel.state.favorites // Use favorites from the ViewModel

    Scaffold(
        modifier = Modifier.fillMaxSize()
    ) { paddingValues ->
        LazyColumn(
            modifier = Modifier.padding(paddingValues)
        ) {
            items(dreamDexList) { character ->
                Text(
                    text = character.name,
                    modifier = Modifier
                        .fillMaxWidth()
                        .clickable {
                            // Handle click (e.g., navigate to character details screen)
                        }
                        .padding(16.dp)
                )
            }
        }
    }
}
