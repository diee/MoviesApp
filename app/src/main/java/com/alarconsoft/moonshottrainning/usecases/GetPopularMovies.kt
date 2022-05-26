package com.alarconsoft.moonshottrainning.usecases

import com.alarconsoft.moonshottrainning.data.MoviesRepository
import javax.inject.Inject

class GetPopularMovies @Inject constructor(private val repository: MoviesRepository) {

    suspend fun invoke() = repository.getPopularMovies()
}