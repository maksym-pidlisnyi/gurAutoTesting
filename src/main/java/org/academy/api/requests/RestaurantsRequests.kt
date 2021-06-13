package org.academy.api.requests

import io.restassured.response.Response
import lombok.extern.slf4j.Slf4j
import org.academy.api.Resources

@Slf4j
class RestaurantsRequests : AbstractRequests() {

    fun createRestaurant(body: String, responseCode: Int): Response {
        return postRequests.withToken(body, responseCode, Resources.restaurants)
    }
}