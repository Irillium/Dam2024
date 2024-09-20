package edu.iesam.dam2024.feature.movies.data.remote

import edu.iesam.dam2024.feature.movies.domain.Movie

/*
* Naming: Modelo + Tecnologia + RemoteDataSource
*
*/
class MovieMockRemoteDataSource {
    fun getMovies(): List<Movie>{
        return listOf(
            Movie("1","title1","poster1"),
            Movie("2","title2","poster2"),
            Movie("3","title3","poster3"),
            // se puede desordenar la ingresion de datos aclarandolo de esta manera
            Movie(title = "title4", id = "4", poster = "poster4")
        )
    }
}