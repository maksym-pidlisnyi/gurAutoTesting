package org.academy.web.gur.tests

import org.academy.TestConfigurations
import org.academy.utils.web.AbstractWebDriver
import org.academy.utils.web.WebHelpers
import org.academy.web.gur.pages.CourierPage
import org.academy.web.gur.pages.LoginPage
import org.academy.web.gur.pages.MainPage
import org.openqa.selenium.By
import org.testng.annotations.AfterMethod
import org.testng.annotations.BeforeMethod
import org.testng.annotations.Test

class CourierDeliveryTest : AbstractWebDriver() {
    private lateinit var loginPage: LoginPage
    private lateinit var mainPage: MainPage
    private lateinit var courierPage: CourierPage

    @BeforeMethod(alwaysRun = true)
    fun precondition() {
        mainPage = MainPage(webDriver, true, TestConfigurations.getUrl())
        loginPage = mainPage.clickOnSignIn()
        loginPage
            .toggleSwitch()
            .fillLoginField(TestConfigurations.getCourierLogin())
            .fillPassField(TestConfigurations.getCourierPassword())
            .clickOnSubmit()
        Thread.sleep(2000)
        WebHelpers.refreshPage(webDriver)
        courierPage = CourierPage(webDriver)
    }

    @AfterMethod(alwaysRun = true)
    fun logOut() {
        val logOut = webDriver.findElement(By.xpath("//a[contains(text(),'Вийти')]"))
        logOut.click()
    }

    @Test
    fun deliverOrderTest() {
        courierPage
            .sendLatitude("50.465260")
            .sendLongitude("30.522600")
            .switchToggle()
        Thread.sleep(1000)
        val selectBtn = webDriver.findElement(By.xpath("//div[1]/div[1]/button[1]"))
        selectBtn.click()
        Thread.sleep(3000)
        val deliveredBtn = webDriver.findElement(By.xpath("//button[contains(text(),'Доставлено')]"))
        deliveredBtn.click()
    }
}