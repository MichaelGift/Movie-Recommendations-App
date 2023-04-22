package com.myth.movieapp.domain.repository

import com.myth.movieapp.data.model.Movie

interface MovieRepository {

    suspend fun getMovies():List<Movie>?
    suspend fun updateMovies():List<Movie>?
}