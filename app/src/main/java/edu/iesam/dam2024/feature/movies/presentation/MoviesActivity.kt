package edu.iesam.dam2024.feature.movies.presentation


import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.LinearLayout
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import edu.iesam.dam2024.R
import edu.iesam.dam2024.app.domain.ErrorApp
import edu.iesam.dam2024.feature.movies.domain.Movie
import edu.iesam.dam2024.feature.superheros.presentation.SuperherosActivity

class MoviesActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_movies)


    }


    private fun funshowError(error: ErrorApp) {
        when (error) {
            ErrorApp.DataErrorApp -> TODO()
            ErrorApp.InternetErrorApp -> TODO()
            ErrorApp.ServerErrorApp -> TODO()
            ErrorApp.UnknowErrorApp -> TODO()
        }
    }



    companion object {
        fun getIntent(context: Context): Intent {
            val intent = Intent(context, MoviesActivity::class.java)
            return intent
        }
    }
}
