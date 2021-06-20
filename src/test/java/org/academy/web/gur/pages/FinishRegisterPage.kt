package org.academy.web.gur.pages

import org.academy.utils.web.WebWaiters
import org.academy.utils.web.elements.elements.Button
import org.academy.utils.web.elements.elements.TextField
import org.academy.web.AbstractPage
import org.openqa.selenium.WebDriver
import org.openqa.selenium.WebElement
import org.openqa.selenium.support.FindBy

class FinishRegisterPage(webDriver: WebDriver, navigateToPage: Boolean) :
    AbstractPage(webDriver, navigateToPage) {

    constructor(webDriver: WebDriver) : this(webDriver, false)

    @FindBy(xpath = "//input[@id='first_name']")
    private lateinit var nameField: WebElement

    @FindBy(xpath = "//input[@id='tel_num']")
    private lateinit var phoneField: TextField

    @FindBy(xpath = "//button[contains(text(),'Відправити')]")
    private lateinit var submitButton: Button

    fun fillNameField(name: String): FinishRegisterPage {
        WebWaiters.waitUntilElementIsVisible(nameField, webDriver, 5)
        nameField.sendKeys(name)
        return this
    }

    fun fillPhoneField(phone: String):  FinishRegisterPage{
        phoneField.sendKeys(phone)
        return this
    }

    fun clickOnSubmit(): RestaurantsPage {
        submitButton.click()
        return RestaurantsPage(webDriver)
    }
}