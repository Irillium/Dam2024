package edu.iesam.dam2024.feature.superheros.data


import edu.iesam.dam2024.feature.superheros.data.local.SuperheroXmlLocalDataSource
import edu.iesam.dam2024.feature.superheros.data.remote.SuperherosMockRemoteDataSource
import edu.iesam.dam2024.feature.superheros.domain.Superhero
import edu.iesam.dam2024.feature.superheros.domain.SuperheroRepository

class SuperherosDataRepository (
    private val mockRemoteDataSource : SuperherosMockRemoteDataSource,
    private val local: SuperheroXmlLocalDataSource) : SuperheroRepository{

    override fun getSuperheros(): List<Superhero>{
        val superherosFromLocal = local.findAll()
        if (superherosFromLocal.isEmpty()){
            val superheroFromRemote = mockRemoteDataSource.getSuperheros()
            local.saveAll(superheroFromRemote)
            return superheroFromRemote
        }
        return superherosFromLocal
    }

    override fun getSuperhero(id: String): Superhero? {
        val localSuperhero = local.findById(id)
        if (localSuperhero == null){
          mockRemoteDataSource.getSuperhero(id)?.let {
              local.save(it)
              return it
          }
        }
        return localSuperhero
    }
}