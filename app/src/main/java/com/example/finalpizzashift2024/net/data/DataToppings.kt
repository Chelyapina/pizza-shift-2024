package com.example.finalpizzashift2024.net.data

import com.example.finalpizzashift2024.net.model.NameIngredients

data class DataToppings(
     var name: NameIngredients,
     var cost: Int? = null,
     var img: String? = null
)