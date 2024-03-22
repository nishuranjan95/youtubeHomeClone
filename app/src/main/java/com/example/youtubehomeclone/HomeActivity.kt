package com.example .youtubehomeclone

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.myapplication.viewmodels.MainViewModelFactory
import com.example.youtubehomeclone.MovieDetailsActivity
import com.example.youtubehomeclone.Network
import com.example.youtubehomeclone.R
import com.example.youtubehomeclone.adapter.MovieAdapter
import com.example.youtubehomeclone.api.MovieListService
import com.example.youtubehomeclone.api.RetrofitHelper
import com.example.youtubehomeclone.databinding.ActivityHomeBinding
import com.example.youtubehomeclone.interfaces.OnMovieItemClick
import com.example.youtubehomeclone.models.Result
import com.example.youtubehomeclone.repository.MovieRepository
import com.example.youtubehomeclone.viewmodels.MainViewModel

class HomeActivity : AppCompatActivity(), OnMovieItemClick {

    private var results: ArrayList<Result>?=null
    private lateinit var binding: ActivityHomeBinding
    private lateinit var mainViewModel: MainViewModel
    private lateinit var movieRepository: MovieRepository
    //private var mZoomSDK: ZoomSDK? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= DataBindingUtil.setContentView(this, R.layout.activity_home)
        //mZoomSDK = ZoomSDK.getInstance()
        binding.recyclerview.layoutManager = LinearLayoutManager(this)

        if (!Network.isConnected(applicationContext)) {
            Toast.makeText(applicationContext, "Please make sure you are connected to the internet", Toast.LENGTH_SHORT).show()

        } else {

            val movieListService = RetrofitHelper.getAuthInstance().create(MovieListService::class.java)
            movieRepository = MovieRepository(movieListService)
            mainViewModel = ViewModelProvider(
                this,
                MainViewModelFactory(movieRepository)
            )[MainViewModel::class.java]
            observerPopularMovie()
            observerTrendingMovie()

        }
        //initSDK()

    }

    private fun observerPopularMovie(){
        mainViewModel.popularMovieData.observe(this) { items ->
            results=items.results
            binding.recyclerview.adapter = MovieAdapter(results!!,this,this)
        }
    }

    /*fun initSDK() {
        if (!mZoomSDK!!.isInitialized) {
            val initParams = ZoomSDKInitParams()
            initParams.jwtToken = AuthConstants.SDK_JWTTOKEN
            initParams.enableLog = true
            initParams.enableGenerateDump = true
            initParams.logSize = 5
            initParams.domain = AuthConstants.WEB_DOMAIN
            initParams.videoRawDataMemoryMode =
                ZoomSDKRawDataMemoryMode.ZoomSDKRawDataMemoryModeStack
            mZoomSDK!!.initialize(this.applicationContext, this, initParams)
        }
    }*/

    private fun observerTrendingMovie(){
        mainViewModel.trendingMovieData.observe(this) {
             results?.get(0)?.type ="Short"
             results?.get(0)?.trendingsShort=it.results
             binding.recyclerview.adapter?.notifyDataSetChanged()
        }

    }

    override fun onClick(movie: Result) {
        val intent= Intent(applicationContext, MovieDetailsActivity::class.java)
        intent.putExtra("movie",movie.overview)
        startActivity(intent)
    }

}