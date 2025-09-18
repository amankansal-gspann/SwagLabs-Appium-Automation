package com.automation.swaglabs.pages;

import io.appium.java_client.MobileBy;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

/**
 * Page Object Model (POM) class for the Logout process.
 * Contains locators and methods to log out from the app.
 */
public class LogoutPage {

    private AndroidDriver driver;
    private WebDriverWait wait;

    private By menuButtonLocator = MobileBy.xpath("//android.view.ViewGroup[@content-desc='test-Menu']/android.view.ViewGroup/android.widget.ImageView");
    private By logoutButtonLocator = MobileBy.xpath("//android.widget.TextView[@text='LOGOUT']");

    public LogoutPage(AndroidDriver driver){
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(5));
    }

    public void openMenu() {
        WebElement menuButton = driver.findElement(menuButtonLocator);
        menuButton.click();
    }

    public void logout() {
        openMenu();
        WebElement logoutButton = wait.until(ExpectedConditions.visibilityOfElementLocated(logoutButtonLocator));
        logoutButton.click();
    }
}
