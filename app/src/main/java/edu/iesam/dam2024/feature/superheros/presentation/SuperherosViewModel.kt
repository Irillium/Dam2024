package edu.iesam.dam2024.feature.superheros.presentation

import androidx.lifecycle.ViewModel
import edu.iesam.dam2024.feature.superheros.domain.GetSuperherosUseCase
import edu.iesam.dam2024.feature.superheros.domain.Superhero

class SuperherosViewModel (
    private val getSuperherosUseCase: GetSuperherosUseCase) : ViewModel() {
    suspend fun  viewCreated(): List<Superhero>{
        return getSuperherosUseCase.invoke()
    }

}