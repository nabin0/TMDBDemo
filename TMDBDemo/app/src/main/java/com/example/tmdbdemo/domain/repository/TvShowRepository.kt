package com.example.tmdbdemo.domain.repository

import com.example.tmdbdemo.data.model.tvshow.TvShow

interface TvShowRepository {
    suspend fun getTvShows(): List<TvShow>?
    suspend fun updateTvShows(): List<TvShow>?
}