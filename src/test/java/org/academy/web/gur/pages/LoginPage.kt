package org.academy.web.gur.pages

import org.academy.TestConfigurations
import org.academy.utils.web.elements.elements.Button
import org.academy.utils.web.elements.elements.TextField
import org.academy.web.AbstractPage
import org.openqa.selenium.WebDriver
import org.openqa.selenium.WebElement
import org.openqa.selenium.support.FindBy

class LoginPage(webDriver: WebDriver, navigateToPage: Boolean) :
    AbstractPage(webDriver, navigateToPage) {

    constructor(webDriver: WebDriver) : this(webDriver, false)

    @FindBy(xpath = "//input[@type='email']")
    private lateinit var loginField: TextField

    @FindBy(xpath = "//input[@type='password']")
    private lateinit var passField: TextField

    @FindBy(xpath = "//button[contains(text(),'Відправити')]")
    private lateinit var submitButton: Button

    @FindBy(xpath = "//span[2]")
    private lateinit var toggleSwitch: Button

    @FindBy(xpath = "//span[1]")
    private lateinit var toggleLabel: WebElement

    fun fillLoginField(login: String): LoginPage {
        loginField.sendKeys(login)
        return this
    }

    fun fillPassField(pass: String): LoginPage{
        passField.sendKeys(pass)
        return this
    }

    fun clickOnSubmit(): RestaurantsPage {
        submitButton.click()
        return RestaurantsPage(webDriver)
    }

    fun loginAsUser(): RestaurantsPage {
        loginField.sendKeys(TestConfigurations.getLogin())
        passField.sendKeys(TestConfigurations.getPassword())
        submitButton.click()
        return RestaurantsPage(webDriver)
    }

    fun firstUserLogin(login: String, pass: String): FinishRegisterPage {
        loginField.sendKeys(login)
        passField.sendKeys(pass)
        submitButton.click()
        return FinishRegisterPage(webDriver)
    }

    fun firstCourierLogin(login: String, pass: String): FinishRegisterPage {
        toggleSwitch.click()
        loginField.sendKeys(login)
        passField.sendKeys(pass)
        submitButton.click()
        return FinishRegisterPage(webDriver)
    }

    fun loginAsCourier(): RestaurantsPage {
        toggleSwitch.click()
        return loginAsUser()
    }

    fun toggleSwitch(): LoginPage {
        toggleSwitch.click()
        return this
    }

    fun getToggleLabelText(): String {
        return toggleLabel.text
    }
}