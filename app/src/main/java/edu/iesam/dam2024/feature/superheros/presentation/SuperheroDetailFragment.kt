package edu.iesam.dam2024.feature.superheros.presentation

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.navigation.fragment.navArgs
import edu.iesam.dam2024.app.extensions.loadUrl
import edu.iesam.dam2024.databinding.FragmentSuperheroDetailBinding
import edu.iesam.dam2024.feature.superheros.domain.Superhero


class SuperheroDetailFragment : Fragment() {

    private lateinit var factory: SuperheroFactory
    private lateinit var viewModel: SuperheroDetailViewModel

    private var _binding: FragmentSuperheroDetailBinding? = null
    private val binding get() = _binding!!

    private val superheroArgs: SuperheroDetailFragmentArgs by navArgs()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentSuperheroDetailBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        superheroArgs.superheroId
        factory = SuperheroFactory(requireContext())
         viewModel = factory.buildSuperheroDetailViewModel()
        setubObserver()
        viewModel.itemSelected(superheroArgs.superheroId)
    }

    private fun setubObserver() {
        val observer = Observer<SuperheroDetailViewModel.UiState> { uiState ->
            uiState.superhero?.let { superhero ->
                bindData(superhero)
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

    private fun bindData(hero: Superhero) {
        binding.apply {
            imgHeroDetail.loadUrl(hero.image)
            name.text = hero.name
        }
    }

}