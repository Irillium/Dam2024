package edu.iesam.dam2024.feature.movies.data

import edu.iesam.dam2024.feature.movies.data.local.MovieXmlLocalDataSource
import edu.iesam.dam2024.feature.movies.data.remote.MovieMockRemoteDataSource
import edu.iesam.dam2024.feature.movies.domain.Movie
import edu.iesam.dam2024.feature.movies.domain.MovieRepository
import org.koin.core.annotation.Single

/*
* Naming: Modelo + DataRepository
* */
@Single
class MovieDataRepository (
    private  val mockRemoteDataSource: MovieMockRemoteDataSource,
    private val local: MovieXmlLocalDataSource) : MovieRepository{
    override fun getMovies(): List<Movie>{
        val moviesFromLocal = local.findAll()
        if (moviesFromLocal.isEmpty()){
            val moviesFromRemote = mockRemoteDataSource.getMovies()
            local.saveAll(moviesFromRemote)
            return moviesFromRemote
        }
        return moviesFromLocal
    }

    override fun getMovie(movieId: String): Movie? {
        val localMovie = local.findById(movieId)
        if (localMovie == null){
            mockRemoteDataSource.getMovie(movieId)?.let {
                local.save(it)
                return it
            }
        }
        return localMovie
    }
}