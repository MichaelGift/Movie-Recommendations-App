package com.myth.movieapp.data.datasourceimplementation

import com.myth.movieapp.data.datasource.MovieLocalDataSource
import com.myth.movieapp.data.db.MovieDao
import com.myth.movieapp.data.model.Movie
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class MovieLocalDataSourceImplementation(
    private val movieDao: MovieDao
):MovieLocalDataSource {
    override suspend fun getMovieFromDB(): List<Movie> {
        return movieDao.getMovies()
    }

    override suspend fun saveMoviesToDB(movies: List<Movie>) {
        CoroutineScope(Dispatchers.IO).launch {
            movieDao.saveMovies(movies)
        }
    }

    override suspend fun clearAll(){
        CoroutineScope(Dispatchers.IO).launch {
            movieDao.deleteAllMovies()
        }
    }
}