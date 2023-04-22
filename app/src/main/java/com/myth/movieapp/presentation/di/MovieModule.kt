package com.myth.movieapp.presentation.di

import com.myth.movieapp.domain.usecases.GetMoviesUseCase
import com.myth.movieapp.domain.usecases.UpdateMoviesUseCase
import com.myth.movieapp.presentation.ViewModelFactory
import dagger.Module
import dagger.Provides

@Module
class MovieModule {
    @MovieScope
    @Provides
    fun providesMovieViewModelFactory(
        getMoviesUseCase: GetMoviesUseCase,
        updateMoviesUseCase: UpdateMoviesUseCase
    ): ViewModelFactory {
        return ViewModelFactory(getMoviesUseCase, updateMoviesUseCase)
    }
}