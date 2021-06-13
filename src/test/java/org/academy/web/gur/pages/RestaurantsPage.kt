package org.academy.web.gur.pages

import org.academy.utils.web.elements.elements.Button
import org.academy.web.AbstractPage
import org.openqa.selenium.WebDriver
import org.openqa.selenium.support.FindBy

class RestaurantsPage(webDriver: WebDriver, navigateToPage: Boolean) :
    AbstractPage(webDriver, navigateToPage) {

    constructor(webDriver: WebDriver) : this(webDriver, false)

    @FindBy(xpath = "//a[contains(text(),'Вийти')]")
    private lateinit var signOutButton: Button

    @FindBy(xpath = "//a[@href='/profile']")
    private lateinit var profileButton: Button

    fun clickOnSignOutButton() : MainPage {
        signOutButton.click()
        return MainPage(webDriver, false, "")
    }

    fun clickOnProfileButton() : ProfilePage {
        profileButton.click()
        return ProfilePage(webDriver)
    }
}