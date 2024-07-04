package com.example.pizzashift2024

import com.google.gson.annotations.SerializedName


data class Catalog (

  @SerializedName("id"            ) var id            : String?                = null,
  @SerializedName("name"          ) var name          : String?                = null,
  @SerializedName("ingredients"   ) var ingredients   : ArrayList<Ingredients> = arrayListOf(),
  @SerializedName("toppings"      ) var toppings      : ArrayList<Toppings>    = arrayListOf(),
  @SerializedName("description"   ) var description   : String?                = null,
  @SerializedName("sizes"         ) var sizes         : ArrayList<Sizes>       = arrayListOf(),
  @SerializedName("doughs"        ) var doughs        : ArrayList<Doughs>      = arrayListOf(),
  @SerializedName("calories"      ) var calories      : Int?                   = null,
  @SerializedName("protein"       ) var protein       : String?                = null,
  @SerializedName("totalFat"      ) var totalFat      : String?                = null,
  @SerializedName("carbohydrates" ) var carbohydrates : String?                = null,
  @SerializedName("sodium"        ) var sodium        : String?                = null,
  @SerializedName("allergens"     ) var allergens     : ArrayList<String>      = arrayListOf(),
  @SerializedName("isVegetarian"  ) var isVegetarian  : Boolean?               = null,
  @SerializedName("isGlutenFree"  ) var isGlutenFree  : Boolean?               = null,
  @SerializedName("isNew"         ) var isNew         : Boolean?               = null,
  @SerializedName("isHit"         ) var isHit         : Boolean?               = null,
  @SerializedName("img"           ) var img           : String?                = null

)