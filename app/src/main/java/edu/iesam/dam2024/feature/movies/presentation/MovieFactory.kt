package edu.iesam.dam2024.feature.movies.presentation

import android.content.Context
import edu.iesam.dam2024.feature.movies.data.MovieDataRepository
import edu.iesam.dam2024.feature.movies.data.local.MovieXmlLocalDataSource
import edu.iesam.dam2024.feature.movies.data.remote.MovieMockRemoteDataSource
import edu.iesam.dam2024.feature.movies.domain.GetMovieUseCase
import edu.iesam.dam2024.feature.movies.domain.GetMoviesUseCase

class MovieFactory(private val context: Context) {

    private val movieMockRemote = MovieMockRemoteDataSource()
    private val movieLocal = MovieXmlLocalDataSource(context)
    private val movieDataRepository = MovieDataRepository( movieMockRemote,movieLocal)
    private val getMoviesUseCase = GetMoviesUseCase(movieDataRepository)
    private val getMovieUseCase = GetMovieUseCase(movieDataRepository)

    fun buildViewModel(): MoviesViewModel {
        return MoviesViewModel(getMoviesUseCase)
    }
    fun buildMovieDatailViewModel(): MovieDetailViewModel{
        return MovieDetailViewModel(getMovieUseCase)
    }
}