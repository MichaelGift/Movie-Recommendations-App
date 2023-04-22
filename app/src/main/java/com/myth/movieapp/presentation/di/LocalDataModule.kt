package com.myth.movieapp.presentation.di

import com.myth.movieapp.data.datasource.MovieLocalDataSource
import com.myth.movieapp.data.datasourceimplementation.MovieLocalDataSourceImplementation
import com.myth.movieapp.data.db.MovieDao
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class LocalDataModule {
    @Singleton
    @Provides
    fun provideMovieLocalDataSource(movieDao: MovieDao):MovieLocalDataSource{
        return MovieLocalDataSourceImplementation(movieDao)
    }
}