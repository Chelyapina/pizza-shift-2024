package com.example.finalpizzashift2024.ui.theme.screens

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.example.finalpizzashift2024.ui.theme.PizzaUiState

@Composable
fun HomeScreen(
    pizzaUiState: PizzaUiState,
    retryAction: () -> Unit,
    modifier: Modifier = Modifier
){
    when(pizzaUiState){
        is PizzaUiState.Loading -> LoadingScreen()
        is PizzaUiState.Success -> PizzaScreen(pizza = pizzaUiState.pizzaSearch, modifier = modifier)
        is PizzaUiState.Error -> ErrorScreen(onRetry = retryAction )
    }
}