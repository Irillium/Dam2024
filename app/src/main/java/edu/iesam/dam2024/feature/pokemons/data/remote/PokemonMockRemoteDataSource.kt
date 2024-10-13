package edu.iesam.dam2024.feature.pokemons.data.remote

import edu.iesam.dam2024.feature.pokemons.domain.Pokemon
import edu.iesam.dam2024.feature.pokemons.domain.Sprites


class PokemonMockRemoteDataSource {
    fun getPokemons(): List<Pokemon>{
        return listOf(
            Pokemon(
                id = "1",
                name = "Bulbasaur",
                sprites = Sprites(backDefault = "https://archives.bulbagarden.net/media/upload/thumb/f/fb/0001Bulbasaur.png/250px-0001Bulbasaur.png")
            ),
            Pokemon(
                id = "2",
                name = "Ivysaur",
                sprites = Sprites(backDefault = "https://archives.bulbagarden.net/media/upload/thumb/8/81/0002Ivysaur.png/250px-0002Ivysaur.png")
            ),
            Pokemon(
                id = "3",
                name = "Venusaur",
                sprites = Sprites(backDefault = "https://archives.bulbagarden.net/media/upload/thumb/6/6b/0003Venusaur.png/250px-0003Venusaur.png")
            ),
            Pokemon(
                id = "4",
                name = "Charmander",
                sprites = Sprites(backDefault = "https://archives.bulbagarden.net/media/upload/thumb/2/27/0004Charmander.png/250px-0004Charmander.png")
            ),
            Pokemon(
                id = "5",
                name = "Charmeleon",
                sprites = Sprites(backDefault = "https://archives.bulbagarden.net/media/upload/thumb/0/05/0005Charmeleon.png/250px-0005Charmeleon.png")
            )
        )
    }
    fun getPokemon(id:String): Pokemon?{
        val pokemons:List<Pokemon> = getPokemons()
        for (pokemon in pokemons){
            if (pokemon.id==id){
                return pokemon
            }
        }
        return null
    }
}