package com.example.pizzashift2024

import com.google.gson.annotations.SerializedName


data class Pizza (

  @SerializedName("success" ) val success : Boolean?           = null,
  @SerializedName("catalog" ) val catalog : List<Catalog> = listOf()

)