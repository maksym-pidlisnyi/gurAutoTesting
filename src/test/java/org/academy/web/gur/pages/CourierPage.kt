package org.academy.web.gur.pages

import org.academy.utils.web.elements.elements.Button
import org.academy.utils.web.elements.elements.TextField
import org.academy.web.AbstractPage
import org.openqa.selenium.WebDriver
import org.openqa.selenium.WebElement
import org.openqa.selenium.support.FindBy

class CourierPage(webDriver: WebDriver, navigateToPage: Boolean) :
    AbstractPage(webDriver, navigateToPage) {

    constructor(webDriver: WebDriver) : this(webDriver, false)

    @FindBy(xpath = "//div[1]/label[1]/span[2]")
    private lateinit var workToggle: Button

    @FindBy(xpath = "//div[1]/div[2]/input[1]")
    private lateinit var longitudeField: TextField

    @FindBy(xpath = "//div[1]//div[3]/input[1]")
    private lateinit var latitudeField: TextField

    fun switchToggle() : CourierPage {
        workToggle.click()
        return this
    }

    fun sendLongitude(longitude: String) : CourierPage {
        longitudeField.clearAndType(longitude)
        return this
    }

    fun sendLatitude(latitude: String) : CourierPage {
        latitudeField.clearAndType(latitude)
        return this
    }

}