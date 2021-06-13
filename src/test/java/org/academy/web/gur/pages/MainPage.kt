package org.academy.web.gur.pages

import org.academy.web.AbstractPage
import org.openqa.selenium.WebDriver
import org.openqa.selenium.WebElement
import org.openqa.selenium.support.FindBy

class MainPage(webDriver: WebDriver, navigateToPage: Boolean, navigateToPageUrl: String) :
    AbstractPage(webDriver, navigateToPage, navigateToPageUrl) {

    @FindBy(xpath = "//a[contains(text(),'Увійти')]")
    private lateinit var signInButton: WebElement

    @FindBy(xpath = "//a[contains(text(),'Реєстрація')]")
    private lateinit var signUpButton: WebElement

    @FindBy(xpath = "//a[contains(text(),'Ресторани')]")
    private lateinit var restaurantsButton: WebElement

    fun clickOnSignIn(): LoginPage {
        signInButton.click()
        return LoginPage(webDriver)
    }

    fun clickOnSignUp(): RegisterPage {
        signUpButton.click()
        return RegisterPage(webDriver)
    }

    fun clickOnRestaurantsButton(): RestaurantsPage {
        restaurantsButton.click()
        return RestaurantsPage(webDriver)
    }
}