package edu.iesam.dam2024.feature.movies.presentation

import edu.iesam.dam2024.feature.movies.data.MovieDataRepository
import edu.iesam.dam2024.feature.movies.data.remote.MovieMockRemoteDataSource
import edu.iesam.dam2024.feature.movies.domain.GetMovieUseCase
import edu.iesam.dam2024.feature.movies.domain.GetMoviesUseCase

class MovieFactory {
    private val movieRepository : MovieDataRepository =MovieDataRepository(MovieMockRemoteDataSource())
    fun buildViewModel(): MovieViewModel{
        return MovieViewModel(
            GetMoviesUseCase(movieRepository),
            GetMovieUseCase(movieRepository)
        )
    }
}