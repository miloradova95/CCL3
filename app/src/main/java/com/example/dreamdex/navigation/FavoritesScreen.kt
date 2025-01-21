package com.example.dreamdex.navigation

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import com.example.dreamdex.navigation.BottomNavigationBar
import com.example.dreamdex.navigation.TopBar
import androidx.navigation.compose.rememberNavController

@Composable
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
}
