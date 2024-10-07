package edu.iesam.dam2024.feature.movies.presentation

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import edu.iesam.dam2024.app.domain.ErrorApp
import edu.iesam.dam2024.feature.movies.domain.GetMovieUseCase
import edu.iesam.dam2024.feature.movies.domain.Movie
import edu.iesam.dam2024.feature.movies.presentation.MoviesViewModel.UiState

import kotlinx.coroutines.*

class MovieDetailViewModel (private val getMovieUseCase : GetMovieUseCase) : ViewModel() {

    private val _uiStrate= MutableLiveData<UiState>()
    val uiState : LiveData<UiState> = _uiStrate

    fun itemSelected(id:String){
        viewModelScope.launch(Dispatchers.IO){
            val movie= getMovieUseCase.invoke(id)
            _uiStrate.postValue(UiState(movie = movie))
        }

    }
data class UiState(
    val isLoading:Boolean=false,
    val errorApp:ErrorApp?=null,
    val movie:Movie?=null
)
}