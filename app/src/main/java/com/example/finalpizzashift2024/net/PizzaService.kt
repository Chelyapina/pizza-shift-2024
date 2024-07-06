package com.example.finalpizzashift2024.net

import com.example.pizzashift2024.Pizza
import retrofit2.http.GET

interface PizzaService {
    @GET("catalog")
    suspend fun pizzaSearch(): Pizza
}