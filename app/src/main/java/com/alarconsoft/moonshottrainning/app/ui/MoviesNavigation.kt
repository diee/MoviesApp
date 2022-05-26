package com.alarconsoft.moonshottrainning.app.ui

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController

@Composable
fun MoviesNavigation() {

    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = MoviesScreens.MoviesListScreen.name) {
        composable(MoviesScreens.MoviesListScreen.name) {
            MoviesListScreen(navController)
        }

        composable(MoviesScreens.MovieDetailsScreen.name) {
            MovieDetailsScreen()
        }
    }
}