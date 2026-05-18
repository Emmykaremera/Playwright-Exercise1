package tests;

import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.LoginPage;
import utils.TestData;

public class AuthTest extends BaseTest {

    @Test
    public void positiveLoginTest(){

        LoginPage loginPage = new LoginPage(page);

        loginPage.login(
                TestData.USERNAME,
                TestData.PASSWORD
        );

        Assert.assertTrue(
                page.url().contains("inventory"),
                "Login Successful"
        );
    }

    @Test
    public void negativeLoginTest(){

        LoginPage loginPage = new LoginPage(page);

        loginPage.login(
                TestData.INVALID_USERNAME,
                TestData.INVALID_PASSWORD
        );

        String actualError = loginPage.getErrorMessage();

        String expectedError =
                "Epic sadface: Username and password do not match any user in this service";

        Assert.assertEquals(actualError, expectedError);
    }
}