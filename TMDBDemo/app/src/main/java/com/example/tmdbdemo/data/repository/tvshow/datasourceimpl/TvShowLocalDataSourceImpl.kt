package com.example.tmdbdemo.data.repository.tvshow.datasourceimpl

import com.example.tmdbdemo.data.db.TvShowDao
import com.example.tmdbdemo.data.model.tvshow.TvShow
import com.example.tmdbdemo.data.repository.tvshow.datasource.TvShowLocalDataSource

class TvShowLocalDataSourceImpl(
    private val tvShowDao: TvShowDao
) : TvShowLocalDataSource {
    override suspend fun getTvShows(): List<TvShow> {
        return tvShowDao.getAllTvShows()
    }

    override suspend fun saveTvShows(tvShowList: List<TvShow>) {
        tvShowDao.saveTvShows(tvShowList)
    }

    override suspend fun deleteTvShows() {
        tvShowDao.deleteAllTvShows()
    }
}