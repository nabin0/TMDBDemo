package com.example.tmdbdemo.data.repository.movie.datasourceimpl

import com.example.tmdbdemo.data.api.TMDBServices
import com.example.tmdbdemo.data.model.movie.MovieList
import com.example.tmdbdemo.data.repository.movie.datasource.MovieRemoteDataSource
import retrofit2.Response

class MovieRemoteDataSourceImpl(
    private val tmdbServices: TMDBServices,
    private val apiKey: String
) : MovieRemoteDataSource {
    override suspend fun getMoviesFromServer(): Response<MovieList> =
        tmdbServices.getPopularMovies(apiKey)
}