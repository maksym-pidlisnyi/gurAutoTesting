package org.academy.web.gur.tests

import org.academy.TestConfigurations
import org.academy.utils.web.AbstractWebDriver
import org.academy.web.gur.pages.*
import org.testng.annotations.AfterMethod
import org.testng.annotations.BeforeMethod
import org.testng.annotations.Test
import kotlin.random.Random

class RegisterTest: AbstractWebDriver() {
    private lateinit var mainPage: MainPage
    private lateinit var registerPage: RegisterPage
    private lateinit var loginPage: LoginPage
    private lateinit var finishRegisterPage: FinishRegisterPage
    private lateinit var restaurantsPage: RestaurantsPage

    @BeforeMethod(alwaysRun = true)
    fun precondition() {
        mainPage = MainPage(webDriver, true, TestConfigurations.getUrl())
        registerPage = mainPage.clickOnSignUp()
    }

    @Test(priority = 1)
    fun positiveUserRegisterTest() {
        val login = "qwerty1uiopl2kjhg3fdsa" + Random.nextInt() * Random.nextInt() + "@gmail.com"
        loginPage = registerPage
            .fillLoginField(login)
            .fillPassField(TestConfigurations.getPassword())
            .clickOnSubmit()
        finishRegisterPage = loginPage.firstUserLogin(login, TestConfigurations.getPassword())
        restaurantsPage = finishRegisterPage
            .fillNameField(TestConfigurations.getNameText())
            .fillPhoneField(TestConfigurations.getPhone())
            .clickOnSubmit()
    }

    @AfterMethod(alwaysRun = true)
    fun logOut() {
        restaurantsPage.clickOnSignOutButton()
    }

    @Test(priority = 2)
    fun positiveCourierRegisterTest() {
        val login = "zxcvbn35mlkjhgfdsaw984" + Random.nextInt() * Random.nextInt() + "@gmail.com"
        loginPage = registerPage
            .clickOnRegisterCourierButton()
            .fillLoginField(login)
            .fillPassField(TestConfigurations.getPassword())
            .clickOnSubmit()
        finishRegisterPage = loginPage.firstCourierLogin(login, TestConfigurations.getPassword())
        restaurantsPage = finishRegisterPage
            .fillNameField(TestConfigurations.getNameText())
            .fillPhoneField(TestConfigurations.getPhone())
            .clickOnSubmit()
    }

}