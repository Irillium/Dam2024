package edu.iesam.dam2024.feature.superheros.domain

interface SuperheroRepository {
    fun getSuperheros():List<Superhero>
}