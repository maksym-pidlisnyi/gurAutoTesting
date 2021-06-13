package org.academy.api.requests

import io.restassured.response.Response
import lombok.extern.slf4j.Slf4j
import org.academy.api.Resources

@Slf4j
class RestaurantsRequests : AbstractRequests() {

    fun createRestaurant(token: String, body: String, responseCode: Int): Response {
        return postRequests.withToken(token, body, responseCode, Resources.restaurants)
    }
}