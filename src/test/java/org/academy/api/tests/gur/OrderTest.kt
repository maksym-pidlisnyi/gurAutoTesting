package org.academy.api.tests.gur

import com.fasterxml.jackson.databind.ObjectMapper
import org.academy.TestConfigurations
import org.academy.api.pojo.OrderDish
import org.academy.api.requests.OrderRequests
import org.assertj.core.api.Assertions
import org.testng.annotations.Test

class OrderTest {
    private val orderRequests = OrderRequests()

    @Test
    fun createOrder() {
        val order = OrderDish(
            1,
            1
        )
        val mapper = ObjectMapper()
        val body = mapper.writeValueAsString(order)
        val response = orderRequests.createOrder(TestConfigurations.getApiToken(), body,201)
        Assertions.assertThat(response.statusCode).isEqualTo(201)
    }
}