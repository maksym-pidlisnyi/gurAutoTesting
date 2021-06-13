package org.academy.api.requests

import io.restassured.response.Response
import org.academy.api.Resources

class OrderRequests: AbstractRequests() {

    fun createOrder(token: String, body: String, responseCode: Int): Response {
        return postRequests.withToken(token, body, responseCode, Resources.restaurants)
    }
}