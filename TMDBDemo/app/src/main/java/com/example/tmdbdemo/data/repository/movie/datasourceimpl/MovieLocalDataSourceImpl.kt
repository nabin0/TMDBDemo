package com.example.tmdbdemo.data.repository.movie.datasourceimpl

import com.example.tmdbdemo.data.db.MovieDao
import com.example.tmdbdemo.data.model.movie.Movie
import com.example.tmdbdemo.data.repository.movie.datasource.MovieLocalDataSource
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class MovieLocalDataSourceImpl(private val movieDao: MovieDao) : MovieLocalDataSource {
    override suspend fun getMovies(): List<Movie> {
        return movieDao.getAllMovies()
    }

    override suspend fun saveMovies(list: List<Movie>) {
        CoroutineScope(Dispatchers.IO).launch {
            movieDao.saveMovies(list)
        }
    }

    override suspend fun deleteAllMovies() {
        CoroutineScope(Dispatchers.IO).launch {
            movieDao.deleteAllMovies()
        }
    }
}