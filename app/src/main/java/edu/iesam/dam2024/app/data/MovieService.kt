package edu.iesam.dam2024.app.data

import edu.iesam.dam2024.feature.movies.domain.Movie
import retrofit2.http.GET

interface MovieService {
    @GET
    fun getMovies():List<Movie>
}