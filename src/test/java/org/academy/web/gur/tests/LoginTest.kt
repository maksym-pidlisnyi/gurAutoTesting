package org.academy.web.gur.tests

import org.academy.TestConfigurations
import org.academy.utils.web.AbstractWebDriver
import org.academy.web.gur.pages.LoginPage
import org.academy.web.gur.pages.MainPage
import org.academy.web.gur.pages.RestaurantsPage
import org.testng.annotations.AfterMethod
import org.testng.annotations.BeforeMethod
import org.testng.annotations.Test

class LoginTest : AbstractWebDriver() {
    private lateinit var loginPage: LoginPage
    private lateinit var mainPage: MainPage
    private lateinit var restaurantsPage: RestaurantsPage

    @BeforeMethod(alwaysRun = true)
    fun precondition() {
        mainPage = MainPage(webDriver, true, TestConfigurations.getUrl())
        loginPage = mainPage.clickOnSignIn()
    }

    @Test
    fun positiveUserLoginTest() {
        restaurantsPage = loginPage
            .fillLoginField(TestConfigurations.getLogin())
            .fillPassField(TestConfigurations.getPassword())
            .clickOnSubmit()
    }

    @AfterMethod(alwaysRun = true)
    fun logOut() {
        restaurantsPage.clickOnSignOutButton()
    }

    @Test
    fun positiveCourierLoginTest() {
        restaurantsPage = loginPage
            .toggleSwitch()
            .fillLoginField(TestConfigurations.getCourierLogin())
            .fillPassField(TestConfigurations.getCourierPassword())
            .clickOnSubmit()
    }
}
