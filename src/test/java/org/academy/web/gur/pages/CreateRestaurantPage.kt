package org.academy.web.gur.pages

import org.academy.utils.web.elements.elements.Button
import org.academy.utils.web.elements.elements.TextField
import org.academy.web.AbstractPage
import org.openqa.selenium.WebDriver
import org.openqa.selenium.WebElement
import org.openqa.selenium.support.FindBy

class CreateRestaurantPage (webDriver: WebDriver, navigateToPage: Boolean) :
    AbstractPage(webDriver, navigateToPage) {

    constructor(webDriver: WebDriver) : this(webDriver, false)

    @FindBy(xpath = "//fieldset[1]/form[1]/div[1]/input[1]")
    private lateinit var nameField: TextField

    @FindBy(xpath = "//fieldset[1]/form[1]/div[2]/input[1]")
    private lateinit var addressField: TextField

    @FindBy(xpath = "//fieldset[1]/form[1]/div[4]/input[1]")
    private lateinit var openField: TextField

    @FindBy(xpath = "//fieldset[1]/form[1]/div[5]/input[1]")
    private lateinit var closedField: TextField

    @FindBy(xpath = "//button[contains(text(),'Створити')]")
    private lateinit var submitButton: Button

    @FindBy(xpath = "//legend/b")
    private lateinit var restName: WebElement

    fun fillNameField(name: String) : CreateRestaurantPage {
        nameField.sendKeys(name)
        return this
    }

    fun fillAddressField(name: String) : CreateRestaurantPage {
        addressField.sendKeys(name)
        return this
    }

    fun fillOpenField(name: String) : CreateRestaurantPage {
        openField.sendKeys(name)
        return this
    }

    fun fillClosedField(name: String) : CreateRestaurantPage {
        closedField.sendKeys(name)
        return this
    }

    fun getRestNameText() : String {
        return restName.text
    }

    fun clickOnSubmit(): RestaurantsPage {
        submitButton.click()
        return RestaurantsPage(webDriver)
    }
}