package com.example.pizzashift2024

import com.example.finalpizzashift2024.net.model.NameDoughs
import com.google.gson.annotations.SerializedName


data class Doughs (

  @SerializedName("name"  ) var name  : NameDoughs,
  @SerializedName("price" ) var price : Int?    = null

)