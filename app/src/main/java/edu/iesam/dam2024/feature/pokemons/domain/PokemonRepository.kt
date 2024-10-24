package edu.iesam.dam2024.feature.pokemons.domain

interface PokemonRepository {
    suspend fun getPokemos():List<Pokemon>
    suspend fun getPokemon(id:String):Pokemon?
    suspend fun getNextPokemons(offset:Int):List<Pokemon>
}