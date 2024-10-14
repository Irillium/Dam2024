package edu.iesam.dam2024.feature.pokemons.presentation


import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.navigation.fragment.navArgs
import edu.iesam.dam2024.app.extensions.loadUrl
import edu.iesam.dam2024.databinding.FragmentPokemonDetailBinding
import edu.iesam.dam2024.feature.pokemons.domain.Pokemon

class PokemonDetailFragment : Fragment() {
    private lateinit var factory: PokemonFactory
    private lateinit var viewModel: PokemonDetailViewModel

    private var _binding: FragmentPokemonDetailBinding? = null
    private val binding get() = _binding!!

    private val pokemonArgs: PokemonDetailFragmentArgs by navArgs()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentPokemonDetailBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        pokemonArgs.pokemonId
        factory = PokemonFactory(requireContext())
        viewModel = factory.buildPokemonDetailViewModel()
        setubObserver()
        viewModel.loadPokemon(pokemonArgs.pokemonId)

    }

    fun setubObserver(){
        val observer = Observer <PokemonDetailViewModel.UiState> { uiState ->
            uiState.pokemon?.let { pokemon ->
                bindData(pokemon)
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
       viewModel.uiState.observe(viewLifecycleOwner,observer)
    }

    fun bindData(pokemon:Pokemon){
        binding.apply {
            pokemon.sprites.front_default?.let { url ->
                img.loadUrl(url)
            }
            name.text=pokemon.name
        }
    }
}