package edu.iesam.dam2024.feature.superheros.data.remote

data class SuperheroApiModel(val id:String,val name:String,val urlImage:SuperheroImageApiModel)
data class SuperheroImageApiModel(val md:String)