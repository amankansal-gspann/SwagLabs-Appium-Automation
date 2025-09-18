package com.automation.swaglabs.base;

import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

public class BaseTest {

    protected AndroidDriver driver;

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

    @AfterClass
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
