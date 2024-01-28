package com.example.myapplication.viewmodels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.youtubehomeclone.repository.MovieRepository
import com.example.youtubehomeclone.viewmodels.MainViewModel

class MainViewModelFactory(private val movieRepository: MovieRepository): ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return MainViewModel(movieRepository) as T
    }
}