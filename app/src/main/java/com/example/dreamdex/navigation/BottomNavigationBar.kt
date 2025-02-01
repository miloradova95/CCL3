package com.example.dreamdex.navigation

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Send
import androidx.compose.material.icons.filled.Star
import androidx.compose.material.icons.outlined.Favorite
import androidx.compose.material.icons.outlined.FavoriteBorder
import androidx.compose.material.icons.outlined.Home
import androidx.compose.material.icons.outlined.Search
import androidx.compose.material.icons.outlined.Send
import androidx.compose.material.icons.outlined.Star
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.compose.currentBackStackEntryAsState
import com.google.android.gms.maps.model.Circle

@Composable
fun BottomNavigationBar(navController: NavHostController) {
    val currentBackStackEntry = navController.currentBackStackEntryAsState()

    val iconColor = Color(0xFF00315D)

    LaunchedEffect(currentBackStackEntry.value?.destination?.route) {
    }

    BottomAppBar(
        modifier = Modifier
            .fillMaxWidth()
            .clip(RoundedCornerShape(topStart = 20.dp, topEnd = 20.dp))
            .background(color = Color.White.copy(0.5f), shape = RoundedCornerShape(20.dp))
            .border(0.5.dp, Color.White, shape = RoundedCornerShape(topStart = 20.dp, topEnd = 20.dp)),
        contentPadding = PaddingValues(0.dp),
    ) {
        Row(
            modifier = Modifier
                .fillMaxSize()
                .padding(5.dp),
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
                    .size(45.dp)
                    .clickable { navController.navigate("CharacterOfTheDayScreen") }
                    .padding(8.dp),
                tint = iconColor
            )

            // Browse Icon
            val isBrowseScreen = currentBackStackEntry.value?.destination?.route == "Home Screen"
            val browseIcon = if (isBrowseScreen) Icons.Filled.Send else Icons.Outlined.Send

            Icon(
                imageVector = browseIcon,
                contentDescription = "Browse",
                modifier = Modifier
                    .size(45.dp)
                    .clickable { navController.navigate("Home Screen") }
                    .padding(8.dp),
                tint = iconColor
            )

            // Favorites Icon
            val isFavoritesScreen = currentBackStackEntry.value?.destination?.route == "Favorites Screen"
            val favoriteIcon = if (isFavoritesScreen) Icons.Outlined.Favorite else Icons.Outlined.FavoriteBorder

            Icon(
                imageVector = favoriteIcon,
                contentDescription = "Favorites",
                modifier = Modifier
                    .size(45.dp)
                    .clickable { navController.navigate("Favorites Screen") }
                    .padding(8.dp),
                tint = iconColor
            )
        }
    }
}