package com.example.youtubehomeclone.adapter

import android.content.Context
import android.graphics.Movie
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.youtubehomeclone.interfaces.OnMovieItemClick
import com.example.youtubehomeclone.R
import com.example.youtubehomeclone.databinding.SingleitemBinding
import com.example.youtubehomeclone.databinding.SingleitemRcvBinding
import com.example.youtubehomeclone.models.Result

class MovieAdapter(private var movies: ArrayList<Result>, private val context: Context, private val onMovieItemClick: OnMovieItemClick) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    private val HORIZONTAL_TYPE=1
    private val VERTICAL_TYPE=2

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        return when(viewType){
            HORIZONTAL_TYPE->{
                MovieTrendingViewHolder(SingleitemRcvBinding.inflate(inflater, parent, false))
            }
            else -> {
                MovieViewHolder(SingleitemBinding.inflate(inflater, parent, false))
            }
        }
    }

    override fun getItemCount(): Int = movies.size

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {

        when(getItemViewType(position)){
            HORIZONTAL_TYPE -> {
                (holder as MovieTrendingViewHolder).bind(movies,position,context,onMovieItemClick)
            }
            else -> {
                (holder as MovieViewHolder).bind(movies,position,context,onMovieItemClick)
            }
        }


    }

    override fun getItemViewType(position: Int): Int {
        if(movies[position].type=="Short"){
            return HORIZONTAL_TYPE
        }
        return VERTICAL_TYPE
    }

}

class MovieViewHolder(private val binding:SingleitemBinding) : RecyclerView.ViewHolder(binding.root){
      fun bind(movies: List<Result>, position: Int, context: Context, onMovieItemClick: OnMovieItemClick){
          binding.title.text= movies[position].title
          Glide.with(context)
              .load("https://image.tmdb.org/t/p/original"+movies[position].poster_path)
              .placeholder(R.drawable.photo)
              .centerCrop()
              .into(binding.image)

          binding.singleParent.setOnClickListener{
              onMovieItemClick.onClick(movies[position])
          }
      }
}

class MovieTrendingViewHolder(private val binding:SingleitemRcvBinding) : RecyclerView.ViewHolder(binding.root){
    fun bind(movies: List<Result>, position: Int, context: Context, onMovieItemClick: OnMovieItemClick){
        binding.shortRecyclerview.layoutManager = LinearLayoutManager(context,LinearLayoutManager.HORIZONTAL,false)
        binding.shortRecyclerview.adapter = MovieShortAdapter(movies[position].trendingsShort,context,onMovieItemClick)
    }
}
