package com.example.tmdbdemo.data.repository.movie.datasource

import com.example.tmdbdemo.data.model.movie.MovieList
import retrofit2.Response

interface MovieRemoteDataSource {
    suspend fun getMoviesFromServer(): Response<MovieList>
}