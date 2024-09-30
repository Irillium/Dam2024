package edu.iesam.dam2024.feature.movies.data

import edu.iesam.dam2024.feature.movies.data.local.MovieXmlLocalDataSource
import edu.iesam.dam2024.feature.movies.data.remote.MovieMockRemoteDataSource
import edu.iesam.dam2024.feature.movies.domain.Movie
import edu.iesam.dam2024.feature.movies.domain.MovieRepository

/*
* Naming: Modelo + DataRepository
* */
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
        val localMovie = local.find(movieId)
        if (localMovie == null){
            val remoteMovie = mockRemoteDataSource.getMovie(movieId)
            if (remoteMovie != null) {
                local.save(remoteMovie)
                return remoteMovie
            }
            return null
        }
        return localMovie
    }
}