package com.example.youtubehomeclone.models

import androidx.room.Entity
import androidx.room.PrimaryKey

//@Entity(tableName = "popularMovies")
data class ResultTrending(
//        @PrimaryKey(autoGenerate = true)
        var pId:Int,
        val adult: Boolean,
        val backdrop_path: String,
        val id: Int,
        val original_language: String,
        val original_title: String,
        val overview: String,
        val popularity: Double,
        val poster_path: String,
        val release_date: String,
        val title: String,
        val video: Boolean,
        val vote_average: Double,
        val vote_count: Int,
        var type:String
        )
