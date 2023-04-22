package com.myth.movieapp.data.datasource

import com.myth.movieapp.data.model.Movie

interface MovieLocalDataSource {
    suspend fun getMovieFromDB(): List<Movie>

    suspend fun saveMoviesToDB(movies: List<Movie>)
    suspend fun clearAll()
}