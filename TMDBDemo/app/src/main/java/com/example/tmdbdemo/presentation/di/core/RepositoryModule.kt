package com.example.tmdbdemo.presentation.di.core

import com.example.tmdbdemo.data.repository.artist.ArtistRepositoryImpl
import com.example.tmdbdemo.data.repository.artist.datasource.ArtistCacheDataSource
import com.example.tmdbdemo.data.repository.artist.datasource.ArtistLocalDataSource
import com.example.tmdbdemo.data.repository.artist.datasource.ArtistRemoteDataSource
import com.example.tmdbdemo.data.repository.movie.MovieRepositoryImpl
import com.example.tmdbdemo.data.repository.movie.datasource.MovieCacheDataSource
import com.example.tmdbdemo.data.repository.movie.datasource.MovieLocalDataSource
import com.example.tmdbdemo.data.repository.movie.datasource.MovieRemoteDataSource
import com.example.tmdbdemo.data.repository.tvshow.TvShowRepositoryImpl
import com.example.tmdbdemo.data.repository.tvshow.datasource.TvShowCacheDataSource
import com.example.tmdbdemo.data.repository.tvshow.datasource.TvShowLocalDataSource
import com.example.tmdbdemo.data.repository.tvshow.datasource.TvShowRemoteDataSource
import com.example.tmdbdemo.domain.repository.ArtistRepository
import com.example.tmdbdemo.domain.repository.MovieRepository
import com.example.tmdbdemo.domain.repository.TvShowRepository
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class RepositoryModule {

    @Singleton
    @Provides
    fun providesMovieRepository(
        movieRemoteDataSource: MovieRemoteDataSource,
        movieLocalDataSource: MovieLocalDataSource,
        movieCacheDataSource: MovieCacheDataSource
    ): MovieRepository {
        return MovieRepositoryImpl(
            movieRemoteDataSource,
            movieLocalDataSource,
            movieCacheDataSource
        )
    }

    @Singleton
    @Provides
    fun providesTvShowRepository(
        tvShowRemoteDataSource: TvShowRemoteDataSource,
        tvShowLocalDataSource: TvShowLocalDataSource,
        tvShowCacheDataSource: TvShowCacheDataSource
    ): TvShowRepository {
        return TvShowRepositoryImpl(
            tvShowRemoteDataSource,
            tvShowLocalDataSource,
            tvShowCacheDataSource
        )
    }

    @Singleton
    @Provides
    fun providesArtistRepository(
        artistRemoteDataSource: ArtistRemoteDataSource,
        artistLocalDataSource: ArtistLocalDataSource,
        artistCacheDataSource: ArtistCacheDataSource
    ): ArtistRepository {
        return ArtistRepositoryImpl(
            artistRemoteDataSource,
            artistLocalDataSource,
            artistCacheDataSource
        )
    }

}