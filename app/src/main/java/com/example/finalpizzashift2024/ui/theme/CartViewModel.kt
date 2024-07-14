package com.example.finalpizzashift2024.ui.theme

import androidx.lifecycle.ViewModel
import com.example.finalpizzashift2024.net.data.cart.DataCart
import com.example.finalpizzashift2024.net.data.cart.DataCartForOnePizza

class CartViewModel : ViewModel() {
    fun addPizzaToCart(pizza: DataCartForOnePizza) {
        DataCart.addPizzaToCart(pizza)
    }
//    private val _dataCart = MutableLiveData<List<DataCartForOnePizza>>(emptyList())
//    val dataCart: LiveData<List<DataCartForOnePizza>> = _dataCart
//
//    fun addPizzaToCart(pizza: List<DataCartForOnePizza>) {
//        val currentList = _dataCart.value ?: emptyList()
//        _dataCart.value = currentList + pizza
//    }
}