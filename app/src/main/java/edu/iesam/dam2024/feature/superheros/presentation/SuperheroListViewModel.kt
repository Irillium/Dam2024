package edu.iesam.dam2024.feature.superheros.presentation

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import edu.iesam.dam2024.app.domain.ErrorApp
import edu.iesam.dam2024.feature.superheros.domain.GetSuperherosUseCase
import edu.iesam.dam2024.feature.superheros.domain.Superhero
import kotlinx.coroutines.*

class SuperheroListViewModel(private val getSuperherosUseCase: GetSuperherosUseCase): ViewModel() {

    private val _uiState= MutableLiveData<UiState>()
    val uiState : LiveData<UiState> = _uiState

    fun loadSuperheroes(){
        viewModelScope.launch(Dispatchers.IO){
            _uiState.postValue(UiState(isLoading = true))
            try {
                val  superheroes = getSuperherosUseCase.invoke()
                _uiState.postValue(UiState(
                    isLoading = false,
                    superheroes = superheroes))
            }catch (e:Exception){
                _uiState.postValue(UiState(isLoading = false))
            }

        }
    }

    data class UiState(
        val isLoading: Boolean = false,
        val errorApp: ErrorApp?=null,
        val superheroes: List<Superhero>?= null)
}