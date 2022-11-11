package com.example.tmdbdemo.domain.usecase

import com.example.tmdbdemo.data.model.movie.Movie
import com.example.tmdbdemo.domain.repository.MovieRepository

class GetMoviesUseCase(private val movieRepository: MovieRepository) {
    suspend fun execute(): List<Movie>? = movieRepository.getMovies()
}