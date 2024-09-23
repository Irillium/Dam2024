package edu.iesam.dam2024.feature.superheros.presentation

import edu.iesam.dam2024.feature.superheros.data.SuperherosDataRepository
import edu.iesam.dam2024.feature.superheros.data.remote.SuperherosMockRemoteDataSource
import edu.iesam.dam2024.feature.superheros.domain.GetSuperherosUseCase

class SuperheroFactory {
    fun buildViewModel(): SuperherosViewModel{
        return SuperherosViewModel(GetSuperherosUseCase(SuperherosDataRepository(SuperherosMockRemoteDataSource())))
    }
}
