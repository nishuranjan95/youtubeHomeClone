package com.example.youtubehomeclone.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.youtubehomeclone.interfaces.OnMovieItemClick
import com.example.youtubehomeclone.R
import com.example.youtubehomeclone.databinding.SingleItemShortBinding
import com.example.youtubehomeclone.databinding.SingleitemBinding
import com.example.youtubehomeclone.models.Result
import com.example.youtubehomeclone.models.ResultTrending

class MovieShortAdapter(private var movies: List<ResultTrending>, private val context: Context, private val onMovieItemClick: OnMovieItemClick) : RecyclerView.Adapter<MovieShortViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MovieShortViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = SingleItemShortBinding.inflate(inflater, parent, false)
        return MovieShortViewHolder(binding)
    }

    override fun getItemCount(): Int = movies.size

    override fun onBindViewHolder(holder: MovieShortViewHolder, position: Int) {
           holder.bind(movies,position,context,onMovieItemClick)
    }

}

class MovieShortViewHolder(private val binding:SingleItemShortBinding) : RecyclerView.ViewHolder(binding.root){
      fun bind(movies: List<ResultTrending>, position: Int, context: Context, onMovieItemClick: OnMovieItemClick){
          binding.title.text= movies[position].title
          Glide.with(context)
              .load("https://image.tmdb.org/t/p/original"+movies[position].poster_path)
              .placeholder(R.drawable.photo)
              .centerCrop()
              .into(binding.image)


      }
}
