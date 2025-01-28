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
import androidx.compose.foundation.layout.width
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
import androidx.compose.material3.TextFieldDefaults
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
import com.example.dreamdex.db.CharactersViewModel
import com.example.dreamdex.db.FavoriteCharacter


@Composable
fun HomeScreen(navController: NavHostController, charactersViewModel: CharactersViewModel) {
    val characterViewModel = viewModel<CharacterViewModel>()
    // it is calling its own viewModel

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
                    .padding(top = 50.dp),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {

                Spacer(modifier = Modifier.height(10.dp))
                Text(
                    text = "DreamDex",
                    fontFamily = FontFamily(Font(R.font.bubble_mint)),
                    textAlign = TextAlign.Center,
                    fontSize = 24.sp,
                    color = Color(0xFF00315D),
                    modifier = Modifier
                        .padding(horizontal = 16.dp)
                )
                Spacer(modifier = Modifier.height(10.dp))
                Text(
                    text = "Characters",
                    fontFamily = FontFamily(Font(R.font.git_sans)),
                    textAlign = TextAlign.Center,
                    fontSize = 40.sp,
                    fontWeight = FontWeight.Bold,
                    color = Color(0xFF00315D),
                    modifier = Modifier
                        .padding(horizontal = 16.dp)
                )
                SearchBar(
                    query = searchQuery.value,
                    onSearchQueryChange = { searchQuery.value = it }
                )

                // "More Characters" button beneath the search bar
                Button(
                    onClick = { characterViewModel.loadMoreCharacters() },
                    modifier = Modifier
                        .width(170.dp)
                        .align(Alignment.CenterHorizontally)
                        .padding(0.dp)
                ) {
                    Text(
                        text = "More Characters",
                        fontSize = 15.sp,
                        color = Color(0xFF00315D))
                }

                Spacer(modifier = Modifier.height(5.dp))

                LazyVerticalGrid(
                    columns = GridCells.Fixed(2),
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(horizontal = 14.dp)
                        .background(Color.Transparent),
                    contentPadding = paddingValues,
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
                                Text(
                                    text = "Sumimasen! No characters found",
                                    color = Color.Gray)

                            }
                        }
                    }
                }
            }
        },
        containerColor = Color.Transparent
    )
}


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SearchBar(
    query: String,  // query is now passed from the parent composable
    onSearchQueryChange: (String) -> Unit
) {
    Column(modifier = Modifier.fillMaxWidth()) {
        TextField(
            value = query,  // Use the query value passed from the parent
            onValueChange = onSearchQueryChange,  // Pass the change handler
            label = { Text(
                text = "Search Characters",
                color = Color(0xFFD1C6FF)) },
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 20.dp, vertical = 10.dp)
                .height(48.dp)
                .clip(RoundedCornerShape(40.dp))
                .background(Color.White.copy(alpha = 0.4f)),
            singleLine = true,
            colors = TextFieldDefaults.textFieldColors(
                focusedIndicatorColor = Color.Transparent,
                unfocusedIndicatorColor = Color.Transparent
            )
        )
    }
}

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
                    .width(200.dp)
                    .height(260.dp)
                    .clip(RoundedCornerShape(15.dp)),
                contentScale = ContentScale.Crop
            )
            Column(
                modifier = Modifier
                    .fillMaxHeight()
                    .background(Color.White.copy(.7f))
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
                        color = Color(0xFF00315D), // Keep only this one
                        fontWeight = FontWeight.Bold,
                        fontFamily = FontFamily(Font(R.font.inter))
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
                                            character.description,
                                            character.media.nodes[0].title.english ?: character.media.nodes[0].title.romaji,
                                        )
                                    )
                                } else {
                                    viewModel.addFavorite(
                                        FavoriteCharacter(
                                            character.id,
                                            character.name.full,
                                            character.image.large,
                                            character.description,
                                            character.media.nodes[0].title.english ?: character.media.nodes[0].title.romaji,
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
                modifier = Modifier
                    .fillMaxWidth(),
                contentAlignment = Alignment.Center
            ) {

            }
        },
        colors = TopAppBarDefaults.centerAlignedTopAppBarColors(
            containerColor = Color.Transparent
        )
    )
}