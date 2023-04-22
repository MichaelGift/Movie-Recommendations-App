package com.myth.movieapp.presentation.di

import com.myth.movieapp.data.datasource.MovieCacheDataSource
import com.myth.movieapp.data.datasourceimplementation.MovieCacheDataSourceImplementation
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class CacheDataModule {
    @Singleton
    @Provides
    fun providesMovieCacheDataSource():MovieCacheDataSource{
        return MovieCacheDataSourceImplementation()
    }
}