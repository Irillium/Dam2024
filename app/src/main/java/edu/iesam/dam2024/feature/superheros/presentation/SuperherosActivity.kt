package edu.iesam.dam2024.feature.superheros.presentation

import android.content.Context
import android.content.Intent
import android.os.Bundle

import android.widget.LinearLayout
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import edu.iesam.dam2024.R
import edu.iesam.dam2024.feature.movies.presentation.MoviesActivity
import edu.iesam.dam2024.feature.superheros.domain.Superhero

class SuperherosActivity : AppCompatActivity() {

    private lateinit var superheroFactory : SuperheroFactory
    private lateinit var viewModel: SuperherosViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_superheroes)//esto se cambia segun la pantalla que se desea mostrar

        superheroFactory = SuperheroFactory(this)
        viewModel = superheroFactory.buildViewModel()


        val superheros = viewModel.viewCreated()

    }


    private fun blockHero(hero:Superhero,nId:Int, nName:Int, nLayout:Int ){
        findViewById<TextView>(nId).text =hero.id
        findViewById<TextView>(nName).text = hero.name
        findViewById<LinearLayout>(nLayout).setOnClickListener{
            navigateToSuperheroDetail(hero.id)
        }
    }
    private fun navigateToSuperheroDetail(id:String){
        startActivity(SuperheroDetailActivity.getIntent(this,id))
    }
    private fun navigateToMoviesList() {
        startActivity(MoviesActivity.getIntent(this))
    }

    companion object {
        fun getIntent(context: Context): Intent {
            val intent = Intent(context, SuperherosActivity::class.java)
            return intent
        }
    }
}