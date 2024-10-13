package edu.iesam.dam2024.feature.pokemons.domain

class GetPokemonsUseCase(private val pokemonRepository: PokemonRepository) {
    operator fun invoke(): List<Pokemon> {
        return pokemonRepository.getPokemos()
    }
}