package org.academy.api.tests.gur

import com.fasterxml.jackson.databind.ObjectMapper
import org.academy.TestConfigurations
import org.academy.api.pojo.Location
import org.academy.api.pojo.Restaurant
import org.academy.api.requests.DishesRequests
import org.assertj.core.api.Assertions.assertThat
import org.testng.annotations.Test

class DishTest {
    private val dishRequests = DishesRequests()

    @Test
    fun createRestaurant() {
        val restaurant = Restaurant(
            "Test1",
            "правди 10",
            "https://cdn.pixabay.com/photo/2015/04/23/22/00/tree-736885__480.jpg",
            Location("30.591311", "50.460569"),
            "07:30 AM",
            "09:30 PM",
        )
        val mapper = ObjectMapper()
        val body = mapper.writeValueAsString(restaurant)
        val response = dishRequests.createDish(TestConfigurations.getApiToken(), body,201)
        assertThat(response.statusCode).isEqualTo(201)
    }
}