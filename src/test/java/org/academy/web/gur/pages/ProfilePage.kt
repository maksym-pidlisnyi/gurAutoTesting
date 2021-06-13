package org.academy.web.gur.pages

import org.academy.utils.web.elements.elements.Button
import org.academy.web.AbstractPage
import org.openqa.selenium.WebDriver
import org.openqa.selenium.support.FindBy

class ProfilePage(webDriver: WebDriver, navigateToPage: Boolean) :
    AbstractPage(webDriver, navigateToPage) {

    constructor(webDriver: WebDriver) : this(webDriver, false)

    @FindBy(xpath = "//a[@href='/profile']")
    private lateinit var adminButton: Button

    fun clickOnaAminButton() : AdminPage {
        adminButton.click()
        return AdminPage(webDriver)
    }
}