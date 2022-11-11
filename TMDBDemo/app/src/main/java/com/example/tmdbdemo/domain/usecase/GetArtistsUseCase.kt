package com.example.tmdbdemo.domain.usecase

import com.example.tmdbdemo.data.model.artist.Artist
import com.example.tmdbdemo.domain.repository.ArtistRepository

class GetArtistsUseCase(private val artistRepository: ArtistRepository) {
    suspend fun execute(): List<Artist>? = artistRepository.getArtists()
}