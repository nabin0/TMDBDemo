package com.example.tmdbdemo.domain.repository

import com.example.tmdbdemo.data.model.movie.Movie

interface MovieRepository {
    suspend fun getMovies(): List<Movie>?
    suspend fun updateMovies(): List<Movie>?
}