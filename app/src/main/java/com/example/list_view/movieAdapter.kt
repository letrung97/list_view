package com.example.list_view

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide

class movieAdapter(val ctx: Context, var data: ArrayList<movie>, val listener: movieListener) : RecyclerView.Adapter<movieAdapter.movieVH>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): movieVH {
        val view = LayoutInflater.from(ctx).inflate(R.layout.list_view, parent, false)
        return movieVH(view)
    }
    override fun getItemCount(): Int {
        return data.size
    }
    override fun onBindViewHolder(holder: movieVH, position: Int) {
        val movies = data[position]
        Glide.with(ctx)
            .load( "https://image.tmdb.org/t/p/w500/"+movies.backdrop_path)
            .centerCrop()
            .into(holder.img)
        holder.title.text = movies.title
        holder.rating.text = movies.vote_average.toString()

        holder.itemView.setOnClickListener{
            listener.onClick(position, movies)
        }
    }
    class movieVH(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val title = itemView.findViewById<TextView>(R.id.title)
        val rating = itemView.findViewById<TextView>(R.id.rating)
        val img = itemView.findViewById<ImageView>(R.id.img)
    }
    interface movieListener{
        fun onClick(pos: Int, movies: movie)
    }
}

