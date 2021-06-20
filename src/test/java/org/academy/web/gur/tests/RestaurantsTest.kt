package org.academy.web.gur.tests

import org.academy.TestConfigurations
import org.academy.utils.web.AbstractWebDriver
import org.academy.utils.web.WebHelpers
import org.academy.web.gur.pages.*
import org.assertj.core.api.Assertions.assertThat
import org.openqa.selenium.By
import org.testng.annotations.AfterMethod
import org.testng.annotations.BeforeMethod
import org.testng.annotations.Test
import kotlin.random.Random

class RestaurantsTest: AbstractWebDriver() {
    private lateinit var loginPage: LoginPage
    private lateinit var mainPage: MainPage
    private lateinit var restaurantsPage: RestaurantsPage
    private lateinit var profilePage: ProfilePage
    private lateinit var adminPage: AdminPage
    private lateinit var createRestaurantPage: CreateRestaurantPage

    @BeforeMethod(alwaysRun = true)
    fun precondition() {
        mainPage = MainPage(webDriver, true, TestConfigurations.getUrl())
        loginPage = mainPage.clickOnSignIn()
    }

    @AfterMethod(alwaysRun = true)
    fun logOut() {
        val logOut = webDriver.findElement(By.xpath("//a[contains(text(),'Вийти')]"))
        logOut.click()
    }

    @Test
    fun restaurantsCreationTest() {
        restaurantsPage = loginPage
            .fillLoginField(TestConfigurations.getLogin())
            .fillPassField(TestConfigurations.getPassword())
            .clickOnSubmit()
        Thread.sleep(2000)
        WebHelpers.refreshPage(webDriver)
        profilePage = restaurantsPage.clickOnProfileButton()
        adminPage = profilePage.clickOnaAdminButton()
        createRestaurantPage = adminPage.clickOnCreateRestButton()
        val restName = "Restaurant ${Random.nextInt()}"
        createRestaurantPage
            .fillNameField(restName)
            .fillAddressField("правди 10")
            .fillOpenField("07:30 AM")
            .fillClosedField("09:30 PM")
    }
}