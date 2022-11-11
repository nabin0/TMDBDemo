package com.example.tmdbdemo.presentation.artist

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.tmdbdemo.R
import com.example.tmdbdemo.data.model.artist.Artist
import com.example.tmdbdemo.databinding.ListItemBinding

class ArtistAdapter() : RecyclerView.Adapter<ArtistViewHolder>() {

    private var artistList = ArrayList<Artist>();

    fun setArtistList(artists: List<Artist>) {
        artistList.clear()
        artistList = ArrayList(artists)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ArtistViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val binding: ListItemBinding = DataBindingUtil.inflate(
            layoutInflater, R.layout.list_item, parent, false
        )
        return ArtistViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ArtistViewHolder, position: Int) {
        holder.bind(artistList[position])
    }

    override fun getItemCount(): Int {
        return artistList.size
    }
}

class ArtistViewHolder(private val binding: ListItemBinding) :
    RecyclerView.ViewHolder(binding.root) {
    fun bind(artist: Artist) {
        binding.titleTextView.text = artist.name
        val imagePath = "https://image.tmdb.org/t/p/w500" + artist.profilePath
        Glide.with(binding.imageView.context).load(imagePath).into(binding.imageView)
    }
}