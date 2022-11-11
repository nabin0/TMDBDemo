package com.example.tmdbdemo.data.repository.tvshow.datasourceimpl

import com.example.tmdbdemo.data.model.tvshow.TvShow
import com.example.tmdbdemo.data.repository.tvshow.datasource.TvShowCacheDataSource

class TvShowCacheDataSourceImpl : TvShowCacheDataSource {
    private var tvShowList = ArrayList<TvShow>()
    override suspend fun getTvShows(): List<TvShow> {
        return tvShowList
    }

    override suspend fun saveTvShows(tvShows: List<TvShow>) {
        tvShowList.clear()
        tvShowList = ArrayList(tvShows)
    }
}