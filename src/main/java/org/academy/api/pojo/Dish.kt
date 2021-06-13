package org.academy.api.pojo

import com.google.gson.annotations.SerializedName

data class Dish(
    val name: String,
    @SerializedName("dish_photo") val photo: String,
    @SerializedName("restaurant_id") val restId: Int,
    val description: String,
    val price: Double,
    val gramme: Double
)
