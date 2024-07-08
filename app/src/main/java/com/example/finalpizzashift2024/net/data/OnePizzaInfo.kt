package com.example.finalpizzashift2024.net.data

import com.example.pizzashift2024.Doughs
import com.example.pizzashift2024.Sizes


data class OnePizzaInfo(
    var name: String?= null,
    var description: String?= null,
    var img: String?= null,
    var minCost: Int?= null,

    val doughs: List<Doughs>? = null,
    val sizes: List<Sizes>? = null,
    val dataToppings: List<DataToppings>? = null
)
