package com.example.finalpizzashift2024.net.data

import com.example.finalpizzashift2024.net.model.NameSize
import com.example.finalpizzashift2024.net.PizzaService

interface PizzaRepository {
    suspend fun getPizza(): List<OnePizzaInfo>
}

class NetPizzaRepository(
    private val pizzaService: PizzaService,
    private val pizzaConverter: PizzaConverter = PizzaConverter()
): PizzaRepository {
    override suspend fun getPizza(): List<OnePizzaInfo> = pizzaService.pizzaSearch().catalog.map { catalog ->
        pizzaConverter.toOnePizzaInfo(catalog)
    }
}
