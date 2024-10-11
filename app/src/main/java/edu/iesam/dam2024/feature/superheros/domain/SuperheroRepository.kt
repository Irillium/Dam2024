package edu.iesam.dam2024.feature.superheros.domain

interface SuperheroRepository {
    suspend fun getSuperheros():List<Superhero>
    fun getSuperhero(id:String):Superhero?
}