package edu.iesam.dam2024.feature.movies.presentation

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import edu.iesam.dam2024.app.domain.ErrorApp
import edu.iesam.dam2024.feature.movies.domain.GetMoviesUseCase
import edu.iesam.dam2024.feature.movies.domain.Movie
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class MoviesViewModel(private val getMoviesUseCase: GetMoviesUseCase):ViewModel() {

    private val _uiStrate= MutableLiveData<UiState>()
    val uiState : LiveData<UiState> = _uiStrate

    fun viewCreated() {
        viewModelScope.launch(Dispatchers.IO) {
            val movies = getMoviesUseCase.invoke()
            //delay(5000)
            //postValue origen: Default, IO, Min destino : Main
            //value origen/destino: Mismo
            _uiStrate.postValue(UiState(movies = movies))
        }
    }
        data class UiState(
            val isLoading: Boolean = false,
            val errorApp: ErrorApp?=null,
            val movies: List<Movie>?= null)
}