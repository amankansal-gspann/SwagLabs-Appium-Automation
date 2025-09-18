package tests;

import com.automation.swaglabs.base.BaseTest;
import com.automation.swaglabs.constants.Constants;
import com.automation.swaglabs.pages.LoginPage;
import com.automation.swaglabs.pages.LogoutPage;
import org.testng.Assert;
import org.testng.annotations.Test;

/**
 * Test class for verifying login scenarios.
 * Extends BaseTest to reuse driver setup/teardown.
 */
public class LoginTest extends BaseTest {

    /**
     * Test case: Login with valid credentials and then logout.
     */
    @Test
    public void testLogin() {
        LoginPage loginPage = new LoginPage(driver);
        System.out.println("=== Starting Login Test ===");
        loginPage.enterUsername(Constants.STANDARD_USERNAME);
        System.out.println("Entered Username: " + Constants.STANDARD_USERNAME);
        loginPage.enterPassword(Constants.STANDARD_PASSWORD);
        System.out.println("Entered Password: " + Constants.STANDARD_PASSWORD);
        loginPage.tapLoginButton();
        System.out.println("Clicked on Login Button");
        System.out.println(Constants.LOGIN_SUCCESS_MSG);
        System.out.println("=== Login Test Completed ===");
        LogoutPage logoutPage = new LogoutPage(driver);
        logoutPage.logout();
        System.out.println("Logout Successful!");
    }

    /**
     * Test case: Try to login without entering username.
     */
    @Test
    public void testLoginWithoutUsername() {
        LoginPage loginPage = new LoginPage(driver);
        System.out.println("=== Starting Login Without Username Test ===");
        loginPage.clearUsernameField();
        loginPage.enterPassword(Constants.STANDARD_PASSWORD);
        System.out.println("Entered Password: " + Constants.STANDARD_PASSWORD);
        loginPage.tapLoginButton();
        System.out.println("Clicked on Login Button");
        String actualError = loginPage.getErrorMessage();
        System.out.println("Actual Error: '" + actualError + "'");
        Assert.assertEquals(actualError, Constants.USERNAME_REQUIRED, "Error message mismatch for missing username!");
        System.out.println("Displayed Error: " + actualError);
        System.out.println("=== Login Without Username Test Completed ===");
    }

    /**
     * Test case: Try to login without entering password.
     */
    @Test
    public void testLoginWithoutPassword() {
        LoginPage loginPage = new LoginPage(driver);
        System.out.println("=== Starting Login Without Password Test ===");
        loginPage.enterUsername(Constants.STANDARD_USERNAME);
        loginPage.clearPasswordField();
        System.out.println("Entered Username: " + Constants.STANDARD_USERNAME);
        loginPage.tapLoginButton();
        System.out.println("Clicked on Login Button");
        String actualError = loginPage.getErrorMessage();
        System.out.println("Actual Error: '" + actualError + "'");
        Assert.assertEquals(actualError, Constants.PASSWORD_REQUIRED, "Error message mismatch for missing password!");
        System.out.println("Displayed Error: " + actualError);
        System.out.println("=== Login Without Password Test Completed ===");
    }

    /**
     * Test case: Try to login with invalid credentials.
     */
    @Test
    public void testLoginWithInvalidCredentials() {
        LoginPage loginPage = new LoginPage(driver);
        System.out.println("=== Starting Login With Invalid Credentials Test ===");
        loginPage.enterUsername("wrong_user");
        System.out.println("Entered Username: wrong_user");
        loginPage.enterPassword("wrong_pass");
        System.out.println("Entered Password: wrong_pass");
        loginPage.tapLoginButton();
        System.out.println("Clicked on Login Button");
        String actualError = loginPage.getErrorMessage();
        System.out.println("Actual Error: '" + actualError + "'");
        Assert.assertEquals(actualError, Constants.INVALID_CREDENTIALS, "Error message mismatch for invalid credentials!");
        System.out.println("Displayed Error: " + actualError);
        System.out.println("=== Login With Invalid Credentials Test Completed ===");
    }
}