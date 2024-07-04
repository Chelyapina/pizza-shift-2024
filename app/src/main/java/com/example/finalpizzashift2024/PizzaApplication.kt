package com.example.finalpizzashift2024

import android.app.Application
import com.example.pizzashift2024.net.data.AppContainer
import com.example.pizzashift2024.net.data.DefaultAppContainer

class PizzaApplication: Application() {
    lateinit var container: AppContainer
    override fun onCreate() {
        super.onCreate()
        container = DefaultAppContainer()
    }

}