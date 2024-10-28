package edu.iesam.dam2024.feature.pokemons.presentation

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import edu.iesam.dam2024.R
import edu.iesam.dam2024.feature.pokemons.domain.Pokemon

class PokemonAdapter (private var pokemons: List<Pokemon>,private val navigateToDetail: (String) -> Unit):
ListAdapter<Pokemon,PokemonViewHolder>(PokemonDiffUtil())
{
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PokemonViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.view_pokemon_item, parent, false)
        return PokemonViewHolder(view, navigateToDetail)
    }

    override fun onBindViewHolder(holder: PokemonViewHolder, position: Int) {
       holder.bind(currentList[position])
    }

    fun updateData(newPokemons: List<Pokemon>) {
        val updatedList = pokemons.toMutableList()
        updatedList.addAll(newPokemons)
        pokemons = updatedList
        notifyDataSetChanged()
    }
}