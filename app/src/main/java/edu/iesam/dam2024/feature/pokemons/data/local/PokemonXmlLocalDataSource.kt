package edu.iesam.dam2024.feature.pokemons.data.local

import android.content.Context
import com.google.gson.Gson
import edu.iesam.dam2024.feature.pokemons.domain.Pokemon

class PokemonXmlLocalDataSource(private val context: Context) {

    private val sharedPref = context.getSharedPreferences(
        "pokemons", Context.MODE_PRIVATE
    )
    private val gson= Gson()


    fun save(pokemon: Pokemon){
        sharedPref.edit().apply {
            putString(pokemon.id,gson.toJson(pokemon))
            apply()
        }
    }
    fun saveAll(pokemons:List<Pokemon>){
        sharedPref.edit().apply {
            pokemons.forEach { pokemon ->
                putString(pokemon.id,gson.toJson(pokemon))
            }
            apply()
        }
    }

    fun findAll():List<Pokemon>{
        val pokemons = ArrayList<Pokemon>()
        val mapPokemos = sharedPref.all
        mapPokemos.values.forEach{jsonPokemon ->
        val pokemon = gson.fromJson(jsonPokemon as String, Pokemon::class.java)
        pokemons.add(pokemon)
        }
        return pokemons
    }
    fun findById(id:String): Pokemon?{
        return sharedPref.getString(id, null)?.let { pokemon ->
            gson.fromJson(pokemon, Pokemon::class.java)
        }
    }

    fun delete(){
        sharedPref.edit().clear().apply()
    }

    fun deleteById(pokemonId: String){
        sharedPref.edit().remove(pokemonId).commit()
    }
}