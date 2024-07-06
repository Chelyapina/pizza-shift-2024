package com.example.pizzashift2024

import com.example.finalpizzashift2024.net.model.NameIngredients
import com.google.gson.annotations.SerializedName


data class Toppings (

  @SerializedName("name" ) val name : NameIngredients,
  @SerializedName("cost" ) val cost : Int?    = null,
  @SerializedName("img"  ) val img  : String? = null

)