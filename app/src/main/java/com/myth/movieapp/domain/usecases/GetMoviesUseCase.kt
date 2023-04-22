package com.myth.movieapp.domain.usecases

import com.myth.movieapp.data.model.Movie
import com.myth.movieapp.domain.repository.MovieRepository

class GetMoviesUseCase(private var movieRepository: MovieRepository) {
    suspend fun execute():List<Movie>?= movieRepository.getMovies()
}