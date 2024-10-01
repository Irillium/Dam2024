package edu.iesam.dam2024.feature.movies.presentation

import android.os.Bundle
import android.util.Log
import android.widget.LinearLayout
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import edu.iesam.dam2024.R
import edu.iesam.dam2024.feature.movies.data.local.MovieXmlLocalDataSource
import edu.iesam.dam2024.feature.movies.domain.Movie

class MovieActivity : AppCompatActivity() {

    private lateinit var movieFactory: MovieFactory
    private lateinit var viewModel : MovieViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        movieFactory = MovieFactory(this)
        viewModel = movieFactory.buildViewModel()

        //val movies = viewModel.viewCreated()
        //bindData(movies)
        //viewModel.itemSelected(movies.first().id) //Simular un click sobre un item
        //textXml()
        //testListXml()
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
        val movies: List<Movie> = listOf(
            Movie("5", "title_5", "poster_5"),
            Movie("6", "title_6", "poster_6"),
            Movie("7", "title_7", "poster_7"),
            Movie("8", "title_8", "poster_8")
        )
        val movie:Movie= Movie("9", "title_9", "poster_9")
        xmlDataSource.saveAll(movies)
        xmlDataSource.save(movie)
        xmlDataSource.findById("7")
        xmlDataSource.findById("9")
        xmlDataSource.findAll()
        xmlDataSource.deleteById("6")
        xmlDataSource.findAll()
        xmlDataSource.delete()
        xmlDataSource.findAll()

    }
    private fun testListXml(){
        val movies =viewModel.viewCreated()
        val xmlDataSource = MovieXmlLocalDataSource(this)
        xmlDataSource.saveAll(movies)

        val moviesFromXml= xmlDataSource.findAll()
        Log.d("@dev", moviesFromXml.toString())
    }
}
