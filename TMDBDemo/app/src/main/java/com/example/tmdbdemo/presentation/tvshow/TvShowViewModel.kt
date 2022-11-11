package com.example.tmdbdemo.presentation.tvshow

import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import com.example.tmdbdemo.domain.usecase.GetArtistsUseCase
import com.example.tmdbdemo.domain.usecase.GetTvShowsUseCase
import com.example.tmdbdemo.domain.usecase.UpdateArtistsUseCase
import com.example.tmdbdemo.domain.usecase.UpdateTvShowsUseCase

class TvShowViewModel(
    private val getTvShowsUseCase: GetTvShowsUseCase,
    private val updateTvShowsUseCase: UpdateTvShowsUseCase
) : ViewModel() {
    fun getTvShow() = liveData {
        val tvShowList = getTvShowsUseCase.execute()
        emit(tvShowList)
    }

    fun updateTvShow() = liveData {
        val tvShowList = updateTvShowsUseCase.execute()
        emit(tvShowList)
    }
}