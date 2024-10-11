package edu.iesam.dam2024.app.data

import edu.iesam.dam2024.feature.superheros.domain.Superhero
import retrofit2.http.GET

interface ApiService {
    @GET("all.json")
    suspend fun getSuperheroes(): List<Superhero>
}