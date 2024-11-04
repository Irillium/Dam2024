package edu.iesam.dam2024.feature.superheros.data.remote

import edu.iesam.dam2024.app.data.ApiClient
import edu.iesam.dam2024.app.data.ApiService
import edu.iesam.dam2024.feature.superheros.domain.Superhero

class SuperheroAPIDataSource : RemoteDataSource{

    private val apiService = ApiClient().apiService

    override suspend fun getSuperheros(): List<Superhero> {
        val response = apiService.requestSuperHeroes()
        if (response.isSuccessful){
            return response.body()!!.map {
                it.toModel()
            }
        } else {
            //Hay un error
            return emptyList()
        }
    }

    override  fun  getSuperhero(id: String): Superhero? {
        return null
    }


}