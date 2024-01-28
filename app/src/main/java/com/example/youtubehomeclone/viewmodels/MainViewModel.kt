package com.example.youtubehomeclone.viewmodels

import androidx.lifecycle.*
import com.example.youtubehomeclone.models.PopularMovie
import com.example.youtubehomeclone.models.TrendingMovie
import com.example.youtubehomeclone.repository.MovieRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class MainViewModel(private val movieRepository: MovieRepository):ViewModel() {

    init {
        viewModelScope.launch(Dispatchers.IO) {
            movieRepository.getPopularMovie()
            movieRepository.getTrendingMovies()

        }
    }
    val popularMovieData:LiveData<PopularMovie>
    get() = movieRepository.popularMovieLiveData

    val trendingMovieData:LiveData<TrendingMovie>
    get() = movieRepository.trendingMovieLiveData


}