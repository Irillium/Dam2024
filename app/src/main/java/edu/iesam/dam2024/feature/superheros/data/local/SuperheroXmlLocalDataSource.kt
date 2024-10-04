package edu.iesam.dam2024.feature.superheros.data.local

import android.content.Context
import com.google.gson.Gson
import edu.iesam.dam2024.feature.superheros.domain.Superhero

class SuperheroXmlLocalDataSource (private val context: Context){
    private val sharedPref = context.getSharedPreferences(
        "superheros", Context.MODE_PRIVATE)
    private val gson= Gson()

    fun save(superhero: Superhero ){
        sharedPref.edit().apply{
            putString(superhero.id,gson.toJson(superhero))
            apply()
        }


    }

    fun saveAll(superheros: List<Superhero>){
        sharedPref.edit().apply {
            superheros.forEach{ superhero ->
                putString(superhero.id,gson.toJson(superhero))
            }
            apply()
        }

    }
    fun findById(id: String) : Superhero?{
        return sharedPref.getString(id, null)?.let { superhero ->
            gson.fromJson(superhero, Superhero::class.java)
        }
    }
    fun findAll():List<Superhero>{
        val superheros= ArrayList<Superhero>()
        val mapSuperheros = sharedPref.all //as Map< String, String>
        mapSuperheros.values.forEach{jsonSuperhero ->
            val superhero= gson.fromJson(jsonSuperhero as String, Superhero::class.java)
            superheros.add(superhero)
        }
        return superheros
    }
    fun delete(){
        sharedPref.edit().clear().apply()
    }
    fun deleteById(heroId: String){
        sharedPref.edit().remove(heroId).commit()
    }
}