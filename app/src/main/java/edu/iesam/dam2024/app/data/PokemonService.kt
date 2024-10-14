package edu.iesam.dam2024.app.data

import edu.iesam.dam2024.feature.pokemons.domain.Pokemon
import edu.iesam.dam2024.feature.pokemons.domain.PokemonResponse
import retrofit2.http.GET
import retrofit2.http.Path

interface PokemonService {
    @GET("pokemon")
    suspend fun getPokemons(): PokemonResponse

    @GET("pokemon/{id}")
    suspend fun getPokemonById(@Path("id") id: String): Pokemon
}