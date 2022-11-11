package com.example.tmdbdemo.presentation.di.artist

import com.example.tmdbdemo.domain.usecase.GetArtistsUseCase
import com.example.tmdbdemo.domain.usecase.UpdateArtistsUseCase
import com.example.tmdbdemo.presentation.artist.ArtistViewModelFactory
import dagger.Module
import dagger.Provides

@Module
class ArtistModule {

    @ArtistScope
    @Provides
    fun provideArtistViewModelFactory(
        getArtistsUseCase: GetArtistsUseCase,
        updateArtistsUseCase: UpdateArtistsUseCase
    ): ArtistViewModelFactory {
        return ArtistViewModelFactory(getArtistsUseCase, updateArtistsUseCase)
    }

}