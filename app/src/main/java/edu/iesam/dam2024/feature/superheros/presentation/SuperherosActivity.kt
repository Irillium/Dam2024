package edu.iesam.dam2024.feature.superheros.presentation

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import edu.iesam.dam2024.R

class SuperherosActivity : AppCompatActivity() {
    private val superheroFactory : SuperheroFactory= SuperheroFactory()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val viewModel = superheroFactory.buildViewModel()
        val superheros = viewModel.viewCreated()
        Log.d("@hero",superheros.toString() )
    }
}