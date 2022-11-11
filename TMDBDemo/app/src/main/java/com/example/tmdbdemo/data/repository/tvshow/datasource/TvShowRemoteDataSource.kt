package com.example.tmdbdemo.data.repository.tvshow.datasource

import com.example.tmdbdemo.data.model.tvshow.TvShowList
import retrofit2.Response

interface TvShowRemoteDataSource {
    suspend fun getTvShows(): Response<TvShowList>
}