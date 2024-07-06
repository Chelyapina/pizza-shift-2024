package com.example.finalpizzashift2024

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import com.example.finalpizzashift2024.ui.theme.FinalPizzaShift2024Theme
import com.example.finalpizzashift2024.ui.theme.screens.PizzaApp

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            FinalPizzaShift2024Theme {
                PizzaApp()
            }
        }
    }
}
