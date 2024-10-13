package edu.iesam.dam2024.feature.movies.presentation

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.navigation.fragment.navArgs
import edu.iesam.dam2024.app.extensions.loadUrl
import edu.iesam.dam2024.databinding.FragmentMovieDetailBinding
import edu.iesam.dam2024.databinding.FragmentMoviesBinding
import edu.iesam.dam2024.feature.movies.domain.Movie

class MovieDetailFragment :Fragment(){
    private lateinit var movieFactory: MovieFactory
    private lateinit var viewModel: MovieDetailViewModel

    private var _binding: FragmentMovieDetailBinding? =null
    private val binding get() = _binding!!//Forzado a no nulo

    private val movieArgs: MovieDetailFragmentArgs by navArgs()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentMovieDetailBinding.inflate(inflater,container, false)
        return binding.root
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        movieArgs.movieId
        movieFactory = MovieFactory(requireContext())
        viewModel = movieFactory.buildMovieDetailViewModel()
        setubObserver()
       viewModel.itemSelected(movieArgs.movieId)
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
        viewModel.uiState.observe(viewLifecycleOwner, movieObserver)

    }

    private fun bindData(movie: Movie){
        binding.apply {
            poster.loadUrl(movie.poster)
            titleDetail.text=movie.title
        }
    }
    override fun onDestroyView() {
        super.onDestroyView()
        _binding= null
    }

}