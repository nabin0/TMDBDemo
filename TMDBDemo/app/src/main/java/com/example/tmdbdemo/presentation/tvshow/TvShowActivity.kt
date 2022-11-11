package com.example.tmdbdemo.presentation.tvshow

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.tmdbdemo.R
import com.example.tmdbdemo.databinding.ActivityTvShowBinding
import com.example.tmdbdemo.presentation.di.Injector
import javax.inject.Inject

class TvShowActivity : AppCompatActivity() {
    @Inject
    lateinit var factory: TvShowViewModelFactory
    lateinit var viewModel: TvShowViewModel
    lateinit var binding: ActivityTvShowBinding
    lateinit var adapter: TvShowAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        supportActionBar?.title = "Popular TvShows"
        binding = DataBindingUtil.setContentView(this, R.layout.activity_tv_show)
        (application as Injector).createTvShowSubComponent().inject(this)
        viewModel = ViewModelProvider(this, factory).get(TvShowViewModel::class.java)

        initRecyclerView()
        setSwipeListener()
    }

    private fun initRecyclerView() {
        binding.tvRecyclerView.layoutManager = LinearLayoutManager(this)
        adapter = TvShowAdapter()
        binding.tvRecyclerView.adapter = adapter
        setTvShows()
    }

    private fun setSwipeListener() {
        binding.swipeRefreshLayout.setOnRefreshListener {
            updateTvShow()
            binding.swipeRefreshLayout.isRefreshing = false
        }
    }

    private fun setTvShows() {
        binding.tvProgressBar.visibility = View.VISIBLE
        val responseLiveData = viewModel.getTvShow()
        responseLiveData.observe(this) {
            if (it != null) {
                adapter.setTvShowList(it)
                adapter.notifyDataSetChanged()
            }
            binding.tvProgressBar.visibility = View.INVISIBLE
        }
    }

    private fun updateTvShow() {
        binding.tvProgressBar.visibility = View.VISIBLE
        val responseData = viewModel.updateTvShow()
        responseData.observe(this) {
            if (it != null) {
                adapter.setTvShowList(it)
                adapter.notifyDataSetChanged()
            }
            binding.tvProgressBar.visibility = View.INVISIBLE
        }
    }
}