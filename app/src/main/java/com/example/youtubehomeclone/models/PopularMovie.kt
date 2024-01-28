package com.example.youtubehomeclone.models


data class PopularMovie(
    val page: Int,
    val results: ArrayList<Result>,
    val total_pages: Int,
    val total_results: Int
)

