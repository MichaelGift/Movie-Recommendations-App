package com.myth.movieapp.data.api

import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query
import com.myth.movieapp.data.*
import com.myth.movieapp.data.model.MovieList

interface TMDBService {
    @GET("movie/popular")
    suspend fun getPopularMovies(@Query("api_key")apiKey:String):Response<MovieList>

    @GET("tv/popular")
    suspend fun getPopularTvShows(@Query("api_key")apiKey: String):Response<MovieList>
}