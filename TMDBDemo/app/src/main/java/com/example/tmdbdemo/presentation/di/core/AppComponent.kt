package com.example.tmdbdemo.presentation.di.core

import com.example.tmdbdemo.presentation.di.artist.ArtistSubComponent
import com.example.tmdbdemo.presentation.di.movie.MovieSubComponent
import com.example.tmdbdemo.presentation.di.tvshow.TvShowSubComponent
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(
    modules = [AppModule::class,
        CacheDataModule::class,
        DataBaseModule::class,
        LocalDataModule::class,
        NETModule::class,
        RemoteDataModule::class,
        RepositoryModule::class,
        UseCaseModule::class]
)
interface AppComponent {
    fun movieSubComponent(): MovieSubComponent.Factory
    fun tvSubComponent(): TvShowSubComponent.Factory
    fun artistSubComponent(): ArtistSubComponent.Factory
}