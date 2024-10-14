package edu.iesam.dam2024.feature.pokemons.domain

class GetPokemonUseCase(private val pokemonRepository: PokemonRepository) {
    operator suspend fun invoke(id:String):Pokemon?{
        return pokemonRepository.getPokemon(id)
    }
}