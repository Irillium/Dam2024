package edu.iesam.dam2024.feature.movies.data.remote

import edu.iesam.dam2024.feature.movies.domain.Movie

/*
* Naming: Modelo + Tecnologia + RemoteDataSource
*
*/
class MovieMockRemoteDataSource {
    fun getMovies(): List<Movie>{
        return listOf(
            Movie("1","Caroline","https://i.pinimg.com/474x/ff/66/43/ff6643b1f18c4a0dab75620c991f0c01.jpg"),
            Movie("2","Pesadilla antes de navidad","https://pics.filmaffinity.com/the_nightmare_before_christmas-136057718-mmed.jpg"),
            Movie("3","Planeta del tesoro","https://es.web.img3.acsta.net/r_1280_720/medias/nmedia/18/74/26/46/20078415.jpg"),
            // se puede desordenar la ingresion de datos aclarandolo de esta manera
            Movie(title = "DUNE", id = "4", poster = "https://pixeldigitalcinema.com/wp-content/uploads/2021/08/dune-2021-poster.jpg")
        )
    }
    fun getMovie(movieId:String):Movie?{
        val movies:List<Movie> = getMovies()
      for (movie in movies){
          if (movie.id==movieId){
              return movie
          }
      }
        return null
    }
    // Chema lo ha hecho así:
    // fun getMovie(id:String):Movie?{
    // return movies.firstOrNull{movie -> movie.id==id)}
    //}
    // supuestamente el metodo .firstOrNull indica que se devuelve
    // el primero que coincida con la condicion o un nulo en su defecto
}