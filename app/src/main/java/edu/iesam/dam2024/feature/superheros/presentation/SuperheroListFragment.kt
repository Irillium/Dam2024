package edu.iesam.dam2024.feature.superheros.presentation

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import edu.iesam.dam2024.databinding.FragmentSuperheroListBinding
import edu.iesam.dam2024.feature.movies.presentation.MovieDetailViewModel
import edu.iesam.dam2024.feature.movies.presentation.MovieFactory
import edu.iesam.dam2024.feature.superheros.domain.Superhero

class SuperheroListFragment : Fragment() {

    private lateinit var factory: SuperheroFactory
    private lateinit var viewModel: SuperheroListViewModel

    private var _binding: FragmentSuperheroListBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentSuperheroListBinding.inflate(inflater,container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        factory = SuperheroFactory(requireContext())
        setubObserver()
        viewModel = factory.buildSuperheroListViewModel()
    }

    private fun setubObserver(){
        val observer = Observer<SuperheroListViewModel.UiState>{

        }
        viewModel.uiState.observe(viewLifecycleOwner,observer)
    }

}