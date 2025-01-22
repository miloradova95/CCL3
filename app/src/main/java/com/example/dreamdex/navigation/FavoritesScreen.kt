package com.example.dreamdex.navigation

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import com.example.dreamdex.navigation.BottomNavigationBar
import com.example.dreamdex.navigation.TopBar
import androidx.navigation.compose.rememberNavController
import com.example.dreamdex.db.CharactersViewModel
import com.example.dreamdex.models.Data
import com.example.dreamdex.models.Image
import com.example.dreamdex.models.MediaConnection
import com.example.dreamdex.models.Name

/*@Composable
fun FavoritesScreen(navController: NavController) {
    // Ensure that navController is a NavHostController
    val navHostController = navController as? NavHostController ?: rememberNavController()

    Scaffold(
        modifier = Modifier.fillMaxSize(),
        topBar = {
            // Use the same TopBar composable for styling consistency
            TopBar("Favorites")
        },
        bottomBar = { BottomNavigationBar(navController = navHostController) },
        content = { paddingValues ->
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(paddingValues)
            ) {
                // Here you can add your favorite characters list or other content
                /*Text(
                    text = "List of your favorite characters will be displayed here.",
                    modifier = Modifier.padding(16.dp)
                )*/
            }
        },
        containerColor = androidx.compose.ui.graphics.Color.Transparent
    )
}*/

@Composable
fun FavoritesScreen(navController: NavHostController, viewModel: CharactersViewModel) {
    val favorites by viewModel.favorites.collectAsState()

    Scaffold(
        topBar = { TopBar("Favorites") },
        bottomBar = { BottomNavigationBar(navController) },
        content = { paddingValues ->
            if (favorites.isEmpty()) {
                Box(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(paddingValues),
                    contentAlignment = Alignment.Center
                ) {
                    Text("No favorites yet.")
                }
            } else {
                LazyVerticalGrid(
                    columns = GridCells.Fixed(2),
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(paddingValues)
                ) {
                    items(favorites.size) { index ->
                        val favorite = favorites[index]
                        ItemUi(
                            itemIndex = index,
                            characterList = favorites.map { Data(it.id, Name(it.name, null), Image(it.image, ""), null, null, MediaConnection(emptyList()), null, null, null, null) },
                            navController = navController,
                            viewModel = viewModel
                        )
                    }
                }
            }
        }
    )
}
