package edu.iesam.dam2024.app.data

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class PokemonClient {
    private val BASE_URL = "https://pokeapi.co/api/v2/"

    private val retrofit: Retrofit =
        Retrofit.Builder().baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create()).build()

    val apiService: PokemonService = retrofit.create(PokemonService::class.java)
}