package edu.iesam.dam2024.feature.movies.domain

class GetMovieUseCase(private val movieRepository: MovieRepository) {
    operator fun invoke(id:String):Movie{
        return movieRepository.getMovie(id)
    }
}