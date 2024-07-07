package com.example.finalpizzashift2024.ui.theme

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProvider.AndroidViewModelFactory.Companion.APPLICATION_KEY
import androidx.lifecycle.viewModelScope
import androidx.lifecycle.viewmodel.initializer
import androidx.lifecycle.viewmodel.viewModelFactory
import com.example.finalpizzashift2024.PizzaApplication
import com.example.finalpizzashift2024.net.data.OnePizzaInfo
import com.example.finalpizzashift2024.net.data.PizzaRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import kotlin.coroutines.cancellation.CancellationException

sealed interface PizzaUiState{
    data class Success(val pizzaSearch: List<OnePizzaInfo>): PizzaUiState
    object Error : PizzaUiState
    object Loading: PizzaUiState
}

class PizzaViewModel(private val pizzaRepository: PizzaRepository): ViewModel() {

    private val _pizzaUiState = MutableStateFlow<PizzaUiState>(PizzaUiState.Loading)
    val pizzaUiState: StateFlow<PizzaUiState> = _pizzaUiState.asStateFlow()

    fun getPizza() {
        viewModelScope.launch {
            _pizzaUiState.value = PizzaUiState.Loading
            _pizzaUiState.value = try {
                PizzaUiState.Success(pizzaRepository.getPizza())
            } catch (ce: CancellationException) {
                throw ce
            } catch (e: Exception) {
                PizzaUiState.Error
            }
        }
    }

    companion object {
        val Factory: ViewModelProvider.Factory = viewModelFactory {
            initializer {
                val application = (this[APPLICATION_KEY] as PizzaApplication)
                val pizzaRepository = application.container.pizzaRepository
                PizzaViewModel(pizzaRepository = pizzaRepository)
            }
        }
    }
}
