package com.example.dreamdex.navigation

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
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
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.font.FontWeight.Companion.SemiBold
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

import androidx.navigation.NavHostController

import coil.compose.AsyncImage
import com.example.dreamdex.R
import com.example.dreamdex.db.CharactersViewModel


@Composable
fun FavoritesScreen(navController: NavHostController, viewModel: CharactersViewModel) {
    val allFavorites by viewModel.favorites.collectAsState() // Complete list of favorites
    var searchQuery by remember { mutableStateOf("") } // State to store search input

    // Filtered list based on search query
    val filteredFavorites = allFavorites.filter {
        it.name.contains(searchQuery, ignoreCase = true)
    }

    Scaffold(
        topBar = { TopBar("Favorites")
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 50.dp),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Top
            ) {

                Spacer(modifier = Modifier.height(0.dp))

                Text(
                    text = "DreamDex",
                    fontFamily = FontFamily(Font(R.font.bubble_mint)),
                    textAlign = TextAlign.Center,
                    fontSize = 24.sp,
                    fontWeight = FontWeight.Normal,
                    color = Color(0xFF00315D),
                    modifier = Modifier
                        .padding(horizontal = 16.dp, vertical = 8.dp)
                        .clickable { navController.navigate("Home Screen") }
                )
                Spacer(modifier = Modifier.height(20.dp))
                Text(
                    text = "Favorites",
                    fontFamily = FontFamily(Font(R.font.git_sans)),
                    textAlign = TextAlign.Center,
                    fontSize = 50.sp,
                    fontWeight = FontWeight.Bold,
                    color = Color(0xFF00315D),
                    modifier = Modifier
                        .padding(horizontal = 16.dp)
                        .clickable { navController.navigate("Home Screen") }
                )
                SearchBar(
                    query = searchQuery,
                    onQueryChanged = { searchQuery = it },
                    onClearQuery = { searchQuery = "" }
                )
            }
        },
        bottomBar = { BottomNavigationBar(navController) },
        containerColor = Color.Transparent,
        content = { paddingValues ->
            if (filteredFavorites.isEmpty()) {
                Box(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(paddingValues),
                    contentAlignment = Alignment.Center
                ) {
                    Text(
                        text = "No favorites found",
                        color = Color.Gray)
                }
            } else {
                LazyVerticalGrid(
                    columns = GridCells.Fixed(2),
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(horizontal = 14.dp)
                        .padding(paddingValues)
                ) {
                    items(filteredFavorites.size) { index ->
                        val favorite = filteredFavorites[index]

                        // Card with navigation logic
                        Card(
                            Modifier
                                .wrapContentSize()
                                .padding(10.dp)
                                .clickable { navController.navigate("Details screen/${favorite.id}") },
                            elevation = CardDefaults.cardElevation(8.dp)
                        ) {
                            Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.BottomCenter) {
                                AsyncImage(
                                    model = favorite.image,
                                    contentDescription = favorite.name,
                                    modifier = Modifier
                                        .fillMaxSize()
                                        .width(200.dp)
                                        .height(260.dp)
                                        .clip(RoundedCornerShape(10.dp)),
                                    contentScale = ContentScale.Crop
                                )
                                Column(
                                    modifier = Modifier
                                        .fillMaxWidth()
                                        .background(Color.White.copy(.7f))
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
                                            fontWeight = FontWeight.Bold,
                                            fontSize = 14.sp,
                                            fontFamily = FontFamily(Font(R.font.inter)),
                                        )

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

@Composable
fun SearchBar(query: String, onQueryChanged: (String) -> Unit, onClearQuery: () -> Unit) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .background(Color.Transparent)
            .padding(0.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        TextField(
            value = query,
            onValueChange = onQueryChanged,
            label = { Text(
                text = "Search Characters",
                color = Color(0xFFD1C6FF)) },
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 20.dp, vertical = 10.dp)
                //.height(48.dp)
                .clip(RoundedCornerShape(40.dp)),
            singleLine = true,
            placeholder = { Text(
                text = "Search Characters",
                fontWeight = SemiBold,
                fontFamily = FontFamily(Font(R.font.inter)),
                color = Color(0xFF00315D)) }
        )
        if (query.isNotEmpty()) {
            Text(
                text = "Clear",
                modifier = Modifier
                    .padding(start = 8.dp)
                    .clickable { onClearQuery() },
                color = Color(0xFF00315D)
            )
        }
    }
}
