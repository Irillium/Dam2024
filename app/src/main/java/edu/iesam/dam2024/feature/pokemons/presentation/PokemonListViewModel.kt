package edu.iesam.dam2024.feature.pokemons.presentation

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import edu.iesam.dam2024.app.domain.ErrorApp
import edu.iesam.dam2024.feature.pokemons.domain.GetPokemonsUseCase
import edu.iesam.dam2024.feature.pokemons.domain.Pokemon
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class PokemonListViewModel(private val getPokemonsUseCase: GetPokemonsUseCase) : ViewModel() {

    private val _uiState = MutableLiveData<UiState>()
    val uiState: LiveData<UiState> = _uiState

    fun loadPokemons(){
        viewModelScope.launch(Dispatchers.IO) {
            val pokemons = getPokemonsUseCase.invoke()
            _uiState.postValue(UiState(pokemons=pokemons))
        }
    }

    data class UiState(
        val isLoading: Boolean = false,
        val errorApp: ErrorApp? = null,
        val pokemons: List<Pokemon>? = null
    )
}