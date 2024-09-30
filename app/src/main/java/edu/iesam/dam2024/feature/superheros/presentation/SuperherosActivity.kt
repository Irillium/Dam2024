package edu.iesam.dam2024.feature.superheros.presentation

import android.os.Bundle
import android.util.Log
import android.widget.LinearLayout
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import edu.iesam.dam2024.R
import edu.iesam.dam2024.feature.movies.presentation.MovieFactory
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
        bindData(superheros)

    }

    private fun bindData(heroes:List<Superhero>){
        blockHero(heroes[0], R.id.hero_id_1,R.id.hero_name_1,R.id.hero_layout_1)
        blockHero(heroes[1], R.id.hero_id_2,R.id.hero_name_2,R.id.hero_layout_2)
        blockHero(heroes[2], R.id.hero_id_3,R.id.hero_name_3,R.id.hero_layout_3)
    }
    private fun blockHero(heroes:Superhero,nId:Int, nName:Int, nLayout:Int ){
        findViewById<TextView>(nId).text =heroes.id
        findViewById<TextView>(nName).text = heroes.name
        findViewById<LinearLayout>(nLayout).setOnClickListener{
            val hero1:Superhero?=viewModel.itemSelected(heroes.id)
            hero1?.let {
                Log.d("@hero", "Superheroe seleccionado: ${it.name}")
            }
        }
    }
}