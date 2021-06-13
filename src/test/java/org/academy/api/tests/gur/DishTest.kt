package org.academy.api.tests.gur

import com.fasterxml.jackson.databind.ObjectMapper
import org.academy.TestConfigurations
import org.academy.api.pojo.Dish
import org.academy.api.pojo.Location
import org.academy.api.pojo.Restaurant
import org.academy.api.requests.DishesRequests
import org.assertj.core.api.Assertions.assertThat
import org.testng.annotations.Test

class DishTest {
    private val dishRequests = DishesRequests()

    @Test
    fun createRestaurant() {
        val restaurant = Dish(
            "Test1",
            "https://cdn.pixabay.com/photo/2015/04/23/22/00/tree-736885__480.jpg",
            1,
            "Some text",
            250.0,
            500.0
        )
        val mapper = ObjectMapper()
        val body = mapper.writeValueAsString(restaurant)
        val response = dishRequests.createDish(body,201)
        assertThat(response.statusCode).isEqualTo(201)
    }
}