package edu.iesam.dam2024.feature.movies.domain

interface MovieRepository {
    fun getMovies() : List<Movie>
    fun getMovie( id:String) : Movie?
}