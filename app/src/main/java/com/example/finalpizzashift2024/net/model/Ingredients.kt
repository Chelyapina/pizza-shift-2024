package com.example.pizzashift2024

import com.example.finalpizzashift2024.net.model.NameIngredients
import com.google.gson.annotations.SerializedName


data class Ingredients (

  @SerializedName("name" ) var name : NameIngredients,
  @SerializedName("cost" ) var cost : Int?    = null,
  @SerializedName("img"  ) var img  : String? = null

)