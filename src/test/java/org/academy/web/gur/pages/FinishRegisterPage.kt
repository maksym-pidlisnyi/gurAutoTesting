package org.academy.web.gur.pages

import org.academy.utils.web.elements.elements.Button
import org.academy.utils.web.elements.elements.TextField
import org.academy.web.AbstractPage
import org.openqa.selenium.WebDriver
import org.openqa.selenium.support.FindBy

class FinishRegisterPage(webDriver: WebDriver, navigateToPage: Boolean) :
    AbstractPage(webDriver, navigateToPage) {

    constructor(webDriver: WebDriver) : this(webDriver, false)

    @FindBy(xpath = "//input[@id='first_name']")
    private lateinit var nameField: TextField

    @FindBy(xpath = "//input[@id='tel_num']")
    private lateinit var phoneField: TextField

    @FindBy(xpath = "//button[contains(text(),'Відправити')]")
    private lateinit var submitButton: Button

    fun fillNameField(name: String): FinishRegisterPage {
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