package com.example.dreamdex.navigation

import androidx.compose.runtime.Composable
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.dreamdex.viewModel.CharacterViewModel

@Composable
fun Navigation() {
    val navController = rememberNavController()
    val characterViewModel = viewModel<CharacterViewModel>() // ViewModel instance

    NavHost(navController = navController, startDestination = "Banner screen") {
        composable("Banner screen") {
            BannerScreen(navController = navController)
        }

        composable("Browse screen") {
            BrowseScreen(navController = navController)
        }

        composable("Details screen/{id}",
            arguments = listOf(navArgument(name = "id") { type = NavType.IntType })
        ) { backStackEntry ->
            val id = backStackEntry.arguments?.getInt("id")
            id?.let { DetailsScreen(id = it) }
        }

        composable("DreamDex screen") {
            DreamDexScreen(navController = navController, characterViewModel = characterViewModel)
        }
    }
}
