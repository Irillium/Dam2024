package edu.iesam.dam2024.feature.superheros.data.remote

import edu.iesam.dam2024.app.data.ApiClient
import edu.iesam.dam2024.app.data.ApiService
import edu.iesam.dam2024.feature.superheros.domain.Superhero

class SuperheroAPIDataSource : RemoteDataSource{

    private val apiService = ApiClient().apiService

    override suspend fun getSuperheros(): List<Superhero> {
        return try{
            apiService.getSuperheroes()
        }catch (e: Exception){
            emptyList()
        }
    }

    override  fun  getSuperhero(id: String): Superhero? {
        return null
    }


}