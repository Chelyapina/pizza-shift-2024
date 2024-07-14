package com.example.finalpizzashift2024.net.data.cart

import androidx.compose.runtime.MutableState
import com.example.finalpizzashift2024.net.data.DataToppings
import com.example.pizzashift2024.Doughs
import com.example.pizzashift2024.Sizes

data class DataCartForOnePizza(
    val name: String,
    val dataToppings: List<DataToppings>,
    val description: String,

    val sizes: MutableState<Sizes?>,
    val doughs: MutableState<Doughs?>
)