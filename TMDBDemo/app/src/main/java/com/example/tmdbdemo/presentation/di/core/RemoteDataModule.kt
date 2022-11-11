package com.example.tmdbdemo.presentation.di.core

import com.example.tmdbdemo.data.api.TMDBServices
import com.example.tmdbdemo.data.repository.artist.datasource.ArtistRemoteDataSource
import com.example.tmdbdemo.data.repository.artist.datasourceimpl.ArtistRemoteDataSourceImpl
import com.example.tmdbdemo.data.repository.movie.datasource.MovieRemoteDataSource
import com.example.tmdbdemo.data.repository.movie.datasourceimpl.MovieRemoteDataSourceImpl
import com.example.tmdbdemo.data.repository.tvshow.datasource.TvShowRemoteDataSource
import com.example.tmdbdemo.data.repository.tvshow.datasourceimpl.TvShowRemoteDataSourceImpl
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class RemoteDataModule(private val apiKey: String) {

    @Singleton
    @Provides
    fun provideMovieRemoteDataSource(tmdbService: TMDBServices): MovieRemoteDataSource {
        return MovieRemoteDataSourceImpl(tmdbService, apiKey)
    }
    @Singleton
    @Provides
    fun provideTvShowsRemoteDataSource(tmdbService: TMDBServices): TvShowRemoteDataSource {
        return TvShowRemoteDataSourceImpl(tmdbService, apiKey)
    }
    @Singleton
    @Provides
    fun provideArtistRemoteDataSource(tmdbService: TMDBServices): ArtistRemoteDataSource {
        return ArtistRemoteDataSourceImpl(tmdbService, apiKey)
    }
}