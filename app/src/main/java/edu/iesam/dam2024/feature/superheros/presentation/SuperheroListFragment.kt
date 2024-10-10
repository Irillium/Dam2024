package edu.iesam.dam2024.feature.superheros.presentation

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import edu.iesam.dam2024.R
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
        _binding = FragmentSuperheroListBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        factory = SuperheroFactory(requireContext())
        setubObserver()
        viewModel = factory.buildSuperheroListViewModel()
    }

    private fun setubObserver() {
        val observer = Observer<SuperheroListViewModel.UiState> { uiState ->
            uiState.superheroes?.let { superheroes ->
                bindData(superheroes)
            }
            uiState.errorApp?.let {
                //Pinto el erros
            } ?: run {
                //oculto el error
            }
            if (uiState.isLoading) {
                //muestro cargando
            } else {
                //
            }
        }
        viewModel.uiState.observe(viewLifecycleOwner, observer)
    }

    private fun bindData(heroes: List<Superhero>) {
        //binding.hero1.text=heroes[0].name
        //binding.hero1.setOnClickListener{ }
        binding.apply {
            hero1.apply {
                text = heroes[0].name
                setOnClickListener {

                }
                hero2.apply {
                    text = heroes[1].name
                    setOnClickListener {

                    }
                }
                hero3.apply {
                    text = heroes[2].name
                    setOnClickListener {

                    }
                }

            }
        }
        fun navigateToDetail(id: String) {
            findNavController().navigate(
                SuperheroListFragmentDirections.actionFromSuperheroToSuperheroDetail()
            )

        }

    }
}
