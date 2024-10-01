package edu.iesam.dam2024.feature.movies.presentation

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity
import edu.iesam.dam2024.R
import edu.iesam.dam2024.feature.movies.domain.Movie
import com.bumptech.glide.Glide

class MovieDetailActivity : AppCompatActivity() {

    private lateinit var movieFactory: MovieFactory
    private lateinit var viewModel: MovieDetailViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_movie_detail)

        movieFactory = MovieFactory(this)
        viewModel = movieFactory.buildMovieDatailViewModel()

        getMovieId()?.let { movieId ->
            viewModel.itemSelected(movieId)?.let { movie ->
                binData(movie)
            }
        }

    }
    private fun getMovieId():String?{
        return intent.getStringExtra(KEY_MOVIE_ID)
    }
    private fun binData(movie:Movie){
        val imageView = findViewById<ImageView>(R.id.poster)
        Glide.with(this).load(movie).into(imageView)
    }
    companion object {
        val KEY_MOVIE_ID= "key_movie_id"

        fun getIntent(context: Context, movieId:String): Intent{
            val intent = Intent(context, MovieDetailActivity::class.java)
            intent.putExtra(KEY_MOVIE_ID,movieId)
            return intent
        }
    }
}