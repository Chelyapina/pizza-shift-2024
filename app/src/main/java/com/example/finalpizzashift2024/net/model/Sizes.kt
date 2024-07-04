package com.example.pizzashift2024

import com.example.finalpizzashift2024.net.model.NameSize
import com.google.gson.annotations.SerializedName


data class Sizes (

  @SerializedName("name"  ) var name  : NameSize,
  @SerializedName("price" ) var price : Int?    = null

)