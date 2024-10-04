package edu.iesam.dam2024.feature.movies.presentation

import androidx.lifecycle.ViewModel
import edu.iesam.dam2024.feature.movies.domain.GetMovieUseCase
import edu.iesam.dam2024.feature.movies.domain.Movie

class MovieDetailViewModel (private val getMovieUseCase : GetMovieUseCase) : ViewModel() {
    fun itemSelected(id:String): Movie? {
        return getMovieUseCase.invoke(id)
    }

}