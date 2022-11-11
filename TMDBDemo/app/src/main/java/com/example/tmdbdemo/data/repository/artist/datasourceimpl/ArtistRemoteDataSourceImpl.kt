package com.example.tmdbdemo.data.repository.artist.datasourceimpl

import com.example.tmdbdemo.data.api.TMDBServices
import com.example.tmdbdemo.data.model.artist.ArtistList
import com.example.tmdbdemo.data.repository.artist.datasource.ArtistRemoteDataSource
import retrofit2.Response

class ArtistRemoteDataSourceImpl(
    private val tmdbServices: TMDBServices,
    private val apiKey: String
) : ArtistRemoteDataSource {
    override suspend fun getArtists(): Response<ArtistList> {
        return tmdbServices.getPopularArtists(apiKey)
    }
}