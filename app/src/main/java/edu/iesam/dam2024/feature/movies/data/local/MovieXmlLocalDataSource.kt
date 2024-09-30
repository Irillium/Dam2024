package edu.iesam.dam2024.feature.movies.data.local

import android.content.Context
import com.google.gson.Gson
import edu.iesam.dam2024.feature.movies.domain.Movie

class MovieXmlLocalDataSource (private val context: Context){
    private val sharedPref = context.getSharedPreferences(
        "movies", Context.MODE_PRIVATE )//MODE_PRIVATE significa que tiene poco privado, opsea que no es accesible
    private val gson=Gson()
    fun save(movie:Movie){
       sharedPref.edit().apply{
            putString(movie.id,gson.toJson(movie))
            apply()
        }


    }

    fun saveAll(movies: List<Movie>){
       sharedPref.edit().apply {
            movies.forEach{ movie ->
               putString(movie.id,gson.toJson(movie))
            }
            apply()
        }

    }
    fun find(id: String) : Movie?{
        val mapMovies = sharedPref.all //as Map< String, String>
        mapMovies.values.forEach{jsonMovie ->
            val movie= gson.fromJson(jsonMovie as String, Movie::class.java)
            if (movie.id == id){
                return movie
            }
        }
        return null
        /*sharedPref.apply {
            return  Movie(
                getString("id","")!!,
                getString("title","")!!,
                getString("poster","")!!)//!! es forzar que lo use a riesgo de que sea nulo
        }*/
    }
    fun findAll():List<Movie>{
        val movies= ArrayList<Movie>()
        val mapMovies = sharedPref.all //as Map< String, String>
        mapMovies.values.forEach{jsonMovie ->
            val movie= gson.fromJson(jsonMovie as String, Movie::class.java)
            movies.add(movie)
        }
        return movies
    }
    fun delete(){
        sharedPref.edit().clear().apply()
    }
}