package com.example.dreamdex.navigation

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shadow
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.TextStyle
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

@Composable
fun BrowseScreen(navController: NavHostController) {
    val characterViewModel = viewModel<CharacterViewModel>()
    val state = characterViewModel.state

    // Fixing the state initialization
    val searchQuery = remember { mutableStateOf("") }

    // Filter characters based on the search query
    val filteredCharacters = state.characters.filter {
        it.name?.full?.contains(searchQuery.value, ignoreCase = true) == true
    }

    Scaffold(
        modifier = Modifier.background(Color.Transparent),
        topBar = {
            TopBar()
        }, content = { paddingValues ->

            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(paddingValues)
            ) {
                // Pass the query and change handler to SearchBar
                SearchBar(
                    query = searchQuery.value,
                    onSearchQueryChange = { searchQuery.value = it }  // Use .value to update state
                )

                Spacer(modifier = Modifier.height(16.dp))

                LazyVerticalGrid(
                    columns = GridCells.Fixed(2),
                    Modifier
                        .fillMaxSize()
                        .background(Color.Transparent)
                ) {
                    if (filteredCharacters.isNotEmpty()) {
                        items(filteredCharacters.size) {
                            ItemUi(
                                itemIndex = it,
                                characterList = filteredCharacters,
                                navController = navController
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

@Composable
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
}

@Preview(showBackground = true)
@Composable
fun PreviewHomeScreen() {
    val navController = rememberNavController()
    BrowseScreen(navController = navController)
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TopBar() {
    TopAppBar(
        title = {
            Box(
                modifier = Modifier.fillMaxWidth(),
                contentAlignment = Alignment.Center
            ) {
                Text(
                    text = "Characters",
                    style = TextStyle(
                        fontFamily = FontFamily.Serif, // Replace with your custom FontFamily
                        fontWeight = FontWeight.Bold,
                        fontSize = 20.sp
                    )
                )
            }
        },
        colors = TopAppBarDefaults.centerAlignedTopAppBarColors(
            containerColor = Color.Transparent
        )
    )
}
