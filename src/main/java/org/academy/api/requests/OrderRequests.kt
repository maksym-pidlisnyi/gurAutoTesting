package org.academy.api.requests

import io.restassured.response.Response
import org.academy.api.Resources

class OrderRequests: AbstractRequests() {

    fun createOrder(body: String, responseCode: Int): Response {
        return postRequests.withToken(body, responseCode, Resources.restaurants)
    }
}