package org.academy.api

import org.academy.PropertyReader

object Resources {
    private fun read(value: String): String {
        return PropertyReader.get().readValue(value)
    }
    val restaurants: String
        get() = read("restaurants")

    val dishes: String
       get() = read("dishes")
}