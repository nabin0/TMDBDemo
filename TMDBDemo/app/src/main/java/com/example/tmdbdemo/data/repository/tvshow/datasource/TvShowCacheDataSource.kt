package com.example.tmdbdemo.data.repository.tvshow.datasource

import com.example.tmdbdemo.data.model.tvshow.TvShow

interface TvShowCacheDataSource {
    suspend fun getTvShows(): List<TvShow>
    suspend fun saveTvShows(tvShows: List<TvShow>)
}