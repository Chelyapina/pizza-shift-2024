package com.example.finalpizzashift2024.ui.theme

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProvider.AndroidViewModelFactory.Companion.APPLICATION_KEY
import androidx.lifecycle.viewModelScope
import androidx.lifecycle.viewmodel.initializer
import androidx.lifecycle.viewmodel.viewModelFactory
import com.example.finalpizzashift2024.PizzaApplication
import com.example.finalpizzashift2024.net.data.OnePizzaInfo
import com.example.finalpizzashift2024.net.data.PizzaRepository

import kotlinx.coroutines.launch

sealed interface PizzaUiState{
    data class Success(val pizzaSearch: List<OnePizzaInfo>): PizzaUiState
    object Error : PizzaUiState
    object Loading: PizzaUiState
}

class PizzaViewModel(private val pizzaRepository: PizzaRepository): ViewModel() {

    var pizzaUiState: PizzaUiState by mutableStateOf(PizzaUiState.Loading)
        private set

    init{
        getPizza()
    }

    fun getPizza(){
        viewModelScope.launch {
            pizzaUiState = PizzaUiState.Loading
            pizzaUiState = try {
                PizzaUiState.Success(pizzaRepository.getPizza())
            }catch (e: Exception) {
                PizzaUiState.Error
            }
        }
    }

    companion object{
        val Factory:ViewModelProvider.Factory = viewModelFactory {
            initializer{
                val application = (this[APPLICATION_KEY] as PizzaApplication)
                val pizzaRepository = application.container.pizzaRepository
                PizzaViewModel(pizzaRepository = pizzaRepository)
            }
        }
    }

}