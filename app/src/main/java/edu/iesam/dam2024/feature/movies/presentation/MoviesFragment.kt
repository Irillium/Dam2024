package edu.iesam.dam2024.feature.movies.presentation

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import edu.iesam.dam2024.databinding.FragmentMoviesBinding
import edu.iesam.dam2024.feature.movies.domain.Movie

class MoviesFragment : Fragment() {

    private lateinit var movieFactory: MovieFactory
    private lateinit var viewModel: MoviesViewModel

    private var _binding: FragmentMoviesBinding? = null
    private val binding get() = _binding!!//Forzado a no nulo


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentMoviesBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        movieFactory = MovieFactory(requireContext())
        viewModel = movieFactory.buildViewModel()
        setubObserver()
        viewModel.viewCreated()
    }

    private fun setubObserver() {
        val movieObserver = Observer<MoviesViewModel.UiState> { uiState ->
            uiState.movies?.let {
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

    private fun bindData(movies: List<Movie>) {
        binding.apply {
            movieId1.text = movies[0].id
            movieTitle1.text = movies[0].title
            movieLayout1.setOnClickListener {
                navigateToMovieDetail(movies[1].id)
            }

            movieId2.text = movies[1].id
            movieTitle2.text = movies[1].title
            movieLayout2.setOnClickListener {
                navigateToMovieDetail(movies[1].id)
            }

            movieId3.text = movies[2].id
            movieTitle3.text = movies[2].title
            movieLayout3.setOnClickListener {
                navigateToMovieDetail(movies[2].id)
            }

            movieId4.text = movies[3].id
            movieTitle4.text = movies[3].title
            movieLayout4.setOnClickListener {
                navigateToMovieDetail(movies[3].id)
            }
        }
    }

    private fun navigateToMovieDetail(movieId: String) {
       findNavController().navigate(
           MoviesFragmentDirections.actionFromMoviesToMovieDetail(movieId)
       )
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}