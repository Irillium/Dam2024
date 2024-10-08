package edu.iesam.dam2024.feature.movies.presentation

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import edu.iesam.dam2024.R
import edu.iesam.dam2024.app.extensions.loadUrl
import edu.iesam.dam2024.databinding.FragmentMoviesBinding
import edu.iesam.dam2024.feature.movies.domain.Movie
import edu.iesam.dam2024.feature.movies.presentation.MovieDetailActivity.Companion.KEY_MOVIE_ID

class MovieDetailFragment :Fragment(){
    private lateinit var movieFactory: MovieFactory
    private lateinit var viewModel: MovieDetailViewModel

    private var _binding: FragmentMoviesBinding? =null
    private val binding get() = _binding!!//Forzado a no nulo

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentMoviesBinding.inflate(inflater,container, false)
        return binding.root
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        movieFactory = MovieFactory(requireContext())
        viewModel = movieFactory.buildMovieDatailViewModel()

        setubObserver()
        getMovieId()?.let {
            viewModel.itemSelected(it)
        }
    }
    private fun getMovieId():String?{
        return intent.getStringExtra(KEY_MOVIE_ID)
    }
    private fun bindData(movie: Movie){
        //val imageView = findViewById<ImageView>(R.id.poster)
        //imageView.loadUrl(movie.poster)
        //findViewById<TextView>(R.id.titleDetail).text = movie.title
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
    companion object {
        val KEY_MOVIE_ID= "key_movie_id"

        fun getIntent(context: Context, movieId:String): Intent {
            val intent = Intent(context, MovieDetailActivity::class.java)
            intent.putExtra(KEY_MOVIE_ID,movieId)
            return intent
        }
    }

}