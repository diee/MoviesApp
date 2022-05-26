package com.alarconsoft.moonshottrainning.data

import com.alarconsoft.moonshottrainning.domain.Movie

interface RemoteDataSource {

    suspend fun getPopularMovies(): List<Movie>
}