package com.example.tmdbdemo.presentation

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.View.OnClickListener
import androidx.databinding.DataBindingUtil
import com.example.tmdbdemo.R
import com.example.tmdbdemo.data.repository.movie.datasource.MovieCacheDataSource
import com.example.tmdbdemo.databinding.ActivityHomeBinding
import com.example.tmdbdemo.presentation.artist.ArtistActivity
import com.example.tmdbdemo.presentation.movie.MovieActivity
import com.example.tmdbdemo.presentation.tvshow.TvShowActivity

class HomeActivity : AppCompatActivity(), OnClickListener {
    lateinit var binding: ActivityHomeBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_home)

        binding.buttonMovies.setOnClickListener(this)
        binding.buttonArtists.setOnClickListener(this)
        binding.buttonTvshows.setOnClickListener(this)
    }

    override fun onClick(p0: View?) {
        val id = p0?.id
        if (id == R.id.button_artists) {
            val intent = Intent(this, ArtistActivity::class.java)
            startActivity(intent)
        } else if (id == R.id.button_movies) {
            val intent = Intent(this, MovieActivity::class.java)
            startActivity(intent)
        } else {
            val intent = Intent(this, TvShowActivity::class.java)
            startActivity(intent)
        }
    }
}