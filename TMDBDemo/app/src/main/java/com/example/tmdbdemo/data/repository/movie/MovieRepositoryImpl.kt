package com.example.tmdbdemo.data.repository.movie

import android.net.ConnectivityManager
import android.util.Log
import com.example.tmdbdemo.data.model.movie.Movie
import com.example.tmdbdemo.data.repository.movie.datasource.MovieCacheDataSource
import com.example.tmdbdemo.data.repository.movie.datasource.MovieLocalDataSource
import com.example.tmdbdemo.data.repository.movie.datasource.MovieRemoteDataSource
import com.example.tmdbdemo.domain.repository.MovieRepository

class MovieRepositoryImpl(
    private val movieRemoteDataSource: MovieRemoteDataSource,
    private val movieLocalDataSource: MovieLocalDataSource,
    private val movieCacheDataSource: MovieCacheDataSource
) : MovieRepository {
    override suspend fun getMovies(): List<Movie> {
        return getMoviesFromCache()
    }

    override suspend fun updateMovies(): List<Movie> {
        val newMovieList = getMoviesFromAPI()
        movieLocalDataSource.deleteAllMovies()
        movieLocalDataSource.saveMovies(newMovieList)
        movieCacheDataSource.saveMovies(newMovieList)
        return newMovieList
    }

    private suspend fun getMoviesFromAPI(): List<Movie> {
        lateinit var movieList: List<Movie>
        try {
            // TODO:: Check active internet connection
            val response = movieRemoteDataSource.getMoviesFromServer()
            val body = response.body()
            if (body?.movies != null) {
                movieList = body.movies
            }
        } catch (exception: java.lang.Exception) {
            Log.i("MyTag", exception.message.toString())
        }
        return movieList
    }

    private suspend fun getMoviesFromDB(): List<Movie> {
        lateinit var movieList: List<Movie>
        try {
            movieList = movieLocalDataSource.getMovies()
        } catch (exception: java.lang.Exception) {
            Log.i("MyTag", exception.message.toString())
        }
        if (movieList.isNotEmpty()) {
            return movieList
        } else {
            movieList = getMoviesFromAPI()
            movieLocalDataSource.saveMovies(movieList)
        }
        return movieList
    }

    private suspend fun getMoviesFromCache(): List<Movie> {
        lateinit var movieList: List<Movie>
        try {
            movieList = movieCacheDataSource.getMovies()
        } catch (exception: java.lang.Exception) {
            Log.i("MyTag", exception.message.toString())
        }
        if (movieList.isNotEmpty()) {
            return movieList
        } else {
            movieList = getMoviesFromDB()
            movieCacheDataSource.saveMovies(movieList)
        }
        return movieList
    }

}