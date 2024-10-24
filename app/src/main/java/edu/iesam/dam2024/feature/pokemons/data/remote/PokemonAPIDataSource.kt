package edu.iesam.dam2024.feature.pokemons.data.remote

import android.util.Log
import edu.iesam.dam2024.app.data.PokemonClient
import edu.iesam.dam2024.feature.pokemons.domain.Pokemon

class PokemonAPIDataSource {

    private val apiService = PokemonClient().apiService
    private val limit=20

     suspend fun getPokemons(): List<Pokemon> {
         return try {
             val response = apiService.getPokemons()
             // Aquí deberías convertir PokemonResult a tu modelo Pokemon
             response.results.map { result ->
                 // Aquí puedes hacer otra llamada a la API para obtener los detalles del Pokémon si lo deseas
                 val pokemonDetails = apiService.getPokemonById(result.url.split("/").dropLast(1).last()) // Extraer ID de la URL
                 pokemonDetails
             }
         } catch (e: Exception) {
             Log.e("PokemonAPIDataSource", "Error fetching Pokemons", e)
             emptyList()
         }
    }
    suspend fun getNextPokemons(offset:Int):List<Pokemon>{
        return try {
            val response = apiService.getNextPokemons(limit,offset)
            response.results.map { result ->
                val pokemonDetails = apiService.getPokemonById(result.url.split("/").dropLast(1).last()) // Extraer ID de la URL
                pokemonDetails
            }
        } catch (e: Exception) {
            Log.e("PokemonAPIDataSource", "Error fetching Pokemons", e)
            emptyList()
        }
    }
    suspend fun getPokemon(id: String): Pokemon? {
        return try {
            apiService.getPokemonById(id)
        } catch (e: Exception) {
            null
        }
    }
}