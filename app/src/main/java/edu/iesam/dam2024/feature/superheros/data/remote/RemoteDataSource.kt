package edu.iesam.dam2024.feature.superheros.data.remote

import edu.iesam.dam2024.feature.superheros.domain.Superhero

interface RemoteDataSource {
    suspend fun getSuperheros():List<Superhero>
     fun getSuperhero(id:String):Superhero?
}