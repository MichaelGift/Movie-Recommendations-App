package com.myth.movieapp.presentation.di

import com.myth.movieapp.data.MovieRepositoryImplementation
import com.myth.movieapp.data.datasource.MovieCacheDataSource
import com.myth.movieapp.data.datasource.MovieLocalDataSource
import com.myth.movieapp.data.datasource.MovieRemoteDataSource
import com.myth.movieapp.domain.repository.MovieRepository
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class RepositoryModule {
    @Singleton
    @Provides
    fun provideMovieRepository(
        movieRemoteDataSource: MovieRemoteDataSource,
        movieLocalDataSource: MovieLocalDataSource,
        movieCacheDataSource: MovieCacheDataSource
    ):MovieRepository{
        return MovieRepositoryImplementation(
            movieRemoteDataSource,movieLocalDataSource,movieCacheDataSource
        )
    }
}