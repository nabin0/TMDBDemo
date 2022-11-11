package com.example.tmdbdemo.presentation.di.movie

import com.example.tmdbdemo.presentation.artist.ArtistActivity
import com.example.tmdbdemo.presentation.movie.MovieActivity
import dagger.Subcomponent

@MovieScope
@Subcomponent(modules = [MovieModule::class])
interface MovieSubComponent {
    fun inject(movieActivity: MovieActivity)

    @Subcomponent.Factory
    interface Factory {
        fun create(): MovieSubComponent
    }
}