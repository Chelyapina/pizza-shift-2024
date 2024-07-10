package com.example.finalpizzashift2024.ui.theme

import androidx.lifecycle.ViewModel
import com.example.finalpizzashift2024.net.data.DataToppings
import com.example.finalpizzashift2024.net.data.cart.DataCartForOnePizza
import com.example.pizzashift2024.Doughs
import com.example.pizzashift2024.Sizes
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow

class CartViewModel : ViewModel() {
    private val _dataCart = MutableStateFlow<List<DataCartForOnePizza>>(emptyList())
    val dataCart: StateFlow<List<DataCartForOnePizza>> = _dataCart

//    fun createAndAddPizza( name: String,
//                         dataToppings: List<DataToppings> ,
//                          description: String,
//                           sizes: List<Sizes>,
//                           doughs: List<Doughs>) {
//        val newPizza = DataCartForOnePizza(
//            name = name,
//            description = description,
//            sizes = sizes,
//            doughs = doughs,
//            dataToppings = dataToppings
//        )
//
//        _dataCart.value = _dataCart.value + newPizza
//    }
}