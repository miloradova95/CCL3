package com.example.dreamdex.navigation

import androidx.compose.runtime.Composable
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.dreamdex.db.CharactersViewModel
import com.example.dreamdex.screens.DetailsScreen

@Composable
fun Navigation() {
    val navController = rememberNavController()
    val charactersViewModel = viewModel<CharactersViewModel>()
    NavHost(navController = navController, startDestination =  "Banner screen") {
        composable("Banner screen"){
            BannerScreen(navController = navController)
        }

        composable("Home screen"){
            HomeScreen(navController = navController, charactersViewModel = charactersViewModel)
        }

        composable("Details screen/{id}",
            arguments = listOf(
                navArgument(
                    name= "id"
                ) {
                    type = NavType.IntType
                }
            )
        ) {id ->
            id.arguments?.getInt("id")?.let { id1 ->
                DetailsScreen(id = id1)
            }

        }

        composable("CharacterOfTheDayScreen") {
            CharacterOfTheDayScreen(navController = navController)
        }

        composable("Favorites Screen") {
            FavoritesScreen(navController = navController, viewModel = charactersViewModel)
        }

    }
}

