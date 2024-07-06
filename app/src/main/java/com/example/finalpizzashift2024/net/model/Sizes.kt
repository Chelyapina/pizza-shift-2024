package com.example.pizzashift2024

import com.example.finalpizzashift2024.net.model.NameSize
import com.google.gson.annotations.SerializedName


data class Sizes (

  @SerializedName("name"  ) val name  : NameSize,
  @SerializedName("price" ) val price : Int?    = null

)