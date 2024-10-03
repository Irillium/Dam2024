package edu.iesam.dam2024.feature.superheros.presentation

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
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

        getHeroId()?.let { heroId->
            viewModel.itemSelected(heroId)?.let { hero->
                bindData(hero)
            }
        }
    }
    private fun getHeroId(): String?{
        return intent.getStringExtra(KEY_HERO_ID)
    }
    private fun bindData(hero:Superhero){
        val imageView = findViewById<ImageView>(R.id.imageHero)
        imageView.loadUrl(hero.image)
        findViewById<TextView>(R.id.nameHeroDetail).text= hero.name
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