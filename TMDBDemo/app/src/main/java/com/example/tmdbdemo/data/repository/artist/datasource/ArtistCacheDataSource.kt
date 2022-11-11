package com.example.tmdbdemo.data.repository.artist.datasource

import com.example.tmdbdemo.data.model.artist.Artist

interface ArtistCacheDataSource {
    suspend fun getArtists(): List<Artist>
    suspend fun saveArtists(artists: List<Artist>)
}