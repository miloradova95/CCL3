package com.example.dreamdex.navigation


import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.rememberLazyGridState
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.icons.outlined.FavoriteBorder
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
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
import androidx.compose.runtime.rememberCoroutineScope
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
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import coil.compose.AsyncImage
import com.example.dreamdex.R
import com.example.dreamdex.models.Data
import com.example.dreamdex.viewModel.CharacterViewModel
import com.example.dreamdex.db.CharactersViewModel
import com.example.dreamdex.db.FavoriteCharacter
import kotlinx.coroutines.launch

@Composable
fun HomeScreen(navController: NavHostController, charactersViewModel: CharactersViewModel) {
    val characterViewModel = viewModel<CharacterViewModel>()
    // it is calling its own viewModel

    val state = characterViewModel.state
    val favoriteCharacters =
        charactersViewModel.favorites.collectAsState(initial = emptyList()).value

    // UI elements
    val searchQuery = remember { mutableStateOf("") } // stores the current search input
    val isTwoColumns =
        remember { mutableStateOf(true) } // stores whether the grid is displayed in two or three column-mode

    val filteredCharacters = state.characters.filter { character ->
        val fullName = character.name?.full ?: ""
        val nameParts = fullName.split(" ").map { it.lowercase() }

        if (searchQuery.value.isEmpty()) {
            true // Displays all characters when search is empty
        } else {
            val searchLower = searchQuery.value.lowercase()
            val searchParts =
                searchLower.split(" ") // First, middle, last names can be searched separately

            // Checks if each part of the search matches the first letter(s) of the name
            searchParts.all { searchPart ->
                nameParts.any { namePart -> namePart.startsWith(searchPart) }
            }
        }
    }

    // LazyGridState to manage scroll position
    val listState = rememberLazyGridState()
    val coroutineScope = rememberCoroutineScope()

    Scaffold(
        bottomBar = { BottomNavigationBar(navController) },
        content = { paddingValues ->
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(top = 30.dp)
            ) {
                Column(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(bottom = 100.dp),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
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
                            .padding(horizontal = 16.dp)
                    )

                    // Line: Searchbar and Column-mode
                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(horizontal = 16.dp, vertical = 8.dp),
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.spacedBy(8.dp)
                    ) {
                        SearchBar(
                            query = searchQuery.value,
                            onSearchQueryChange = { searchQuery.value = it },
                            modifier = Modifier.weight(1f)
                        )

                        Button(
                            onClick = { isTwoColumns.value = !isTwoColumns.value },
                            modifier = Modifier.width(50.dp).height(48.dp),
                            colors = ButtonDefaults.buttonColors(
                                containerColor = Color(0xFF00315D))
                        ) {
                            Text(
                                text = if (isTwoColumns.value) "〣" else "〢",
                                fontSize = 15.sp,
                                fontWeight = FontWeight.Bold,
                                color = Color.White,
                                textAlign = TextAlign.Center
                            )
                        }
                    }

                    Spacer(modifier = Modifier.height(10.dp))

                    LazyVerticalGrid(
                        state = listState,
                        columns = if (isTwoColumns.value) GridCells.Fixed(2) else GridCells.Fixed(3),
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(horizontal = 14.dp)
                            .background(Color.Transparent)
                            .weight(1f),
                        contentPadding = PaddingValues(bottom = 40.dp)
                    ) {
                        if (filteredCharacters.isNotEmpty()) {
                            items(filteredCharacters.size) { index ->
                                ItemUi(
                                    itemIndex = index,
                                    characterList = filteredCharacters,
                                    navController = navController,
                                    viewModel = charactersViewModel,
                                    isTwoColumns = isTwoColumns.value
                                )
                            }

                            // "More Characters" button as a Card
                            item {
                                val cardHeight = if (isTwoColumns.value) 240.dp else 150.dp

                                Card(
                                    modifier = Modifier
                                        .padding(7.dp)
                                        .width(200.dp)
                                        .height(cardHeight)
                                        .clickable {
                                            // Loads more characters
                                            characterViewModel.loadMoreCharacters()

                                            // Scrolls to top, first item
                                            coroutineScope.launch {
                                                listState.scrollToItem(0)
                                            }
                                        },
                                    shape = RoundedCornerShape(15.dp),
                                    elevation = CardDefaults.cardElevation(8.dp),
                                    colors = CardDefaults.cardColors(containerColor = Color(0xFF00315D)) // Set color if needed
                                ) {
                                    Box(
                                        modifier = Modifier
                                            .fillMaxSize()
                                            .padding(10.dp),
                                        contentAlignment = Alignment.Center
                                    ) {
                                        Text(
                                            text = "More Characters",
                                            fontSize = 15.sp,
                                            color = Color.White,
                                            fontWeight = FontWeight.Bold,
                                            textAlign = TextAlign.Center
                                        )
                                    }
                                }
                            }
                        } else {
                            item {
                                Box(
                                    modifier = Modifier.fillMaxSize(),
                                    contentAlignment = Alignment.Center
                                ) {
                                    Text(
                                        text = "Sumimasen! No characters found",
                                        color = Color.Gray
                                    )
                                }
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
    query: String,
    onSearchQueryChange: (String) -> Unit,
    modifier: Modifier = Modifier
) {
    TextField(
        value = query,
        onValueChange = onSearchQueryChange,
        /*placeholder = {
            Text(
                text = "Search Characters",
                fontWeight = FontWeight.Medium,
                color = Color(0xFF00315D),
            )
        },*/
        modifier = modifier
            .clip(RoundedCornerShape(40.dp))
            .height(48.dp)
            .border(0.5.dp, Color.White, RoundedCornerShape(40.dp)),
        singleLine = true,
        leadingIcon = {
            Icon(
                imageVector = Icons.Filled.Search,
                contentDescription = "Search",
                modifier = Modifier.padding(start = 8.dp),
                tint = Color(0xFF00315D)
            )
        },
        colors = TextFieldDefaults.textFieldColors(
            containerColor = Color.White.copy(0.5f),
            focusedIndicatorColor = Color.Transparent,
            unfocusedIndicatorColor = Color.Transparent
        )
    )
}


@Composable
fun ItemUi(
    itemIndex: Int,
    characterList: List<Data>,
    navController: NavHostController,
    viewModel: CharactersViewModel,
    isTwoColumns: Boolean
) {
    val character = characterList[itemIndex]
    var isFavorite by remember { mutableStateOf(false) }

    viewModel.isFavorite(character.id) { isFav ->
        isFavorite = isFav
    }

    val cardHeight = if (isTwoColumns) 240.dp else 150.dp

    Card(
        modifier = Modifier
            .padding(7.dp)
            .width(200.dp)
            .height(cardHeight)
            .clickable { navController.navigate("Details screen/${character.id}") },
        shape = RoundedCornerShape(15.dp),
        elevation = CardDefaults.cardElevation(8.dp)
    ) {
        Box(modifier = Modifier.fillMaxSize()) {
            AsyncImage(
                model = character.image.large ?: R.drawable.placeholder_image,
                contentDescription = character.name.full ?: "Character",
                modifier = Modifier
                    .fillMaxSize()
                    .clip(RoundedCornerShape(15.dp)),
                contentScale = ContentScale.Crop
            )

            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .background(Color.White.copy(0.7f))
                    .padding(6.dp)
                    .align(Alignment.BottomStart)
            ) {
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    modifier = Modifier.fillMaxWidth()
                ) {
                    Text(
                        text = character.name.full ?: "Unknown",
                        modifier = Modifier.weight(1f),
                        textAlign = TextAlign.Start,
                        color = Color(0xFF00315D),
                        fontWeight = FontWeight.Bold,
                        fontFamily = FontFamily(Font(R.font.inter)),
                        fontSize = 13.sp
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