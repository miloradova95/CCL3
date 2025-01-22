package com.example.dreamdex.navigation

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.outlined.FavoriteBorder
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import com.example.dreamdex.navigation.BottomNavigationBar
import com.example.dreamdex.navigation.TopBar
import androidx.navigation.compose.rememberNavController
import coil.compose.AsyncImage
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
        containerColor = Color.Transparent,
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

                        // Card with navigation logic
                        Card(
                            Modifier
                                .wrapContentSize()
                                .padding(10.dp)
                                .clickable { navController.navigate("Details screen/${favorite.id}") }, // Navigation here
                            elevation = CardDefaults.cardElevation(8.dp)
                        ) {
                            Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.BottomCenter) {
                                AsyncImage(
                                    model = favorite.image,
                                    contentDescription = favorite.name,
                                    modifier = Modifier
                                        .fillMaxSize()
                                        .clip(
                                            RoundedCornerShape(
                                                10.dp
                                            )
                                        ),
                                    contentScale = ContentScale.Crop
                                )
                                Column(
                                    modifier = Modifier
                                        .fillMaxWidth()
                                        .background(Color.LightGray.copy(.7f))
                                        .padding(6.dp)
                                ) {
                                    Row(
                                        verticalAlignment = Alignment.CenterVertically,
                                        modifier = Modifier.fillMaxWidth()
                                    ) {
                                        Text(
                                            text = favorite.name,
                                            modifier = Modifier.weight(1f),
                                            textAlign = TextAlign.Start,
                                            color = Color.Black,
                                            fontWeight = FontWeight.Bold
                                        )

                                        // Assuming you have a way to determine if a character is a favorite
                                        val isFavorite = true // Replace with your logic

                                        Icon(
                                            imageVector = if (isFavorite) Icons.Filled.Favorite else Icons.Outlined.FavoriteBorder,
                                            contentDescription = "Favorite",
                                            modifier = Modifier
                                                .size(24.dp)
                                                .clickable {
                                                    if (isFavorite) {
                                                        viewModel.removeFavorite(favorite)
                                                    } else {
                                                        viewModel.addFavorite(favorite)
                                                    }
                                                },
                                            tint = Color.Red
                                        )
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
    )
}
