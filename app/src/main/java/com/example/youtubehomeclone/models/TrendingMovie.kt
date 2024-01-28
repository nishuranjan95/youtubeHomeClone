package com.example.youtubehomeclone.models


data class TrendingMovie(
    val page: Int,
    val results: ArrayList<ResultTrending>,
    val total_pages: Int,
    val total_results: Int
)

