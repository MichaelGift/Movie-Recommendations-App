package com.myth.movieapp.data

import com.myth.movieapp.data.datasource.MovieCacheDataSource
import com.myth.movieapp.data.datasource.MovieLocalDataSource
import com.myth.movieapp.data.datasource.MovieRemoteDataSource
import com.myth.movieapp.data.model.Movie
import com.myth.movieapp.domain.repository.MovieRepository

class MovieRepositoryImplementation(
    private val movieRemoteDataSource: MovieRemoteDataSource,
    private val movieLocalDataSource: MovieLocalDataSource,
    private val movieCacheDataSource: MovieCacheDataSource

) : MovieRepository {
    override suspend fun getMovies(): List<Movie>? {
        return getMoviesFromCache()
    }

    override suspend fun updateMovies(): List<Movie>? {
        val newListOfMovies = getMoviesFromAPI()
        movieLocalDataSource.clearAll()
        movieLocalDataSource.saveMoviesToDB(newListOfMovies)
        movieCacheDataSource.saveMoviesToCache(newListOfMovies)

        return newListOfMovies
    }

    suspend fun getMoviesFromAPI(): List<Movie> {
        lateinit var movieList: List<Movie>
        try {
            val response = movieRemoteDataSource.getMovies()
            val body = response.body()
            if (body != null) {
                movieList = body.movies
            }
        } catch (_: java.lang.Exception) {

        }
        return movieList
    }

    suspend fun getMoviesFromROOM(): List<Movie> {
        lateinit var movieList: List<Movie>
        try {
            movieList = movieLocalDataSource.getMovieFromDB()
        } catch (_: Exception) {

        }

        if (movieList.isNotEmpty()) {
            return movieList
        } else {
            movieList = getMoviesFromAPI()
            movieLocalDataSource.saveMoviesToDB(movieList)
        }
        return movieList
    }

    private suspend fun getMoviesFromCache(): List<Movie>? {
        lateinit var movieList : List<Movie>

        try {
            movieList = movieCacheDataSource.getMoviesFromCache()
        }catch (_: Exception){

        }
        if(movieList.isNotEmpty()){
            return movieList
        }else{
            movieList = getMoviesFromROOM()
            movieCacheDataSource.saveMoviesToCache(movieList)

        }
        return movieList
    }

}