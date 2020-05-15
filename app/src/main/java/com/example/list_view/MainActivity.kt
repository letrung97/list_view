package com.example.list_view

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.appcompat.app.AlertDialog
import androidx.recyclerview.widget.LinearLayoutManager
import com.khtn.androidcamp.generateMovie
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    lateinit var adapter : movieAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        rv.layoutManager = LinearLayoutManager(this)
        rv.adapter = movieAdapter(this, generateMovie() as ArrayList<movie>, listener)
    }
    private val listener = object : movieAdapter.movieListener{
        override fun onClick(pos: Int, movies: movie) {
            startProfileActivity(movies)
        }
    }
    private fun startProfileActivity(movies: movie){
        val intent = Intent(this@MainActivity, ProfileActivity::class.java)
        intent.putExtra(MOVIE_TITLE_KEY, movies.title)
        intent.putExtra(MOVIE_RATING_KEY, movies.vote_average)
        intent.putExtra(MOVIE_IMAGE_KEY, movies.poster_path)
        intent.putExtra(MOVIE_LANGUAGE_KEY,movies.original_language)
        intent.putExtra(MOVIE_DATE_KEY,movies.release_date)
        intent.putExtra(MOVIE_OVERVIEW_KEY,movies.overview)
        intent.putExtra(MOVIE_GENRE_KEY,movies.genre_ids.toString())
        startActivity(intent)
    }
}
