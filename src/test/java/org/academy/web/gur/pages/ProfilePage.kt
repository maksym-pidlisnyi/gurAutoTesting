package org.academy.web.gur.pages

import org.academy.utils.web.elements.elements.Button
import org.academy.web.AbstractPage
import org.openqa.selenium.By
import org.openqa.selenium.WebDriver
import org.openqa.selenium.WebElement
import org.openqa.selenium.support.FindBy

class ProfilePage(webDriver: WebDriver, navigateToPage: Boolean) :
    AbstractPage(webDriver, navigateToPage) {

    constructor(webDriver: WebDriver) : this(webDriver, false)

//    @FindBy(xpath = "//a[contains(text(),'адміну')]")
//    private lateinit var adminButton: Button

    fun clickOnaAdminButton() : AdminPage {
        val adminButton = webDriver.findElement(By.xpath("//a[contains(text(),'адміну')]"))
        adminButton.click()
        return AdminPage(webDriver)
    }
}