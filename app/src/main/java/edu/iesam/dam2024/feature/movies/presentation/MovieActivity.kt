package edu.iesam.dam2024.feature.movies.presentation

import android.os.Bundle
import android.util.Log
import android.widget.LinearLayout
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import edu.iesam.dam2024.R
import edu.iesam.dam2024.feature.movies.data.MovieDataRepository
import edu.iesam.dam2024.feature.movies.data.remote.MovieMockRemoteDataSource
import edu.iesam.dam2024.feature.movies.domain.GetMoviesUseCase
import edu.iesam.dam2024.feature.movies.domain.Movie

class MovieActivity : AppCompatActivity() {

    private val movieFactory : MovieFactory = MovieFactory()
    val viewModel = movieFactory.buildViewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val viewModel = movieFactory.buildViewModel()
        val movies = viewModel.viewCreated()
        bindData(movies)
        //Log.d("@dev", "Hi!!")
       //Log.d("@dev", movies.toString())
        //val movie=viewModel.itemSelected("3")
        //Log.d("@dev", movie.toString())

    }
private fun bindData(movies:List<Movie>){
    findViewById<TextView>(R.id.movie_id_1).text = movies[0].id
    findViewById<TextView>(R.id.movie_title_1).text = movies[0].title
    findViewById<LinearLayout>(R.id.layout_1).setOnClickListener{
        val movie1: Movie? =viewModel.itemSelected(movies[0].id)
        movie1?.let {
            Log.d("@dev","Pelicula seleccionada: ${it.title}" )//imprime solo el titulo
                                // y se usa it para confirmar que es el objeto pasado por el filtro
        }
    }

    findViewById<TextView>(R.id.movie_id_2).text = movies[1].id
    findViewById<TextView>(R.id.movie_title_2).text = movies[1].title
    findViewById<LinearLayout>(R.id.layout_2).setOnClickListener{
        Log.d("@dev",viewModel.itemSelected("2").toString())
    }

    findViewById<TextView>(R.id.movie_id_3).text = movies[2].id
    findViewById<TextView>(R.id.movie_title_3).text = movies[2].title
    findViewById<LinearLayout>(R.id.layout_3).setOnClickListener{
        Log.d("@dev",viewModel.itemSelected("3").toString())
    }

    findViewById<TextView>(R.id.movie_id_4).text = movies[3].id
    findViewById<TextView>(R.id.movie_title_4).text = movies[3].title
    findViewById<LinearLayout>(R.id.layout_4).setOnClickListener{
        Log.d("@dev",viewModel.itemSelected("4").toString())
    }
}
    fun viewMovie(){
        TODO()
    }
}
