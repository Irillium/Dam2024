package edu.iesam.dam2024.feature.pokemons.data

import edu.iesam.dam2024.feature.pokemons.data.local.PokemonXmlLocalDataSource
import edu.iesam.dam2024.feature.pokemons.data.remote.PokemonMockRemoteDataSource
import edu.iesam.dam2024.feature.pokemons.domain.Pokemon
import edu.iesam.dam2024.feature.pokemons.domain.PokemonRepository

class PokemonDataRepository(
    private val remote: PokemonMockRemoteDataSource,
    private val local : PokemonXmlLocalDataSource ):PokemonRepository {

    override fun getPokemos(): List<Pokemon> {
        val pokemonsFromLocal = local.findAll()
        if(pokemonsFromLocal.isEmpty()){
            val pokemonsFromRemote = remote.getPokemons()
            local.saveAll(pokemonsFromRemote)
            return pokemonsFromRemote
        }
        return pokemonsFromLocal
    }

    override fun getPokemon(id: String): Pokemon? {
       val localPokemon = local.findById(id)
        if (localPokemon == null){
            remote.getPokemon(id)?.let {
                local.save(it)
                return it
            }
        }
        return localPokemon
    }
}