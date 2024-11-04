package edu.iesam.dam2024.feature.superheros.data.remote

import edu.iesam.dam2024.feature.superheros.domain.Superhero
//clase funcion extension
fun SuperheroApiModel.toModel(): Superhero{
    return Superhero(
        this.id,
        this.name,
        this.urlImage.md
    )
}