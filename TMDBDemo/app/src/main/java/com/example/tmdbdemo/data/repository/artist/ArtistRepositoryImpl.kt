package com.example.tmdbdemo.data.repository.artist

import android.util.Log
import com.example.tmdbdemo.data.model.artist.Artist
import com.example.tmdbdemo.data.repository.artist.datasource.ArtistCacheDataSource
import com.example.tmdbdemo.data.repository.artist.datasource.ArtistLocalDataSource
import com.example.tmdbdemo.data.repository.artist.datasource.ArtistRemoteDataSource
import com.example.tmdbdemo.domain.repository.ArtistRepository

class ArtistRepositoryImpl(
    private val artistRemoteDataSource: ArtistRemoteDataSource,
    private val artistLocalDataSource: ArtistLocalDataSource,
    private val artistCacheDataSource: ArtistCacheDataSource
) : ArtistRepository {
    override suspend fun getArtists(): List<Artist>? {
        return getArtistFromCache()
    }

    override suspend fun updateArtists(): List<Artist>? {
        val newArtistList = getArtistFromAPI()
        artistLocalDataSource.deleteAllArtists()
        artistLocalDataSource.saveArtists(newArtistList)
        artistCacheDataSource.saveArtists(newArtistList)
        return newArtistList
    }

    suspend fun getArtistFromAPI(): List<Artist> {
        lateinit var artistList: List<Artist>
        try {
            val response = artistRemoteDataSource.getArtists()
            val body = response.body()
            if (body?.artists != null) artistList = body.artists
        } catch (exception: Exception) {
            Log.i("MyTag", exception.message.toString())
        }
        return artistList
    }

    suspend fun getArtistFromDB(): List<Artist> {
        lateinit var artistList: List<Artist>
        try {
            artistList = artistLocalDataSource.getArtist()
        } catch (exception: Exception) {
            Log.i("MyTag", exception.message.toString())
        }
        if (artistList.isNotEmpty()) {
            return artistList
        } else {
            artistList = getArtistFromAPI()
            artistLocalDataSource.saveArtists(artistList)
        }
        return artistList
    }

    suspend fun getArtistFromCache(): List<Artist> {
        lateinit var artistList: List<Artist>
        try {
            artistList = artistCacheDataSource.getArtists()
        } catch (exception: Exception) {
            Log.i("MyTag", exception.message.toString())
        }
        if (artistList.isNotEmpty()) {
            return artistList
        } else {
            artistList = getArtistFromDB()
            artistCacheDataSource.saveArtists(artistList)
        }
        return artistList
    }
}