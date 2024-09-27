package edu.iesam.dam2024.feature.superheros.data.local

import android.content.Context
import edu.iesam.dam2024.feature.superheros.domain.Superhero

class SuperheroXmlLocalDataSource (private val context: Context){
    private val sharedPref = context.getSharedPreferences(
        "superheros", Context.MODE_PRIVATE)
    fun save(superhero: Superhero){
        sharedPref.edit().apply{
            putString("id", superhero.id)
            putString("name",superhero.name)
            apply()
        }
    }

    fun find(idHero:String):Superhero?{
        sharedPref.apply {
            val id = getString("${idHero}_id", null)
            val name = getString("${idHero}_name", null)

            return if (id != null && name != null) {
                Superhero(id, name)
            } else {
                null
            }
        }
    }

    fun delete(){
        sharedPref.edit().clear().apply()
    }
}