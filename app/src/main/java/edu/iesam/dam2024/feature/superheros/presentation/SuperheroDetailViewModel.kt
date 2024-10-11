package edu.iesam.dam2024.feature.superheros.presentation

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import edu.iesam.dam2024.app.domain.ErrorApp
import edu.iesam.dam2024.feature.superheros.domain.GetSuperheroUseCase
import edu.iesam.dam2024.feature.superheros.domain.Superhero
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class SuperheroDetailViewModel(private val getSuperheroUseCase: GetSuperheroUseCase) : ViewModel()  {
    private val _uiState= MutableLiveData<UiState>()
    val uiState : LiveData<UiState> = _uiState

    fun itemSelected(idHero:String){
        viewModelScope.launch(Dispatchers.IO){
            val  superhero = getSuperheroUseCase.invoke(idHero)
            _uiState.postValue(UiState(superhero = superhero))
        }
    }
    data class UiState(
        val isLoading: Boolean = false,
        val errorApp: ErrorApp?=null,
        val superhero: Superhero?= null)
}