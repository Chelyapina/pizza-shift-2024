package com.example.pizzashift2024

import com.google.gson.annotations.SerializedName


data class Pizza (

  @SerializedName("success" ) var success : Boolean?           = null,
  @SerializedName("catalog" ) var catalog : ArrayList<Catalog> = arrayListOf()

)