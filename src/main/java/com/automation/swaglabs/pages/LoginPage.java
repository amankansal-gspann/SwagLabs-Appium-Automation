package com.automation.swaglabs.pages;

import io.appium.java_client.MobileBy;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class LoginPage {

    private AndroidDriver driver;
    private WebDriverWait wait;

    private final By usernameFieldLocator = MobileBy.AccessibilityId("test-Username");
    private final By passwordFieldLocator = MobileBy.AccessibilityId("test-Password");
    private final By loginButtonLocator = MobileBy.xpath("//android.widget.TextView[@text='LOGIN']");
    private final By biometryButtonLocator = MobileBy.AccessibilityId("test-biometry");
    private final By errorMessageLocator = By.xpath("//android.view.ViewGroup[@content-desc='test-Error message']//android.widget.TextView");


    public LoginPage(AndroidDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    private WebElement getUsernameField() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(usernameFieldLocator));
    }

    private WebElement getPasswordField() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(passwordFieldLocator));
    }

    private WebElement getLoginButton() {
        return wait.until(ExpectedConditions.elementToBeClickable(loginButtonLocator));
    }

    private WebElement getBiometryButton() {
        return wait.until(ExpectedConditions.elementToBeClickable(biometryButtonLocator));
    }

    private WebElement getErrorMessageElement() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(errorMessageLocator));
    }

    public void enterUsername(String username) {
        WebElement usernameField = getUsernameField();
        usernameField.clear();
        usernameField.sendKeys(username);
    }

    public void enterPassword(String password) {
        WebElement passwordField = getPasswordField();
        passwordField.clear();
        passwordField.sendKeys(password);
    }

    public void tapLoginButton() {
        getLoginButton().click();
    }

    public void tapBiometryButton() {
        getBiometryButton().click();
    }

    public String getErrorMessage() {
        try {
            return getErrorMessageElement().getText().trim();
        } catch (Exception e) {
            System.out.println("Error message not found on screen.");
            return "";
        }
    }

    public void login(String username, String password) {
        enterUsername(username);
        enterPassword(password);
        tapLoginButton();
    }

    public void clearUsernameField() {
        getUsernameField().clear();
    }

    public void clearPasswordField() {
        getPasswordField().clear();
    }
}