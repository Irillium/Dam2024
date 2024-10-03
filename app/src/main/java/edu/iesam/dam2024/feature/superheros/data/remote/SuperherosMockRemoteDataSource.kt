package edu.iesam.dam2024.feature.superheros.data.remote


import edu.iesam.dam2024.feature.superheros.domain.Superhero



class SuperherosMockRemoteDataSource {
    fun getSuperheros(): List<Superhero>{
        return listOf(
            Superhero(
                 "1",
                 "Superman",
              "https://img.posterstore.com/zoom/wb0057-8superman-cartoon50x70.jpg"),
            Superhero(
                "2",
                "Wonder Woman",
                "https://static.wikia.nocookie.net/personajes-de-ficcion-database/images/d/dc/Wonder_Woman_render.png/revision/latest?cb=20201112215419&path-prefix=es"),
            Superhero(
                "3",
                "Spider-Man",
                "https://m.media-amazon.com/images/I/71+2s0BFlKL._AC_UF894,1000_QL80_.jpg")
        )
    }
    fun getSuperhero(idHero:String) : Superhero?{
        val movies:List<Superhero> = getSuperheros()
        for (movie in movies){
            if (movie.id==idHero){
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