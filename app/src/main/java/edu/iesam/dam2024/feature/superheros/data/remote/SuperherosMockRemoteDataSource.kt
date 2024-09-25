package edu.iesam.dam2024.feature.superheros.data.remote


import edu.iesam.dam2024.feature.superheros.domain.Appearance
import edu.iesam.dam2024.feature.superheros.domain.Biography
import edu.iesam.dam2024.feature.superheros.domain.Connections
import edu.iesam.dam2024.feature.superheros.domain.Images
import edu.iesam.dam2024.feature.superheros.domain.Powerstats
import edu.iesam.dam2024.feature.superheros.domain.Superhero
import edu.iesam.dam2024.feature.superheros.domain.Work


class SuperherosMockRemoteDataSource {
    fun getSuperheros(): List<Superhero>{
        return listOf(
            Superhero(
                id = "1",
                name = "Superman",
                slug = "2-superman",
                powerstats = Powerstats(
                    intelligence = "94",
                    strength = "100",
                    speed = "100",
                    durability = "100",
                    power = "100",
                    combat = "85"
                ),
                appearance = Appearance(
                    gender = "Male",
                    race = "Kryptonian",
                    height = listOf("6'3", "191 cm"),
                    weight = listOf("235 lb", "107 kg"),
                    eyeColor = "Blue",
                    hairColor = "Black"
                ),
                biography = Biography(
                    fullName = "Clark Kent",
                    alterEgos = "No alter egos found.",
                    aliases = listOf("Kal-El", "Man of Steel"),
                    placeOfBirth = "Krypton",
                    firstAppearance = "Action Comics #1",
                    publisher = "DC Comics",
                    alignment = "good"
                ),
                work = Work(
                    occupation = "Reporter",
                    base = "Metropolis"
                ),
                connections = Connections(
                    groupAffiliation = "Justice League",
                    relatives = "Lois Lane (wife), Jonathan Kent (adoptive father), Martha Kent (adoptive mother)"
                ),
                images = Images(
                    xs = "https://example.com/superman-xs.jpg",
                    sm = "https://example.com/superman-sm.jpg",
                    md = "https://example.com/superman-md.jpg",
                    lg = "https://example.com/superman-lg.jpg"
                )
            ),
            Superhero(
                id = "2",
                name = "Wonder Woman",
                slug = "3-wonder-woman",
                powerstats = Powerstats(
                    intelligence = "88",
                    strength = "100",
                    speed = "79",
                    durability = "100",
                    power = "100",
                    combat = "100"
                ),
                appearance = Appearance(
                    gender = "Female",
                    race = "Amazon",
                    height = listOf("6'0", "183 cm"),
                    weight = listOf("165 lb", "75 kg"),
                    eyeColor = "Blue",
                    hairColor = "Black"
                ),
                biography = Biography(
                    fullName = "Diana Prince",
                    alterEgos = "No alter egos found.",
                    aliases = listOf("Princess Diana"),
                    placeOfBirth = "Themyscira",
                    firstAppearance = "All Star Comics #8",
                    publisher = "DC Comics",
                    alignment = "good"
                ),
                work = Work(
                    occupation = "Warrior, Ambassador",
                    base = "Themyscira"
                ),
                connections = Connections(
                    groupAffiliation = "Justice League",
                    relatives = "Hippolyta (mother), Zeus (father)"
                ),
                images = Images(
                    xs = "https://example.com/wonderwoman-xs.jpg",
                    sm = "https://example.com/wonderwoman-sm.jpg",
                    md = "https://example.com/wonderwoman-md.jpg",
                    lg = "https://example.com/wonderwoman-lg.jpg"
                )
            ),
            Superhero(
                id = "3",
                name = "Spider-Man",
                slug = "4-spider-man",
                powerstats = Powerstats(
                    intelligence = "90",
                    strength = "55",
                    speed = "67",
                    durability = "75",
                    power = "74",
                    combat = "85"
                ),
                appearance = Appearance(
                    gender = "Male",
                    race = "Human",
                    height = listOf("5'10", "178 cm"),
                    weight = listOf("167 lb", "76 kg"),
                    eyeColor = "Hazel",
                    hairColor = "Brown"
                ),
                biography = Biography(
                    fullName = "Peter Parker",
                    alterEgos = "No alter egos found.",
                    aliases = listOf("Spidey", "Web-Slinger", "Friendly Neighborhood Spider-Man"),
                    placeOfBirth = "New York, New York",
                    firstAppearance = "Amazing Fantasy #15",
                    publisher = "Marvel Comics",
                    alignment = "good"
                ),
                work = Work(
                    occupation = "Photographer, Superhero",
                    base = "New York City"
                ),
                connections = Connections(
                    groupAffiliation = "Avengers, formerly Fantastic Four, Secret Avengers",
                    relatives = "Richard Parker (father, deceased), Mary Parker (mother, deceased), Ben Parker (uncle, deceased), May Parker (aunt)"
                ),
                images = Images(
                    xs = "https://example.com/spiderman-xs.jpg",
                    sm = "https://example.com/spiderman-sm.jpg",
                    md = "https://example.com/spiderman-md.jpg",
                    lg = "https://example.com/spiderman-lg.jpg"
                )
            )
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