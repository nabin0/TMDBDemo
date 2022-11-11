package com.example.tmdbdemo.data.repository.artist.datasource

import com.example.tmdbdemo.data.model.artist.Artist

interface ArtistLocalDataSource {
    suspend fun getArtist(): List<Artist>
    suspend fun saveArtists(artists: List<Artist>)
    suspend fun deleteAllArtists()
}