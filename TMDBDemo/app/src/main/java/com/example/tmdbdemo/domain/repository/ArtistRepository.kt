package com.example.tmdbdemo.domain.repository

import com.example.tmdbdemo.data.model.artist.Artist

interface ArtistRepository {
    suspend fun getArtists(): List<Artist>?
    suspend fun updateArtists(): List<Artist>?
}