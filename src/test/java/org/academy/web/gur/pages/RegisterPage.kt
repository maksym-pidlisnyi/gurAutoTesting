package org.academy.web.gur.pages

import org.academy.utils.web.WebWaiters
import org.academy.utils.web.elements.elements.Button
import org.academy.utils.web.elements.elements.TextField
import org.academy.web.AbstractPage
import org.openqa.selenium.By
import org.openqa.selenium.WebDriver
import org.openqa.selenium.WebElement
import org.openqa.selenium.support.FindBy

class RegisterPage(webDriver: WebDriver, navigateToPage: Boolean) :
    AbstractPage(webDriver, navigateToPage) {

    constructor(webDriver: WebDriver) : this(webDriver, false)

//    @FindBy(xpath = "//input[@id='email-id']")
//    private lateinit var loginField: WebElement

    @FindBy(xpath = "//input[@id='pass-id']")
    private lateinit var passField: TextField

    @FindBy(xpath = "//button[contains(text(),'Надіслати')]")
    private lateinit var submitButton: Button

    @FindBy(xpath = "//a[@href='/courier/register']")
    private lateinit var registerCourierButton: Button

    fun fillLoginField(login: String): RegisterPage {
        val loginField = webDriver.findElement(By.xpath("//input[@id='email-id']"))
        WebWaiters.waitUntilElementIsVisible(loginField, webDriver, 5)
        loginField.sendKeys(login)
        return this
    }

    fun fillPassField(pass: String):  RegisterPage{
        passField.sendKeys(pass)
        return this
    }

    fun clickOnSubmit(): LoginPage {
        submitButton.click()
        return LoginPage(webDriver)
    }

    fun clickOnRegisterCourierButton(): RegisterPage {
        registerCourierButton.click()
        return RegisterPage(webDriver)
    }

//    fun registerUser() {
//
//    }
//
//    fun registerCourier() {
//
//    }
}