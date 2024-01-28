package com.example.youtubehomeclone.models//package com.example.myapplication.models
//
import androidx.lifecycle.LiveData
import androidx.room.*

@Dao
interface MovieDao {
    @Insert
    suspend fun addMovie(result: Result)
    @Update
    suspend fun updateMovie(result: Result)
    @Delete
    suspend fun deleteMovie(result: Result)
    @Query("SELECT * FROM popularMovies")
    fun getMovie(): LiveData<List<Result>>
}
