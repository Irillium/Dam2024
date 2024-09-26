package edu.iesam.dam2024.feature.movies.presentation

import android.os.Bundle
import android.util.Log
import android.widget.LinearLayout
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import edu.iesam.dam2024.R
import edu.iesam.dam2024.feature.movies.data.local.MovieXmlLocalDataSource
import edu.iesam.dam2024.feature.movies.domain.Movie

class MovieActivity : AppCompatActivity() { //MoviActivity hereda de Context

    private val movieFactory : MovieFactory = MovieFactory()
    private val viewModel = movieFactory.buildViewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val movies = viewModel.viewCreated()
        bindData(movies)
        textXml()
    }
    private fun bindData(movies:List<Movie>){

        blockMovie(movies[0],R.id.movie_id_1,R.id.movie_title_1,R.id.movie_layout_1)
        blockMovie(movies[1],R.id.movie_id_2,R.id.movie_title_2,R.id.movie_layout_2)
        blockMovie(movies[2],R.id.movie_id_3,R.id.movie_title_3,R.id.movie_layout_3)
        blockMovie(movies[3],R.id.movie_id_4,R.id.movie_title_4,R.id.movie_layout_4)

    }
    private fun blockMovie(movie:Movie, nId:Int, nTitle:Int, nLayout:Int ){
        findViewById<TextView>(nId).text = movie.id
        findViewById<TextView>(nTitle).text = movie.title
        findViewById<LinearLayout>(nLayout).setOnClickListener{
            val movie1: Movie? =viewModel.itemSelected(movie.id)
            movie1?.let {
                Log.d("@dev","Pelicula seleccionada: ${it.title}" )//imprime solo el titulo
                // y se usa it para confirmar que es el objeto pasado por el filtro
            } ?: Log.d("@dev","Pelicula no encontrada")
        }
    }

    private fun textXml(){
        val xmlDataSource = MovieXmlLocalDataSource(this) //this se refiere a MovieActivity
        val movie=viewModel.itemSelected("1")
        movie?.let {
            xmlDataSource.save(it)
        }
        val movieSaved = xmlDataSource.findMovie()
        Log.d("@dev",movieSaved.toString())
    }
}
