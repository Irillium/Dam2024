package edu.iesam.dam2024.feature.superheros.presentation

import android.os.Bundle
import android.util.Log
import android.widget.LinearLayout
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import edu.iesam.dam2024.R
import edu.iesam.dam2024.feature.superheros.domain.Superhero

class SuperherosActivity : AppCompatActivity() {
    private val superheroFactory : SuperheroFactory= SuperheroFactory()
    private val viewModel = superheroFactory.buildViewModel()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val superheros = viewModel.viewCreated()
        bindData(superheros)

    }

    private fun bindData(heros:List<Superhero>){
        blockHero(heros[0], R.id.hero_id_1,R.id.hero_name_1,R.id.hero_layout_1)
        blockHero(heros[1], R.id.hero_id_2,R.id.hero_name_2,R.id.hero_layout_2)
        blockHero(heros[2], R.id.hero_id_3,R.id.hero_name_3,R.id.hero_layout_3)
    }
    private fun blockHero(hero:Superhero,nId:Int, nName:Int, nLayout:Int ){
        findViewById<TextView>(nId).text =hero.id
        findViewById<TextView>(nName).text = hero.name
        findViewById<LinearLayout>(nLayout).setOnClickListener{
            val hero1:Superhero?=viewModel.itemSelected(hero.id)
            hero1?.let {
                Log.d("@hero", "Superheroe seleccionado: ${it.name}")
            }
        }
    }
}