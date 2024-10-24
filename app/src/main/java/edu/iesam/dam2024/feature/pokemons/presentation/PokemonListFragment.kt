package edu.iesam.dam2024.feature.pokemons.presentation

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.View.OnClickListener
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import edu.iesam.dam2024.databinding.FragmentPokemonListBinding
import edu.iesam.dam2024.feature.pokemons.domain.Pokemon


class PokemonListFragment:Fragment(){
    private lateinit var factory: PokemonFactory
    private lateinit var viewModel: PokemonListViewModel

    private var _binding: FragmentPokemonListBinding? = null
    private val binding get() = _binding!!

    private val pokemonAdapter=PokemonAdapter{
        id -> navigateToDetail(id)
    }

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
        setupObserver()
        setupView()
        if (viewModel.currentPokemonList.isEmpty()) {
            viewModel.loadPokemons()
        }
    }

    fun setupObserver(){
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

        binding.list.addOnScrollListener(object : RecyclerView.OnScrollListener() {
            override fun onScrolled(recyclerView: RecyclerView, dx: Int, dy: Int) {
                super.onScrolled(recyclerView, dx, dy)

                val layoutManager = recyclerView.layoutManager as LinearLayoutManager
                val totalItemCount = layoutManager.itemCount
                val lastVisibleItem = layoutManager.findLastVisibleItemPosition()

                if (lastVisibleItem == totalItemCount - 1) {
                    // Hemos llegado al final, cargar más datos
                    Log.d("@dev","Oido?")
                    viewModel.loadNextPokemons()
                }
            }
        })
    }
    fun bindData(pokemons:List<Pokemon>){
        pokemonAdapter.submitList(pokemons)
    }
    private fun setupView() {
        binding.apply {
            list.layoutManager = LinearLayoutManager(
                requireContext(),
                LinearLayoutManager.VERTICAL,
                false
            )
            list.adapter = pokemonAdapter
        }
    }

    fun navigateToDetail(id: String) {
        findNavController().navigate(
            PokemonListFragmentDirections.actionFromPokemonToPokemonDetail(id)
        )
    }
}
