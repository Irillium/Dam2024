package edu.iesam.dam2024.feature.movies.data.local

import android.content.Context
import edu.iesam.dam2024.R
import edu.iesam.dam2024.feature.movies.domain.Movie

class MovieXmlLocalDataSource (private val context: Context){
    private val sharedPref = context.getSharedPreferences(
        context.getString(R.string.name_file_xml), Context.MODE_PRIVATE )//MODE_PRIVATE significa que tiene poco privado, opsea que no es accesible
        fun save(movie:Movie){
            val editor = sharedPref.edit()
            editor.putString("id",movie.id)
            editor.putString("title",movie.title)
            editor.putString("poster",movie.poster)
            editor.apply()
        }
    fun findMovie() : Movie{
        val id = sharedPref.getString("id","")//el segundo valor es lo que se devuelve si no se encuentra valor
        val title = sharedPref.getString("title","")
        val poster = sharedPref.getString("poster","")
        return  Movie(id!!,title!!,poster!!)//!! es forzar que lo use a riesgo de que sea nulo
    }
}