package edu.iesam.dam2024.feature.superheros.presentation

import androidx.lifecycle.ViewModel
import edu.iesam.dam2024.feature.superheros.domain.GetSuperheroUseCase
import edu.iesam.dam2024.feature.superheros.domain.Superhero

class SuperheroDetailViewModel(private val getSuperheroUseCase: GetSuperheroUseCase) : ViewModel()  {
    fun itemSelected(idHero:String): Superhero?{
        return getSuperheroUseCase.invoke(idHero)
    }
}