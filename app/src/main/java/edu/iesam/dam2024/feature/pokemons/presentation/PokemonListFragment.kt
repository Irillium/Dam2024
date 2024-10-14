package edu.iesam.dam2024.feature.pokemons.presentation

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.View.OnClickListener
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import edu.iesam.dam2024.databinding.FragmentPokemonListBinding
import edu.iesam.dam2024.feature.pokemons.domain.Pokemon


class PokemonListFragment:Fragment(){
    private lateinit var factory: PokemonFactory
    private lateinit var viewModel: PokemonListViewModel

    private var _binding: FragmentPokemonListBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentPokemonListBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        factory = PokemonFactory(requireContext())
        viewModel = factory.buildPokemonListViewModel()
        setubObserver()
        viewModel.loadPokemons()

    }

    fun setubObserver(){
        val observer = Observer <PokemonListViewModel.UiState> { uiState ->
            uiState.pokemons?.let { pokemons ->
                bindData(pokemons)
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

    fun bindData(pokemons:List<Pokemon>){
        binding.apply {
            pokemon1.apply {
                text=pokemons[0].name
                setOnClickListener(){
                    navigateToDetail(pokemons[0].name)
                }
            }
            pokemon2.apply {
                text=pokemons[1].name
                setOnClickListener(){
                    navigateToDetail(pokemons[1].name)
                }
            }
            pokemon3.apply {
                text=pokemons[2].name
                setOnClickListener(){
                    navigateToDetail(pokemons[2].name)
                }
            }
            pokemon4.apply {
                text=pokemons[3].name
                setOnClickListener(){
                    navigateToDetail(pokemons[3].name)
                }
            }
            pokemon5.apply {
                text=pokemons[4].name
                setOnClickListener(){
                    navigateToDetail(pokemons[4].name)
                }
            }
        }

    }
    fun navigateToDetail(name: String) {
        findNavController().navigate(
            PokemonListFragmentDirections.actionFromPokemonToPokemonDetail(name)
        )
    }
}