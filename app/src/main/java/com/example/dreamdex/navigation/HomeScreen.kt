package com.example.dreamdex.navigation


import androidx.compose.animation.core.copy
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.outlined.FavoriteBorder
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
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
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import coil.compose.AsyncImage
import com.example.dreamdex.R
import com.example.dreamdex.models.Data
import com.example.dreamdex.viewModel.CharacterViewModel
import com.example.dreamdex.db.CharactersViewModel
import com.example.dreamdex.db.FavoriteCharacter


@Composable
fun HomeScreen(navController: NavHostController, charactersViewModel: CharactersViewModel) {
    val characterViewModel = viewModel<CharacterViewModel>()


    val state = characterViewModel.state
    val favoriteCharacters = charactersViewModel.favorites.collectAsState(initial = emptyList()).value

    val searchQuery = remember { mutableStateOf("") }

    val filteredCharacters = state.characters.filter {
        it.name?.full?.contains(searchQuery.value, ignoreCase = true) == true
    }

    Scaffold(
        modifier = Modifier,
        topBar = { TopBar("Characters") },
        bottomBar = { BottomNavigationBar(navController) },
        content = { paddingValues ->
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(paddingValues)
            ) {
                SearchBar(
                    query = searchQuery.value,
                    onSearchQueryChange = { searchQuery.value = it }
                )

                // "More Characters" button beneath the search bar
                Button(
                    onClick = { characterViewModel.loadMoreCharacters() },
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(16.dp)
                ) {
                    Text("More Characters")
                }

                Spacer(modifier = Modifier.height(16.dp))

                LazyVerticalGrid(
                    columns = GridCells.Fixed(2),
                    modifier = Modifier
                        .fillMaxSize()
                        .background(Color.Transparent)
                ) {
                    if (filteredCharacters.isNotEmpty()) {
                        items(filteredCharacters.size) {
                            ItemUi(
                                itemIndex = it,
                                characterList = filteredCharacters,
                                navController = navController,
                                viewModel = charactersViewModel
                            )
                        }
                    } else {
                        item {
                            Box(
                                modifier = Modifier.fillMaxSize(),
                                contentAlignment = Alignment.Center
                            ) {
                                Text("No characters found")
                            }
                        }
                    }
                }
            }
        },
        containerColor = Color.Transparent
    )
}


@Composable
fun SearchBar(
    query: String,  // query is now passed from the parent composable
    onSearchQueryChange: (String) -> Unit
) {
    Column(modifier = Modifier.fillMaxWidth()) {
        TextField(
            value = query,  // Use the query value passed from the parent
            onValueChange = onSearchQueryChange,  // Pass the change handler
            label = { Text("Search Characters") },
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp),
            singleLine = true
        )
    }
}

/*@Composable
fun ItemUi(itemIndex: Int, characterList: List<Data>, navController: NavHostController) {
    Card(
        Modifier
            .wrapContentSize()
            .padding(10.dp)
            .clickable {
                navController.navigate("Details screen/${characterList[itemIndex].id}")
            },
        elevation = CardDefaults.cardElevation(8.dp)
    ) {
        Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.BottomCenter) {
            AsyncImage(
                model = characterList[itemIndex].image?.large ?: R.drawable.placeholder_image, // Adjusted for AniList
                contentDescription = characterList[itemIndex].name?.full ?: "Character", // Adjusted for AniList
                modifier = Modifier
                    .fillMaxSize()
                    .clip(RoundedCornerShape(10.dp)),
                contentScale = ContentScale.Crop
            )
            Column(
                modifier = Modifier
                    .fillMaxHeight()
                    .background(Color.LightGray.copy(.7f))
                    .padding(6.dp)
            ) {
                Text(
                    text = characterList[itemIndex].name?.full ?: "Unknown", // Adjusted for AniList
                    modifier = Modifier
                        .fillMaxWidth(),
                    textAlign = TextAlign.Center,
                    color = Color.Black,
                    fontWeight = FontWeight.Bold,
                    maxLines = 1,
                    style = TextStyle(
                        shadow = Shadow(
                            Color(0xFFFC6603), offset = Offset(1f, 1f), 3f
                        )
                    )
                )
            }
        }
    }
}*/

@Composable
fun ItemUi(
    itemIndex: Int,
    characterList: List<Data>,
    navController: NavHostController,
    viewModel: CharactersViewModel
) {
    val character = characterList[itemIndex]
    var isFavorite by remember { mutableStateOf(false) }

    // Query favorite status
        // Ensure the callback is updating the state correctly
        viewModel.isFavorite(character.id) { isFav ->
            isFavorite = isFav // Update the isFavorite state
        }

    Card(
        Modifier
            .wrapContentSize()
            .padding(10.dp)
            .clickable { navController.navigate("Details screen/${character.id}") },
        elevation = CardDefaults.cardElevation(8.dp)
    ) {
        Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.BottomCenter) {
            AsyncImage(
                model = character.image.large ?: R.drawable.placeholder_image,
                contentDescription = character.name.full ?: "Character",
                modifier = Modifier
                    .fillMaxSize()
                    .clip(RoundedCornerShape(10.dp)),
                contentScale = ContentScale.Crop
            )
            Column(
                modifier = Modifier
                    .fillMaxHeight()
                    .background(Color.LightGray.copy(.7f))
                    .padding(6.dp)
            ) {
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    modifier = Modifier.fillMaxWidth()
                ) {
                    Text(
                        text = character.name.full ?: "Unknown",
                        modifier = Modifier.weight(1f),
                        textAlign = TextAlign.Start,
                        color = Color.Black,
                        fontWeight = FontWeight.Bold
                    )

                    Icon(
                        imageVector = if (isFavorite) Icons.Filled.Favorite else Icons.Outlined.FavoriteBorder,
                        contentDescription = "Favorite",
                        modifier = Modifier
                            .size(24.dp)
                            .clickable {
                                if (isFavorite) {
                                    viewModel.removeFavorite(
                                        FavoriteCharacter(
                                            character.id,
                                            character.name.full,
                                            character.image.large,
                                            character.description
                                        )
                                    )
                                } else {
                                    viewModel.addFavorite(
                                        FavoriteCharacter(
                                            character.id,
                                            character.name.full,
                                            character.image.large,
                                            character.description
                                        )
                                    )
                                }
                            },
                        tint = Color.Red
                    )
                }
            }
        }
    }
}

/*@Preview(showBackground = true)
@Composable
fun PreviewHomeScreen() {
    val navController = rememberNavController()
    HomeScreen(navController = navController)
}*/

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TopBar(title: String) {
    TopAppBar(
        title = {
            Box(
                modifier = Modifier.fillMaxWidth(),
                contentAlignment = Alignment.Center
            ) {

            }
        },
        colors = TopAppBarDefaults.centerAlignedTopAppBarColors(
            containerColor = Color.Transparent
        )
    )
}