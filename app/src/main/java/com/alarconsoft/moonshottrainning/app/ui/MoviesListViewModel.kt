package com.alarconsoft.moonshottrainning.app.ui

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.alarconsoft.moonshottrainning.domain.Movie
import com.alarconsoft.moonshottrainning.usecases.GetPopularMovies
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MoviesListViewModel @Inject constructor(
    getPopularMovies: GetPopularMovies
) : ViewModel() {

    private val _state: MutableStateFlow<MovieScreenState> =
        MutableStateFlow(MovieScreenState.Loading)
    val state = _state.asStateFlow()

    init {
        viewModelScope.launch {

            val result = getPopularMovies.invoke()

            _state.value = MovieScreenState.ShowMovieList(result)

            Log.d("MoviesListViewModel", result.get(2).title)
        }
    }
}

sealed class MovieScreenState {
    object Loading : MovieScreenState()
    data class ShowMovieList(val movies: List<Movie>) : MovieScreenState()
}