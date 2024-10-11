package edu.iesam.dam2024.feature.superheros.domain


class GetSuperherosUseCase(private val superheroRepository: SuperheroRepository) {
    suspend operator fun invoke(): List<Superhero> {
        return superheroRepository.getSuperheros()
    }

}