package com.example.tmdbdemo.data.repository.tvshow.datasourceimpl

import com.example.tmdbdemo.data.api.TMDBServices
import com.example.tmdbdemo.data.model.tvshow.TvShowList
import com.example.tmdbdemo.data.repository.tvshow.datasource.TvShowRemoteDataSource
import retrofit2.Response

class TvShowRemoteDataSourceImpl(
    private val tmdbServices: TMDBServices,
    private val apiKey: String
) : TvShowRemoteDataSource {
    override suspend fun getTvShows(): Response<TvShowList> {
        return tmdbServices.getPopularTvShows(apiKey)
    }
}