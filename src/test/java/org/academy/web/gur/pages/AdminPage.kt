package org.academy.web.gur.pages

import org.academy.utils.web.elements.elements.Button
import org.academy.web.AbstractPage
import org.openqa.selenium.WebDriver
import org.openqa.selenium.support.FindBy

class AdminPage(webDriver: WebDriver, navigateToPage: Boolean) :
    AbstractPage(webDriver, navigateToPage) {

    constructor(webDriver: WebDriver) : this(webDriver, false)

    @FindBy(xpath = "//a[contains(text(),'Створити ресторан')]")
    private lateinit var createRestaurantButton: Button

    fun clickOnCreateRestButton() : CreateRestaurantPage {
        createRestaurantButton.click()
        return CreateRestaurantPage(webDriver)
    }
}