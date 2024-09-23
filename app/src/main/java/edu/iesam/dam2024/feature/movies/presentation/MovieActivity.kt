package edu.iesam.dam2024.feature.movies.presentation

import android.os.Bundle
import android.util.Log
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import edu.iesam.dam2024.R
import edu.iesam.dam2024.feature.movies.data.MovieDataRepository
import edu.iesam.dam2024.feature.movies.data.remote.MovieMockRemoteDataSource
import edu.iesam.dam2024.feature.movies.domain.GetMoviesUseCase

class MovieActivity : AppCompatActivity() {

    private val movieFactory : MovieFactory = MovieFactory()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val viewModel = movieFactory.buildViewModel()
        val movies = viewModel.viewCreated()
        Log.d("@dev", "Hi!!")
        Log.d("@dev", movies.toString())
    }

}

//Log.d("MainActivity", "Mensaje para el Logcat")
//Log.d("MainActivity", "NIANIA")