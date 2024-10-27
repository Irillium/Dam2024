package edu.iesam.dam2024.feature.pokemons.presentation

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import edu.iesam.dam2024.app.domain.ErrorApp
import edu.iesam.dam2024.feature.pokemons.domain.GetNextPokemonsUseCase
import edu.iesam.dam2024.feature.pokemons.domain.GetPokemonsUseCase
import edu.iesam.dam2024.feature.pokemons.domain.Pokemon
import kotlinx.coroutines.*

class PokemonListViewModel(private val getPokemonsUseCase: GetPokemonsUseCase,
    private val getNextPokemonsUseCase: GetNextPokemonsUseCase) : ViewModel() {

    private val _uiState = MutableLiveData<UiState>()
    val uiState: LiveData<UiState> = _uiState

    private var offset:Int=0
    private var isLoading = false
     var currentPokemonList = mutableListOf<Pokemon>()

    fun loadPokemons(){
        viewModelScope.launch(Dispatchers.IO) {
            if(currentPokemonList.isEmpty()){
                val pokemons = getPokemonsUseCase.invoke()
                currentPokemonList.addAll(pokemons)
                _uiState.postValue(UiState(pokemons=pokemons))
            }
        }
    }
    fun loadNextPokemons(){

        offset+=20
        viewModelScope.launch(Dispatchers.IO) {
            _uiState.postValue(UiState(isLoading = true))
            val nextPokemons = getNextPokemonsUseCase.invoke(offset)

            if(nextPokemons.isNotEmpty()){
                withContext(Dispatchers.Main) {
                    Log.d("@dev","Oido")
                    currentPokemonList.addAll(nextPokemons)
                    _uiState.value = UiState(pokemons = currentPokemonList)
                }
            }
            _uiState.postValue(UiState(isLoading = false))
        }

    }

    data class UiState(
        val isLoading: Boolean = false,
        val errorApp: ErrorApp? = null,
        val pokemons: List<Pokemon>? = null
    )
}