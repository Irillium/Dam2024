package edu.iesam.dam2024.feature.superheros.domain

class GetSuperheroUseCase(private val superheroRepository: SuperheroRepository) {
    operator suspend fun invoke(idHero:String): Superhero? {
        return superheroRepository.getSuperhero(idHero)
    }
}