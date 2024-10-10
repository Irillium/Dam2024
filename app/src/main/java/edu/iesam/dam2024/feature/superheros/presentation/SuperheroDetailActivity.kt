package edu.iesam.dam2024.feature.superheros.presentation

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import edu.iesam.dam2024.R
import edu.iesam.dam2024.app.extensions.loadUrl
import edu.iesam.dam2024.feature.superheros.domain.Superhero

class SuperheroDetailActivity : AppCompatActivity() {

    private lateinit var superheroFactory: SuperheroFactory
    private lateinit var viewModel: SuperheroDetailViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_superhero_detail)

        superheroFactory=SuperheroFactory(this)
        viewModel= superheroFactory.buildSuperheroDetailViewModel()

        setubObserver()
        getHeroId()?.let {
            viewModel.itemSelected(it)
        }
    }


    private fun setubObserver() {
        val movieObserver = Observer<SuperheroDetailViewModel.UiState> { uiState ->

            uiState.superhero?.let {
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



    private fun getHeroId(): String?{
        return intent.getStringExtra(KEY_HERO_ID)
    }
    private fun bindData(hero:Superhero){

    }
    companion object{
        val KEY_HERO_ID = "key_hero_id"
        fun getIntent(context: Context, id:String): Intent{
            val intent = Intent(context, SuperheroDetailActivity::class.java)
            intent.putExtra(KEY_HERO_ID,id)
            return intent
        }
    }
}