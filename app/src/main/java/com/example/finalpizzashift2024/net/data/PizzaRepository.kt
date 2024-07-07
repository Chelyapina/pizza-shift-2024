package com.example.finalpizzashift2024.net.data

import com.example.finalpizzashift2024.net.model.NameSize
import com.example.finalpizzashift2024.net.PizzaService

interface PizzaRepository {
    suspend fun getPizza(): List<OnePizzaInfo>
}

class NetPizzaRepository(
    private val pizzaService: PizzaService
): PizzaRepository{
    override suspend fun getPizza(): List<OnePizzaInfo> = pizzaService.pizzaSearch().catalog.map { catalog ->
        OnePizzaInfo(
            name = catalog.name,
            description = catalog.description,
            img = "https://shift-backend.onrender.com" + catalog.img,
            minCost = catalog.sizes.find { it.name == NameSize.SMALL }?.price,
            doughs = catalog.doughs,
            sizes = catalog.sizes,
            dataToppings = catalog.toppings.map { ingredients ->
                DataToppings(
                    name = ingredients.name,
                    cost = ingredients.cost,
                    img = "https://shift-backend.onrender.com" + ingredients.img
                )
            }
        )

    }
}