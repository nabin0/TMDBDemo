package com.example.tmdbdemo.presentation.artist

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.tmdbdemo.R
import com.example.tmdbdemo.databinding.ActivityArtistBinding
import com.example.tmdbdemo.presentation.di.Injector
import javax.inject.Inject

class ArtistActivity : AppCompatActivity() {
    @Inject
    lateinit var factory: ArtistViewModelFactory
    private lateinit var viewModel: ArtistViewModel
    lateinit var binding: ActivityArtistBinding
    private lateinit var adapter: ArtistAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        supportActionBar?.title = "Popular Artists"
        binding = DataBindingUtil.setContentView(this, R.layout.activity_artist)
        (application as Injector).createArtistSubComponent().inject(this)

        viewModel = ViewModelProvider(this, factory)[ArtistViewModel::class.java]

        initRecyclerView()
        setSwipeListener()
    }

    private fun initRecyclerView() {
        binding.artistRecyclerView.layoutManager = LinearLayoutManager(this)
        adapter = ArtistAdapter()
        binding.artistRecyclerView.adapter = adapter
        setArtistList()
    }

    private fun setSwipeListener() {
        binding.swipeRefreshLayout.setOnRefreshListener {
            updateArtistList()
            binding.swipeRefreshLayout.isRefreshing = false
        }
    }

    private fun setArtistList() {
        binding.artistProgressBar.visibility = View.VISIBLE
        val responseData = viewModel.getArtists()
        responseData.observe(this) {
            if (it != null) {
                adapter.setArtistList(it)
                adapter.notifyDataSetChanged()
            }
            binding.artistProgressBar.visibility = View.INVISIBLE
        }
    }

    private fun updateArtistList() {
        binding.artistProgressBar.visibility = View.VISIBLE
        val responseData = viewModel.updateArtist()
        responseData.observe(this) {
            if (it != null) {
                adapter.setArtistList(it)
                adapter.notifyDataSetChanged()
            }
            binding.artistProgressBar.visibility = View.INVISIBLE
        }
    }
}