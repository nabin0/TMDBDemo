package com.example.tmdbdemo.data.repository.tvshow.datasource

import com.example.tmdbdemo.data.model.tvshow.TvShow

interface TvShowLocalDataSource {
    suspend fun getTvShows(): List<TvShow>
    suspend fun saveTvShows(tvShowList: List<TvShow>)
    suspend fun deleteTvShows()
}