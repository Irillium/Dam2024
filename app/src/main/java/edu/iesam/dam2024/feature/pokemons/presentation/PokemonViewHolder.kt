package edu.iesam.dam2024.feature.pokemons.presentation

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import edu.iesam.dam2024.app.extensions.loadUrl
import edu.iesam.dam2024.databinding.ViewPokemonItemBinding
import edu.iesam.dam2024.feature.pokemons.domain.Pokemon

class PokemonViewHolder(val view: View, val navigateToDetail: (String) -> Unit): RecyclerView.ViewHolder(view) {
    private lateinit var binding: ViewPokemonItemBinding
    fun bind(pokemon: Pokemon) {
        binding = ViewPokemonItemBinding.bind(view)
        binding.apply {
            name.text = pokemon.name
            pokemon.sprites.front_default?.let { sprite ->
                img.loadUrl(sprite)
            }
            view.setOnClickListener {
                navigateToDetail(pokemon.id)
            }
        }
    }
}