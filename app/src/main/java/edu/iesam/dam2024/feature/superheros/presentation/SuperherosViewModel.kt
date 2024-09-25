package edu.iesam.dam2024.feature.superheros.presentation

import androidx.lifecycle.ViewModel
import edu.iesam.dam2024.feature.superheros.domain.GetSuperheroUseCase
import edu.iesam.dam2024.feature.superheros.domain.GetSuperherosUseCase
import edu.iesam.dam2024.feature.superheros.domain.Superhero

class SuperherosViewModel (private val getSuperherosUseCase: GetSuperherosUseCase, private val getSuperheroUseCase: GetSuperheroUseCase) : ViewModel() {
    fun  viewCreated(): List<Superhero>{
        return getSuperherosUseCase.invoke()
    }
    fun itemSelected(idHero:String):Superhero?{
        return getSuperheroUseCase.invoke(idHero)
    }
}