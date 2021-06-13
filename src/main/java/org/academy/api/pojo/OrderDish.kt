package org.academy.api.pojo

import com.google.gson.annotations.SerializedName

data class OrderDish (
    @SerializedName("order_id") val orderId: Int,
    @SerializedName("dish_id") val dishId: Int,
    val quantity: Int = 1
)