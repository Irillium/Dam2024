package edu.iesam.dam2024.feature.pokemons.domain

interface PokemonRepository {
    fun getPokemos():List<Pokemon>
    fun getPokemon(id:String):Pokemon?
}