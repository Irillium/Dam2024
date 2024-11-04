package edu.iesam.dam2024.feature.movies.domain

import org.koin.core.annotation.Single

/*
    Naming: Verbo(accion)+ modelo + UseCase

 */
@Single
class GetMoviesUseCase (private val movieRepository: MovieRepository) {

    operator fun invoke(): List<Movie> {
        return movieRepository.getMovies()
    }

}