package edu.iesam.dam2024.feature.superheros.data


import edu.iesam.dam2024.feature.superheros.data.local.SuperheroXmlLocalDataSource
import edu.iesam.dam2024.feature.superheros.data.remote.SuperheroAPIDataSource
import edu.iesam.dam2024.feature.superheros.domain.Superhero
import edu.iesam.dam2024.feature.superheros.domain.SuperheroRepository

class SuperherosDataRepository (
    private val remote: SuperheroAPIDataSource,
    private val local: SuperheroXmlLocalDataSource) : SuperheroRepository{

    override suspend fun getSuperheros(): List<Superhero>{
        val superherosFromLocal = local.findAll()
        if (superherosFromLocal.isEmpty()){
            val superheroFromRemote = remote.getSuperheros()
            local.saveAll(superheroFromRemote)
            return superheroFromRemote
        }
        return superherosFromLocal
    }

    override fun getSuperhero(id: String): Superhero? {
        val localSuperhero = local.findById(id)
        if (localSuperhero == null){
          remote.getSuperhero(id)?.let {
              local.save(it)
              return it
          }
        }
        return localSuperhero
    }
}