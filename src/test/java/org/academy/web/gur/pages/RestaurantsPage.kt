package org.academy.web.gur.pages

import org.academy.utils.web.WebWaiters
import org.academy.utils.web.elements.elements.Button
import org.academy.web.AbstractPage
import org.openqa.selenium.By
import org.openqa.selenium.WebDriver
import org.openqa.selenium.WebElement
import org.openqa.selenium.support.FindBy

class RestaurantsPage(webDriver: WebDriver, navigateToPage: Boolean) :
    AbstractPage(webDriver, navigateToPage) {

    constructor(webDriver: WebDriver) : this(webDriver, false)

    @FindBy(xpath = "//a[contains(text(),'Вийти')]")
    private lateinit var signOutButton: Button

    @FindBy(xpath = "//a[@href='/profile']")
    private lateinit var profileButton: WebElement

    fun clickOnSignOutButton() : MainPage {
        signOutButton.click()
        return MainPage(webDriver, false, "")
    }

    fun clickOnProfileButton() : ProfilePage {
//        WebWaiters.waitUntilElementIsVisible(webDriver.findElement(By.xpath("//a[@href='/profile']")), webDriver, 5)
//        val profileButton = webDriver.findElement(By.xpath("//a[@href='/profile']"))
        profileButton.click()
        return ProfilePage(webDriver)
    }
}