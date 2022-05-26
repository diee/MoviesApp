package com.alarconsoft.moonshottrainning.app.data

data class MovieResult(
    val results: List<MovieBE>
)

data class MovieBE(
    val id: Int,
    val title: String,
    val overview: String,
    val popularity: Double
)
