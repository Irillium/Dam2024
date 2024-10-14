package edu.iesam.dam2024.feature.pokemons.presentation

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import edu.iesam.dam2024.app.domain.ErrorApp
import edu.iesam.dam2024.feature.pokemons.domain.GetPokemonUseCase
import edu.iesam.dam2024.feature.pokemons.domain.Pokemon
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class PokemonDetailViewModel(private val getPokemonUseCase: GetPokemonUseCase):ViewModel() {

    private val _uiState= MutableLiveData<UiState>()
    val uiState:LiveData<UiState> = _uiState

    fun loadPokemon(id:String){
        viewModelScope.launch (Dispatchers.IO){
            val pokemon = getPokemonUseCase.invoke(id)
            _uiState.postValue(UiState(pokemon=pokemon))
        }
    }

    data class UiState(
        val isLoading:Boolean=false,
        val errorApp: ErrorApp?=null,
        val pokemon: Pokemon?=null
    )
}