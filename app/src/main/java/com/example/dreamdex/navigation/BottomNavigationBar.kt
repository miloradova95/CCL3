package com.example.dreamdex.navigation

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.outlined.Favorite
import androidx.compose.material.icons.outlined.FavoriteBorder
import androidx.compose.material.icons.outlined.Home
import androidx.compose.material.icons.outlined.Star
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.compose.currentBackStackEntryAsState

@Composable
fun BottomNavigationBar(navController: NavHostController) {
    // Get the current route from the NavHostController to determine if we're on the Favorites screen
    val currentBackStackEntry = navController.currentBackStackEntryAsState()

    val iconColor = Color(0xFF00315D)

    BottomAppBar(
        modifier = Modifier
            .fillMaxWidth()
            .background(Color.White),
        contentPadding = PaddingValues(0.dp),
    ) {
        Row(
            modifier = Modifier
                .fillMaxSize()
                .padding(8.dp),
            horizontalArrangement = Arrangement.SpaceAround,
            verticalAlignment = Alignment.CenterVertically
        ) {
            // Home Icon
            val isHomeScreen = currentBackStackEntry.value?.destination?.route == "CharacterOfTheDayScreen"
            val homeIcon = if (isHomeScreen) Icons.Filled.Home else Icons.Outlined.Home

            Icon(
                imageVector = homeIcon,
                contentDescription = "Home",
                modifier = Modifier
                    .size(50.dp)
                    .clickable { navController.navigate("CharacterOfTheDayScreen") }
                    .padding(8.dp),
                tint = iconColor
            )

            // Globe Icon
            Icon(
                imageVector = Icons.Outlined.Star,
                contentDescription = "Explore",
                modifier = Modifier
                    .size(50.dp)
                    .clickable { navController.navigate("Home Screen") }
                    .padding(8.dp),
                tint = iconColor
            )

            // Heart Icon for Favorites
            val isFavoritesScreen = currentBackStackEntry.value?.destination?.route == "Favorites Screen"
            val favoriteIcon = if (isFavoritesScreen) Icons.Outlined.Favorite else Icons.Outlined.FavoriteBorder

            Icon(
                imageVector = favoriteIcon,
                contentDescription = "Favorites",
                modifier = Modifier
                    .size(50.dp)
                    .clickable { navController.navigate("Favorites Screen") }
                    .padding(8.dp),
                tint = iconColor
            )
        }
    }
}
