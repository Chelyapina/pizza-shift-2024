package com.example.pizzashift2024

import com.example.finalpizzashift2024.net.model.NameDoughs
import com.google.gson.annotations.SerializedName


data class Doughs (

  @SerializedName("name"  ) val name  : NameDoughs,
  @SerializedName("price" ) val price : Int?    = null

)