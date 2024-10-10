package edu.iesam.dam2024.feature.movies.presentation

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import edu.iesam.dam2024.R
import edu.iesam.dam2024.databinding.FragmentMoviesBinding
import edu.iesam.dam2024.feature.movies.domain.Movie
import edu.iesam.dam2024.feature.superheros.presentation.SuperherosActivity

class MoviesFragment : Fragment() {

    private lateinit var movieFactory: MovieFactory
    private lateinit var viewModel: MoviesViewModel

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
        setubObserver()
        movieFactory = MovieFactory(requireContext())
        viewModel=movieFactory.buildViewModel()
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

    fun bindData(movies: List<Movie>) {

        binding.movieId1.text = movies[0].id
        binding.movieTitle1.text = movies[0].title
        binding.movieLayout1.setOnClickListener{
           //findNavController().navigate(R.)
        }

        binding.movieId1.text = movies[1].id
        binding.movieTitle1.text = movies[1].title
        binding.movieLayout1.setOnClickListener{
            navigateToMovieDetail(movies[1].id)
        }

        binding.movieId1.text = movies[2].id
        binding.movieTitle1.text = movies[2].title
        binding.movieLayout1.setOnClickListener{
            navigateToMovieDetail(movies[2].id)
        }

        binding.movieId1.text = movies[3].id
        binding.movieTitle1.text = movies[3].title
        binding.movieLayout1.setOnClickListener{
            navigateToMovieDetail(movies[3].id)
        }

        val goHero: String = getString(R.string.goSuperheros)
        binding.goHero.text= goHero
        binding.movieLayout5.setOnClickListener {
            navigateToSuperherosList()
        }

    }

    private fun navigateToMovieDetail(movieId: String) {
       // startActivity(MovieDetailActivity.getIntent(requireContext(), movieId))
    }

    private fun navigateToSuperherosList() {
        startActivity(SuperherosActivity.getIntent(requireContext()))
    }
    override fun onDestroyView() {
        super.onDestroyView()
        _binding= null
    }
}