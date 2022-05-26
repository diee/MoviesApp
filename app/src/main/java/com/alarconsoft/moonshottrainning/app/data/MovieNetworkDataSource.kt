package com.alarconsoft.moonshottrainning.app.data

import com.alarconsoft.moonshottrainning.data.RemoteDataSource
import com.alarconsoft.moonshottrainning.domain.Movie

class MovieNetworkDataSource(private val api: MoviesApi) : RemoteDataSource {

    private val apiKey = "a63a4bd70daddb27d21f7dd323c9da39"

    override suspend fun getPopularMovies(): List<Movie> {
        return api.getPopularMovies(apiKey).results.map { it.toMovieDomain() }
    }
}

fun MovieBE.toMovieDomain(): Movie {
    return Movie(
        this.id,
        this.title,
        this.overview,
        this.popularity
    )
}