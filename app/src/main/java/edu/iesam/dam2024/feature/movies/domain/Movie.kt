package edu.iesam.dam2024.feature.movies.domain
// si usamos anotaciones como @Inject
// tendremos que aclarar que el () es un constructor
data class Movie (val id: String, val title: String, val poster: String)