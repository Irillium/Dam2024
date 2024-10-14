package edu.iesam.dam2024.feature.pokemons.presentation

import android.content.Context
import edu.iesam.dam2024.feature.pokemons.data.PokemonDataRepository
import edu.iesam.dam2024.feature.pokemons.data.local.PokemonXmlLocalDataSource
import edu.iesam.dam2024.feature.pokemons.data.remote.PokemonAPIDataSource
import edu.iesam.dam2024.feature.pokemons.domain.GetPokemonUseCase
import edu.iesam.dam2024.feature.pokemons.domain.GetPokemonsUseCase

class PokemonFactory(private val context: Context) {
    private val pokemonRemote=PokemonAPIDataSource()
    private val pokemonLocal=PokemonXmlLocalDataSource(context)
    private val pokemonRepository= PokemonDataRepository(pokemonRemote,pokemonLocal)

    private val getPokemonsUseCase=GetPokemonsUseCase(pokemonRepository)
    private val getPokemonUseCase= GetPokemonUseCase(pokemonRepository)

    private val pokemonListViewModel=PokemonListViewModel(getPokemonsUseCase)
    private val pokemonDetailViewModel=PokemonDetailViewModel(getPokemonUseCase)

    fun buildPokemonListViewModel():PokemonListViewModel{
        return pokemonListViewModel
    }
    fun buildPokemonDetailViewModel():PokemonDetailViewModel{
        return pokemonDetailViewModel
    }
}