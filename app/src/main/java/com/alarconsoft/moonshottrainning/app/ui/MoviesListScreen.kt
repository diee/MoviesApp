package com.alarconsoft.moonshottrainning.app.ui

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Button
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController

@Composable
fun MoviesListScreen(
    navController: NavHostController,
    viewModel: MoviesListViewModel = hiltViewModel()
) {

    /* 
     Column() {
         Text(text = "List")
         Button(onClick = {
             navController.navigate(MoviesScreens.MovieDetailsScreen.name)
         }) {
             Text(text = "Navigate")
         }
     }*/

    val state = viewModel.state.collectAsState().value

    when (state) {
        MovieScreenState.Loading -> CircularProgressIndicator()
        is MovieScreenState.ShowMovieList -> {
            LazyColumn {
                items(state.movies) {
                    Text(text = it.title)
                }
            }
        }
    }

}