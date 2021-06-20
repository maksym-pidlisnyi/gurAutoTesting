package org.academy.web.gur.tests

import org.academy.TestConfigurations
import org.academy.utils.web.AbstractWebDriver
import org.academy.utils.web.WebHelpers
import org.academy.web.gur.pages.*
import org.openqa.selenium.By
import org.testng.annotations.AfterMethod
import org.testng.annotations.BeforeMethod
import org.testng.annotations.Test

class OrderTest : AbstractWebDriver() {
    private lateinit var loginPage: LoginPage
    private lateinit var mainPage: MainPage
    private lateinit var restaurantsPage: RestaurantsPage

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
    fun orderCreationTest() {
        val addressInput = webDriver.findElement(By.xpath("//input[@placeholder='Введіть вашу локацію']"))
        addressInput.sendKeys("Iллінська")
        val searchBtn = webDriver.findElement(By.xpath("//form[1]/div[1]/button[1]/*[1]"))
        searchBtn.click()
        Thread.sleep(1000)
        val agreeBtn = webDriver.findElement(By.xpath("//button[contains(text(),'Ok')]"))
        agreeBtn.click()
        Thread.sleep(500)
        val restPage = webDriver.findElement(By.xpath("//a[@href='/restaurant/4']"))
        restPage.click()
        Thread.sleep(1000)
        val addBurger = webDriver.findElement(By.xpath("//div[1]/div[1]/div[1]/div[3]/button[1]"))
        addBurger.click()
        val addDishFries = webDriver.findElement(By.xpath("//div[1]/div[2]/div[1]/div[3]/button[1]"))
        addDishFries.click()
        Thread.sleep(2000)
        val submitButton = webDriver.findElement(By.xpath("//button[contains(text(),'(148₴)')]"))
        submitButton.click()
        Thread.sleep(1000)
        val createOrder = webDriver.findElement(By.xpath("//button[contains(text(),'Створити замовення')]"))
        createOrder.click()
    }


}