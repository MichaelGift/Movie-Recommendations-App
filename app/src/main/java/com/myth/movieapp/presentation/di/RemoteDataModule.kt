package com.myth.movieapp.presentation.di

import com.myth.movieapp.data.api.TMDBService
import com.myth.movieapp.data.datasource.MovieRemoteDataSource
import com.myth.movieapp.data.datasourceimplementation.MovieRemoteDataSourceImplementation
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class RemoteDataModule(private val apikey:String) {

    @Singleton
    @Provides
    fun providesMovieRemoteDataSource(tmdbService: TMDBService):MovieRemoteDataSource{
        return MovieRemoteDataSourceImplementation(
            tmdbService,
            apikey
        )
    }
}