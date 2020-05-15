package com.example.list_view

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.list_view.*
import kotlinx.android.synthetic.main.movie_info.*
import kotlinx.android.synthetic.main.movie_info.rating

class ProfileActivity : AppCompatActivity(){
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.movie_info)
        getAndDisplayData()
    }
    private fun getAndDisplayData() {
        val data = intent.extras

        if (data != null) {
            val title1 = data.getString(MOVIE_TITLE_KEY)
            val rating1 = data.getString(MOVIE_RATING_KEY)
            val image1 = data.getString(MOVIE_IMAGE_KEY)
            val lang1 = data.getString(MOVIE_LANGUAGE_KEY)
            val date1 = data.getString(MOVIE_DATE_KEY)
            val overview1 = data.getString(MOVIE_OVERVIEW_KEY)
            val genre1 = data.getString(MOVIE_GENRE_KEY)

            name.text = title1
            rating.text = rating1
            language.text = lang1
            date.text = date1
            overview.text = overview1
            genre.text = genre1
            Glide.with(this)
                .load("https://image.tmdb.org/t/p/w500/"+ image1)
                .centerCrop()
                .into(image)
        }
    }
}

