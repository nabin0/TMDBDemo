package com.example.tmdbdemo.data.repository.artist.datasourceimpl

import com.example.tmdbdemo.data.model.artist.Artist
import com.example.tmdbdemo.data.repository.artist.datasource.ArtistCacheDataSource

class ArtistCacheDataSourceImpl : ArtistCacheDataSource {
    private var artistList = ArrayList<Artist>()
    override suspend fun getArtists(): List<Artist> {
        return artistList
    }

    override suspend fun saveArtists(artists: List<Artist>) {
        artistList.clear()
        artistList = ArrayList(artists)
    }
}