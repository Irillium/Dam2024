package edu.iesam.dam2024.feature.superheros.presentation

import edu.iesam.dam2024.feature.superheros.data.SuperherosDataRepository
import edu.iesam.dam2024.feature.superheros.data.remote.SuperherosMockRemoteDataSource
import edu.iesam.dam2024.feature.superheros.domain.GetSuperheroUseCase
import edu.iesam.dam2024.feature.superheros.domain.GetSuperherosUseCase
import edu.iesam.dam2024.feature.superheros.domain.SuperheroRepository

class SuperheroFactory {
    private val heroRepository:SuperheroRepository=SuperherosDataRepository(SuperherosMockRemoteDataSource())
    fun buildViewModel(): SuperherosViewModel{
        return SuperherosViewModel(
            GetSuperherosUseCase(heroRepository),
            GetSuperheroUseCase(heroRepository))
    }
}
