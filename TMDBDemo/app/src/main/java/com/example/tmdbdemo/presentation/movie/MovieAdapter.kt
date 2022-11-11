package com.example.tmdbdemo.presentation.movie

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.tmdbdemo.R
import com.example.tmdbdemo.data.model.movie.Movie
import com.example.tmdbdemo.databinding.ListItemBinding

class MovieAdapter() : RecyclerView.Adapter<MovieViewHolder>() {
    private var movieList = ArrayList<Movie>();

    fun setMovieList(movies: List<Movie>) {
        movieList.clear()
        movieList = ArrayList(movies)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MovieViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val binding: ListItemBinding =
            DataBindingUtil.inflate(layoutInflater, R.layout.list_item, parent, false)
        return MovieViewHolder(binding)
    }

    override fun onBindViewHolder(holder: MovieViewHolder, position: Int) {
        holder.bind(movieList[position])
    }

    override fun getItemCount(): Int {
        return movieList.size
    }
}

class MovieViewHolder(private val itemBinding: ListItemBinding) :
    RecyclerView.ViewHolder(itemBinding.root) {

    fun bind(movie: Movie) {
        itemBinding.titleTextView.text = movie.title
        itemBinding.descriptionTextView.text = movie.overview
        val imagePath = "https://image.tmdb.org/t/p/w500" + movie.posterPath
        Glide.with(itemBinding.imageView.context).load(imagePath).into(itemBinding.imageView)
    }
}