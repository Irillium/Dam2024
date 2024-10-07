package edu.iesam.dam2024.feature.movies.presentation

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import edu.iesam.dam2024.R
import edu.iesam.dam2024.app.extensions.loadUrl
import edu.iesam.dam2024.feature.movies.domain.Movie


class MovieDetailActivity : AppCompatActivity() {

    private lateinit var movieFactory: MovieFactory
    private lateinit var viewModel: MovieDetailViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_movie_detail)

        movieFactory = MovieFactory(this)
        viewModel = movieFactory.buildMovieDatailViewModel()

        setubObserver()
        getMovieId()?.let {
            viewModel.itemSelected(it)
        }
    }
    private fun setubObserver() {
        val movieObserver = Observer<MovieDetailViewModel.UiState> { uiState ->

            uiState.movie?.let {
                bindData(it)
            }
            uiState.errorApp?.let {
                //pinto error
            }
            if (uiState.isLoading) {
                Log.d("@dev", "muestro el cargado...")
            } else {
                Log.d("@dev", "oculto el cargado...")
            }

        }
        viewModel.uiState.observe(this, movieObserver)

    }
    private fun getMovieId():String?{
        return intent.getStringExtra(KEY_MOVIE_ID)
    }
    private fun bindData(movie:Movie){
        val imageView = findViewById<ImageView>(R.id.poster)
        imageView.loadUrl(movie.poster)
        findViewById<TextView>(R.id.titleDetail).text = movie.title
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