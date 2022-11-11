package com.example.tmdbdemo.domain.usecase

import com.example.tmdbdemo.data.model.tvshow.TvShow
import com.example.tmdbdemo.domain.repository.TvShowRepository

class UpdateTvShowsUseCase(private val tvShowRepository: TvShowRepository) {
    suspend fun execute(): List<TvShow>? = tvShowRepository.updateTvShows()
}