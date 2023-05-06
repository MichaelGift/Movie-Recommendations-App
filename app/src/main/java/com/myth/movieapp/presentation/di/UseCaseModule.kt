package com.myth.movieapp.presentation.di

import com.myth.movieapp.domain.repository.MovieRepository
import com.myth.movieapp.domain.usecases.GetMoviesUseCase
import com.myth.movieapp.domain.usecases.UpdateMoviesUseCase
import dagger.Module
import dagger.Provides

@Module
class UseCaseModule {
    @Provides
    fun providesGetMovieUseCase(movieRepository: MovieRepository): GetMoviesUseCase {
        return GetMoviesUseCase(movieRepository)
    }

    @Provides
    fun providesUpdateMovieUseCase(movieRepository: MovieRepository): UpdateMoviesUseCase {
        return UpdateMoviesUseCase(movieRepository)
    }
}