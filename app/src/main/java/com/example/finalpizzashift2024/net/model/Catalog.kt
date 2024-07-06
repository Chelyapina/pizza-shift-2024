package com.example.pizzashift2024

import com.google.gson.annotations.SerializedName


data class Catalog (

  @SerializedName("id"            ) val id            : String?                = null,
  @SerializedName("name"          ) val name          : String?                = null,
  @SerializedName("ingredients"   ) val ingredients   : List<Ingredients> = listOf(),
  @SerializedName("toppings"      ) val toppings      : List<Toppings>    = listOf(),
  @SerializedName("description"   ) val description   : String?                = null,
  @SerializedName("sizes"         ) val sizes         : List<Sizes>       = listOf(),
  @SerializedName("doughs"        ) val doughs        : List<Doughs>      = listOf(),
  @SerializedName("calories"      ) val calories      : Int?                   = null,
  @SerializedName("protein"       ) val protein       : String?                = null,
  @SerializedName("totalFat"      ) val totalFat      : String?                = null,
  @SerializedName("carbohydrates" ) val carbohydrates : String?                = null,
  @SerializedName("sodium"        ) val sodium        : String?                = null,
  @SerializedName("allergens"     ) val allergens     : List<String>      = listOf(),
  @SerializedName("isVegetarian"  ) val isVegetarian  : Boolean?               = null,
  @SerializedName("isGlutenFree"  ) val isGlutenFree  : Boolean?               = null,
  @SerializedName("isNew"         ) val isNew         : Boolean?               = null,
  @SerializedName("isHit"         ) val isHit         : Boolean?               = null,
  @SerializedName("img"           ) val img           : String?                = null

)