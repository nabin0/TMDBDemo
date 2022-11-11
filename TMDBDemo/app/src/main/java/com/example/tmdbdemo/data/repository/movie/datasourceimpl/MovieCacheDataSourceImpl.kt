package com.example.tmdbdemo.data.repository.movie.datasourceimpl

import com.example.tmdbdemo.data.model.movie.Movie
import com.example.tmdbdemo.data.repository.movie.datasource.MovieCacheDataSource

class MovieCacheDataSourceImpl : MovieCacheDataSource {
    private var moviesList = ArrayList<Movie>()
    override suspend fun getMovies(): List<Movie> {
        return moviesList
    }

    override suspend fun saveMovies(movies: List<Movie>) {
        moviesList.clear()
        moviesList = ArrayList(movies)
    }
}