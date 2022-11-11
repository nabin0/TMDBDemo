package com.example.tmdbdemo.presentation.movie

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.tmdbdemo.R
import com.example.tmdbdemo.databinding.ActivityMovieBinding
import com.example.tmdbdemo.presentation.di.Injector
import javax.inject.Inject

class MovieActivity : AppCompatActivity() {
    @Inject
    lateinit var factory: MovieViewModelFactory
    private lateinit var movieViewModel: MovieViewModel
    lateinit var binding: ActivityMovieBinding
    private lateinit var adapter: MovieAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        supportActionBar?.title = "Popular Movies"
        binding = DataBindingUtil.setContentView(this, R.layout.activity_movie)

        (application as Injector).createMovieSubComponent().inject(this)

        movieViewModel = ViewModelProvider(this, factory)[MovieViewModel::class.java]

        initRecyclerView()
        setSwipeDownUpdateListener()
    }

    private fun setSwipeDownUpdateListener() {
        binding.swipeRefreshLayout.setOnRefreshListener {
            binding.swipeRefreshLayout.isRefreshing = false
            updateMovies()
        }
    }

    private fun initRecyclerView() {
        binding.movieRecyclerView.layoutManager = LinearLayoutManager(this)
        adapter = MovieAdapter()
        binding.movieRecyclerView.adapter = adapter
        listMovies()
    }

    private fun listMovies() {
        binding.movieProgressBar.visibility = View.VISIBLE
        val responsiveLiveData = movieViewModel.getMovies()
        responsiveLiveData.observe(this, Observer {
            if (it != null) {
                adapter.setMovieList(it)
                adapter.notifyDataSetChanged()
                binding.movieProgressBar.visibility = View.INVISIBLE
                Log.i("MyTag", it.toString())
            } else {
                binding.movieProgressBar.visibility = View.INVISIBLE
                Toast.makeText(this, "No Movies Found.", Toast.LENGTH_SHORT).show()
            }
        })
    }

    private fun updateMovies() {
        binding.movieProgressBar.visibility = View.VISIBLE
        val response = movieViewModel.updateMovies()
        response.observe(this) {
            if (it != null) {
                adapter.setMovieList(it)
                adapter.notifyDataSetChanged()
                binding.movieProgressBar.visibility = View.INVISIBLE
            } else {
                binding.movieProgressBar.visibility = View.INVISIBLE
                Toast.makeText(this, "No Movies Found.", Toast.LENGTH_SHORT).show()
            }

        }
    }

}