package com.example.tmdbdemo.presentation.di.tvshow

import com.example.tmdbdemo.domain.usecase.GetArtistsUseCase
import com.example.tmdbdemo.domain.usecase.GetTvShowsUseCase
import com.example.tmdbdemo.domain.usecase.UpdateArtistsUseCase
import com.example.tmdbdemo.domain.usecase.UpdateTvShowsUseCase
import com.example.tmdbdemo.presentation.artist.ArtistViewModelFactory
import com.example.tmdbdemo.presentation.tvshow.TvShowViewModelFactory
import dagger.Module
import dagger.Provides

@Module
class TvShowModule {

    @TvShowScope
    @Provides
    fun provideTvShowViewModelFactory(
        getTvShowsUseCase: GetTvShowsUseCase,
        updateTvShowsUseCase: UpdateTvShowsUseCase
    ): TvShowViewModelFactory {
        return TvShowViewModelFactory(getTvShowsUseCase, updateTvShowsUseCase)
    }

}