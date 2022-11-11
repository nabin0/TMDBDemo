package com.example.tmdbdemo.data.repository.artist.datasourceimpl

import com.example.tmdbdemo.data.db.ArtistDao
import com.example.tmdbdemo.data.model.artist.Artist
import com.example.tmdbdemo.data.repository.artist.datasource.ArtistLocalDataSource
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class ArtistLocalDataSourceImpl(private val artistDao: ArtistDao) : ArtistLocalDataSource {
    override suspend fun getArtist(): List<Artist> {
        return artistDao.getAllArtists()
    }

    override suspend fun saveArtists(artists: List<Artist>) {
        CoroutineScope(Dispatchers.IO).launch {
            artistDao.saveArtists(artists)
        }
    }

    override suspend fun deleteAllArtists() {
        CoroutineScope(Dispatchers.IO).launch {
            artistDao.deleteAllArtists()
        }
    }
}