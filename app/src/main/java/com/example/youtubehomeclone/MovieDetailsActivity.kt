package com.example.youtubehomeclone

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.example.youtubehomeclone.databinding.ActivityMovieDetailsBinding

class MovieDetailsActivity : AppCompatActivity() {
    private lateinit var activityMovieDetailsBinding: ActivityMovieDetailsBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        activityMovieDetailsBinding=DataBindingUtil.setContentView(this,
            R.layout.activity_movie_details
        )
        activityMovieDetailsBinding.movieDetail.text=intent.getStringExtra("movie")
    }
}