package edu.iesam.dam2024.feature.superheros.presentation

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import edu.iesam.dam2024.databinding.FragmentSuperheroListBinding
import edu.iesam.dam2024.feature.superheros.domain.Superhero

class SuperheroListFragment : Fragment() {

    private lateinit var factory: SuperheroFactory
    private lateinit var viewModel: SuperheroListViewModel

    private var _binding: FragmentSuperheroListBinding? = null
    private val binding get() = _binding!!

    private val superheroAdapter = SuperheroAdapter { id ->
        navigateToDetail(id)
    }


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
        viewModel = factory.buildSuperheroListViewModel()
        setupObserver()
        setupView()

        viewModel.loadSuperheroes()
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding=null
    }
    private fun setupObserver() {
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
        superheroAdapter.submitList(heroes)

    }
    private fun setupView(){

        binding.apply {
            list.layoutManager= LinearLayoutManager(
                requireContext(),
                LinearLayoutManager.VERTICAL,
                false
            )
            list.adapter = superheroAdapter

        }
    }
    fun navigateToDetail(id: String) {
        findNavController().navigate(
            SuperheroListFragmentDirections.actionFromSuperheroToSuperheroDetail(id)
        )
    }

}
