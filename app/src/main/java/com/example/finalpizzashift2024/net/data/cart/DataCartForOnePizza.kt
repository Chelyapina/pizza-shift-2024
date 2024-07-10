package com.example.finalpizzashift2024.net.data.cart

import com.example.finalpizzashift2024.net.data.DataToppings
import com.example.pizzashift2024.Doughs
import com.example.pizzashift2024.Sizes

data class DataCartForOnePizza(
    val name: String,
    val dataToppings: MutableList<DataToppings> = mutableListOf(),
    val description: String,

    val sizes: MutableList<Sizes?> = mutableListOf(),
    val doughs: MutableList<Doughs?> = mutableListOf()
)