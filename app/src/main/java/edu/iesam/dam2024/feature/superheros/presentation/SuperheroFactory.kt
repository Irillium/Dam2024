package edu.iesam.dam2024.feature.superheros.presentation

import android.content.Context
import edu.iesam.dam2024.feature.superheros.data.SuperherosDataRepository
import edu.iesam.dam2024.feature.superheros.data.local.SuperheroXmlLocalDataSource
import edu.iesam.dam2024.feature.superheros.data.remote.SuperherosMockRemoteDataSource
import edu.iesam.dam2024.feature.superheros.domain.GetSuperheroUseCase
import edu.iesam.dam2024.feature.superheros.domain.GetSuperherosUseCase

class SuperheroFactory ( private val context:Context){
    private val superheroMockRemote = SuperherosMockRemoteDataSource()
    private val superheroLocal = SuperheroXmlLocalDataSource(context)
    private val heroRepository = SuperherosDataRepository(superheroMockRemote,superheroLocal)
    private val getSuperheroUseCase = GetSuperheroUseCase(heroRepository)
    private val getSuperherosUseCase = GetSuperherosUseCase(heroRepository)
    fun buildViewModel(): SuperherosViewModel{
        return SuperherosViewModel(getSuperherosUseCase)
    }
    fun buildSuperheroDetailViewModel() : SuperheroDetailViewModel{
        return SuperheroDetailViewModel(getSuperheroUseCase)
    }
}
