package edu.iesam.dam2024.feature.movies.di

import edu.iesam.dam2024.app.data.MovieService
import org.koin.core.annotation.ComponentScan
import org.koin.core.annotation.Module
import org.koin.core.annotation.Single
import retrofit2.Retrofit
import retrofit2.create

@Module
@ComponentScan
class MoviModule {
    @Single
    fun povideMovieService(retrofit: Retrofit)=retrofit.create(MovieService::class.java)
}