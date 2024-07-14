package com.example.finalpizzashift2024.net.data.cart

import androidx.compose.runtime.mutableStateListOf
import com.example.finalpizzashift2024.ui.theme.CartViewModel

object DataCart {
    private val dataCart = mutableStateListOf<DataCartForOnePizza>()

    fun getPizzaList(): List<DataCartForOnePizza> = dataCart.toList()

    fun addPizzaToCart(pizza: DataCartForOnePizza) {
        dataCart.add(pizza)
    }
//    private var dataCart: List<DataCartForOnePizza>? = null
//
//    fun getPizzaList(): List<DataCartForOnePizza> {
//        return dataCart?.toList() ?: emptyList()
//    }
//
//    fun setPizzaList(list: List<DataCartForOnePizza>) {
//        dataCart = list
//    }
}