package com.myth.movieapp.presentation.di

interface Injector {
    fun createMovieSubComponent():MovieSubComponent
}