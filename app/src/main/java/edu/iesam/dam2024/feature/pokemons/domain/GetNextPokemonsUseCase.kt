package edu.iesam.dam2024.feature.pokemons.domain

class GetNextPokemonsUseCase(private val pokemonRepository: PokemonRepository) {
    operator suspend fun invoke(offset:Int): List<Pokemon> {
        return pokemonRepository.getNextPokemons(offset)
    }
}