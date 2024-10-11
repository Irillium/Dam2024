package edu.iesam.dam2024.feature.superheros.presentation

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.LinearLayout
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
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


        setubObserver()
        viewModel.viewCreated()


    }

    private fun setubObserver() {
        val movieObserver = Observer<SuperherosViewModel.UiState> { uiState ->

            uiState.superheros?.let {
                bindData(it)
            }
            uiState.errorApp?.let {
                //pinto error
            }
            if (uiState.isLoading) {
                Log.d("@dev", "muestro el cargado...")
            } else {
                Log.d("@dev", "oculto el cargado...")
            }

        }
        viewModel.uiState.observe(this, movieObserver)

    }

    private fun bindData(heroes:List<Superhero>){
        blockHero(heroes[0], R.id.hero_id_1,R.id.hero_name_1,R.id.hero_layout_1)
        blockHero(heroes[1], R.id.hero_id_2,R.id.hero_name_2,R.id.hero_layout_2)
        blockHero(heroes[2], R.id.hero_id_3,R.id.hero_name_3,R.id.hero_layout_3)
        var goHero:String= getString(R.string.goMovies)
        findViewById<TextView>(R.id.goMovies).text= goHero
        findViewById<LinearLayout>(R.id.hero_layout_4).setOnClickListener {
           navigateToMoviesList()
        }
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