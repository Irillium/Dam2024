package edu.iesam.dam2024.feature.superheros.data.remote


import edu.iesam.dam2024.feature.superheros.domain.Superhero



class SuperherosMockRemoteDataSource {
    fun getSuperheros(): List<Superhero>{
        return listOf(
            Superhero(
                id = "1",
                name = "Superman"),
            Superhero(
                id = "2",
                name = "Wonder Woman"),
            Superhero(
                id = "3",
                name = "Spider-Man")
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