package com.example.tmdbdemo.presentation.di.movie

import com.example.tmdbdemo.domain.usecase.GetArtistsUseCase
import com.example.tmdbdemo.domain.usecase.GetMoviesUseCase
import com.example.tmdbdemo.domain.usecase.UpdateArtistsUseCase
import com.example.tmdbdemo.domain.usecase.UpdateMoviesUseCase
import com.example.tmdbdemo.presentation.artist.ArtistViewModelFactory
import com.example.tmdbdemo.presentation.movie.MovieViewModelFactory
import dagger.Module
import dagger.Provides

@Module
class MovieModule {

    @MovieScope
    @Provides
    fun provideMovieViewModelFactory(
        getMoviesUseCase: GetMoviesUseCase,
        updateMoviesUseCase: UpdateMoviesUseCase
    ): MovieViewModelFactory {
        return MovieViewModelFactory(getMoviesUseCase, updateMoviesUseCase)
    }

}