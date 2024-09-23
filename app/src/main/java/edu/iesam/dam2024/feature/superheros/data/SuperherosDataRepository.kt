package edu.iesam.dam2024.feature.superheros.data

import edu.iesam.dam2024.feature.superheros.data.remote.SuperherosMockRemoteDataSource
import edu.iesam.dam2024.feature.superheros.domain.Superhero
import edu.iesam.dam2024.feature.superheros.domain.SuperheroRepository

class SuperherosDataRepository (private val mockRemoteDataSource : SuperherosMockRemoteDataSource) : SuperheroRepository{

    override fun getSuperheros(): List<Superhero> {
      return mockRemoteDataSource.getSuperheros()
    }
}