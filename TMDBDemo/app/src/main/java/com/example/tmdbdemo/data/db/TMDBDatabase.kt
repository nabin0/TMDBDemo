package com.example.tmdbdemo.data.db

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.tmdbdemo.data.model.artist.Artist
import com.example.tmdbdemo.data.model.movie.Movie
import com.example.tmdbdemo.data.model.tvshow.TvShow

@Database(entities = [Artist::class, Movie::class, TvShow::class], version = 1, exportSchema = false)
abstract class TMDBDatabase: RoomDatabase() {
    abstract fun movieDao(): MovieDao
    abstract fun tvDao(): TvShowDao
    abstract fun artistDao(): ArtistDao
}