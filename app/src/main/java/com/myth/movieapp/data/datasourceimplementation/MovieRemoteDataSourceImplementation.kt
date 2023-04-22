package com.myth.movieapp.data.datasourceimplementation

import com.myth.movieapp.data.api.TMDBService
import com.myth.movieapp.data.datasource.MovieRemoteDataSource
import com.myth.movieapp.data.model.MovieList
import retrofit2.Response

class MovieRemoteDataSourceImplementation(
    private val tmdbService: TMDBService,
    private val apikey:String
): MovieRemoteDataSource {
    override suspend fun getMovies(): Response<MovieList> = tmdbService.getPopularMovies(apikey)
}