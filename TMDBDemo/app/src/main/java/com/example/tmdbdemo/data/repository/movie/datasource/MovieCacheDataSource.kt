package com.example.tmdbdemo.data.repository.movie.datasource

import com.example.tmdbdemo.data.model.movie.Movie
import com.example.tmdbdemo.data.model.movie.MovieList

interface MovieCacheDataSource {
    suspend fun getMovies(): List<Movie>
    suspend fun saveMovies(movies: List<Movie>)
}