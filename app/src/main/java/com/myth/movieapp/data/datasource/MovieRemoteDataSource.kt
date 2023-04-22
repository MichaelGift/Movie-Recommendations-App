package com.myth.movieapp.data.datasource

import com.myth.movieapp.data.model.MovieList
import retrofit2.Response


interface MovieRemoteDataSource {
    suspend fun getMovies():Response<MovieList>
}