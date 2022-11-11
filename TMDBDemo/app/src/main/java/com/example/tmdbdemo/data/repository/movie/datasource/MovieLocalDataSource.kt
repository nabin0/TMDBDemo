package com.example.tmdbdemo.data.repository.movie.datasource

import com.example.tmdbdemo.data.model.movie.Movie

interface MovieLocalDataSource {
    suspend fun getMovies(): List<Movie>
    suspend fun saveMovies(list: List<Movie>)
    suspend fun deleteAllMovies()
}