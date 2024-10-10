package edu.iesam.dam2024.feature.superheros.presentation

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.navArgs
import edu.iesam.dam2024.databinding.FragmentSuperheroDetailBinding


class SuperheroDetailFragment : Fragment() {
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
    }
}