package com.example.finalpizzashift2024.ui.theme.screens

import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import com.example.finalpizzashift2024.net.data.cart.DataCartForOnePizza
import com.example.finalpizzashift2024.ui.theme.CartViewModel
import com.example.finalpizzashift2024.ui.theme.PizzaUiState
import com.example.finalpizzashift2024.ui.theme.PizzaViewModel

@Composable
fun HomeScreen(navController: NavController
){
    val pizzaViewModel: PizzaViewModel = viewModel(factory = PizzaViewModel.Factory)
    val pizzaUiState by pizzaViewModel.pizzaUiState.collectAsState()

    LaunchedEffect(Unit) {
        pizzaViewModel.getPizza()
    }

    when (pizzaUiState) {
        is PizzaUiState.Loading -> LoadingScreen()
        is PizzaUiState.Success -> PizzaScreen(
            pizza = (pizzaUiState as PizzaUiState.Success).pizzaSearch,
            modifier = Modifier
        )
        is PizzaUiState.Error -> ErrorScreen(onRetry = { pizzaViewModel.getPizza() })
    }
}