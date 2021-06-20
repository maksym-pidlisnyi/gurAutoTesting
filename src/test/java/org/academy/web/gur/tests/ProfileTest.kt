package org.academy.web.gur.tests

import org.academy.TestConfigurations
import org.academy.utils.web.AbstractWebDriver
import org.academy.utils.web.WebHelpers
import org.academy.web.gur.pages.LoginPage
import org.academy.web.gur.pages.MainPage
import org.academy.web.gur.pages.ProfilePage
import org.academy.web.gur.pages.RestaurantsPage
import org.openqa.selenium.By
import org.testng.annotations.AfterMethod
import org.testng.annotations.BeforeMethod
import org.testng.annotations.Test

class ProfileTest : AbstractWebDriver() {
    private lateinit var loginPage: LoginPage
    private lateinit var mainPage: MainPage
    private lateinit var restaurantsPage: RestaurantsPage
    private lateinit var profilePage: ProfilePage

    @BeforeMethod(alwaysRun = true)
    fun precondition() {
        mainPage = MainPage(webDriver, true, TestConfigurations.getUrl())
        loginPage = mainPage.clickOnSignIn()
        restaurantsPage = loginPage
            .fillLoginField(TestConfigurations.getLogin())
            .fillPassField(TestConfigurations.getPassword())
            .clickOnSubmit()
        Thread.sleep(2000)
        WebHelpers.refreshPage(webDriver)
    }

    @AfterMethod(alwaysRun = true)
    fun logOut() {
        val logOut = webDriver.findElement(By.xpath("//a[contains(text(),'Вийти')]"))
        logOut.click()
    }

    @Test
    fun editProfileTest() {
        profilePage = restaurantsPage.clickOnProfileButton()
        Thread.sleep(1000)
        val profileToggle = webDriver.findElement(By.xpath("//div[1]/div[1]/label[1]/span[2]"))
        profileToggle.click()

        val userNameField = webDriver.findElement(By.xpath("//input[@id='first_name']"))
        userNameField.clear()
        userNameField.sendKeys("Ivan")

        val telField = webDriver.findElement(By.xpath("//input[@id='tel_num']"))
        telField.clear()
        telField.sendKeys("380964435476")

        val submitBtn = webDriver.findElement(By.xpath("//button[contains(text(),'Змінити')]"))
        submitBtn.click()
    }
}