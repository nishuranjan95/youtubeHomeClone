package com.example.youtubehomeclone.api

import com.example.youtubehomeclone.models.PopularMovie
import com.example.youtubehomeclone.models.TrendingMovie
import retrofit2.Response
import retrofit2.http.GET

interface MovieListService {

    @GET("3/movie/popular")
    suspend fun popularMovieList():Response<PopularMovie>

    @GET("3/trending/movie/day")
    suspend fun trendingMovieList():Response<TrendingMovie>

}