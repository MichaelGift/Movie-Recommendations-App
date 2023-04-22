package com.myth.movieapp.domain.usecases

import com.myth.movieapp.data.model.Movie
import com.myth.movieapp.domain.repository.MovieRepository

class UpdateMoviesUseCase(private var movieRepository: MovieRepository) {
    suspend fun execute(): List<Movie>? = movieRepository.updateMovies()

}