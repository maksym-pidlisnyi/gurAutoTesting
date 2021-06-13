package org.academy.api.pojo

import com.google.gson.annotations.SerializedName

data class Restaurant(
    val name: String,
    @SerializedName("rest_address") val address: String,
    @SerializedName("rest_photo") val photo: String?,
    @SerializedName("rest_address") val location: Location,
    @SerializedName("open_from") val open: String?,
    @SerializedName("open_to") val closed: String?,
)
