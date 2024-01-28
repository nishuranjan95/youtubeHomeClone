package com.example.youtubehomeclone.repository

import androidx.lifecycle.LiveData
import com.example.youtubehomeclone.models.MovieDao
import com.example.youtubehomeclone.models.Result

class DaoRepository(private val moviesDao: MovieDao) {

    fun getMovies(): LiveData<List<Result>> {
        return moviesDao.getMovie()
    }

    suspend fun insertMovie(result: Result){
        moviesDao.addMovie(result)
    }
}