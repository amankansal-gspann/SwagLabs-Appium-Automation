package com.automation.swaglabs.base;

import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;


/**
 * BaseTest class is responsible for initializing and quitting the Appium driver.
 * All test classes should extend this class to reuse the setup and teardown logic.
 */
public class BaseTest {

    protected AndroidDriver driver;

    /**
     * This method runs before any test class.
     * It sets up the Appium driver with desired capabilities and launches the SwagLabs app.
     */
    @BeforeClass
    public void setUp() throws MalformedURLException {
        DesiredCapabilities caps = new DesiredCapabilities();
        caps.setCapability("platformName", "Android");
        caps.setCapability("deviceName", "RZCXB1F8B6D");
        caps.setCapability("automationName", "UiAutomator2");
        caps.setCapability("appPackage", "com.swaglabsmobileapp");
        caps.setCapability("appActivity", "com.swaglabsmobileapp.MainActivity");
        caps.setCapability("noReset", true);
        driver = new AndroidDriver(new URL("http://127.0.0.1:4723/"), caps);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }

    /**
     * This method runs after all tests in the class.
     * It closes the app and quits the driver session.
     */
    @AfterClass
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
