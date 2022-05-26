package com.alarconsoft.moonshottrainning.data

import com.alarconsoft.moonshottrainning.domain.Movie

class MoviesRepository(
    private val remoteDataSource: RemoteDataSource
) {

    suspend fun getPopularMovies(): List<Movie> {
        return remoteDataSource.getPopularMovies()
    }
}