package com.example.youtubehomeclone.repository

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.youtubehomeclone.api.MovieListService
import com.example.youtubehomeclone.models.PopularMovie
import com.example.youtubehomeclone.models.TrendingMovie

class MovieRepository(private var movieListService: MovieListService){
      private val popularMutableLiveData=MutableLiveData<PopularMovie>()
      private val trendingMutableLiveData=MutableLiveData<TrendingMovie>()

    val popularMovieLiveData:LiveData<PopularMovie>
    get()=popularMutableLiveData

    val trendingMovieLiveData:LiveData<TrendingMovie>
    get()=trendingMutableLiveData

    suspend fun getPopularMovie(){
        val result=movieListService.popularMovieList()
        if(result.body() !=null){
            popularMutableLiveData.postValue(result.body())
        }
    }

    suspend fun getTrendingMovies(){
        val result=movieListService.trendingMovieList()
        if(result.body() !=null){
            trendingMutableLiveData.postValue(result.body())
        }
    }


}