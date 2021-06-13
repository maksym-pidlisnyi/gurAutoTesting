package org.academy.api.tests.gur

import com.fasterxml.jackson.databind.ObjectMapper
import org.academy.TestConfigurations
import org.academy.api.pojo.Dish
import org.academy.api.requests.RestaurantsRequests
import org.assertj.core.api.Assertions.assertThat
import org.testng.annotations.Test

class RestaurantsTest {
    private val restaurantsRequests = RestaurantsRequests()

    @Test
    fun createRestaurant() {
        val dish = Dish(
            "Test1",
            "ttps://cdn.pixabay.com/photo/2015/04/23/22/00/tree-736885__480.jpg",
            1,
            "some Text",
            250.0,
            350.0
        )
        val mapper = ObjectMapper()
        val body = mapper.writeValueAsString(dish)
        val response = restaurantsRequests.createRestaurant(TestConfigurations.getApiToken(), body,201)
        assertThat(response.statusCode).isEqualTo(201)
    }
}