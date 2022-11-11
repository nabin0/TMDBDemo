package com.example.tmdbdemo.presentation.di.tvshow

import com.example.tmdbdemo.presentation.artist.ArtistActivity
import com.example.tmdbdemo.presentation.tvshow.TvShowActivity
import dagger.Subcomponent

@TvShowScope
@Subcomponent(modules = [TvShowModule::class])
interface TvShowSubComponent {
    fun inject(tvShowActivity: TvShowActivity)

    @Subcomponent.Factory
    interface Factory {
        fun create(): TvShowSubComponent
    }
}