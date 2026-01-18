package com.nopcommerce.common;

import commons.BaseTest;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.*;
import pageObjects.nopCommerce.PageGenerator;
import pageObjects.nopCommerce.users.*;

import java.util.Set;

public class Login extends BaseTest {
    @Parameters("browser")
    @BeforeTest
    public void beforeClass(String browserName) {
        driver = getBrowserDriver(browserName);

        userHomePage = PageGenerator.getUserHomePage(driver);

        firstName = "binh";
        lastName = "nguyen";
        password = "Abc13579";
        company = "Goyoung";
        emailAddress = "nhubinh" + generateRandomNumber() + "@gmail.com";

        registerPage = userHomePage.clickToRegisterPage();

        registerPage.clickToRadioByID(driver, "gender-female");

        registerPage.enterToTextboxByID(driver, "FirstName", firstName);
        registerPage.enterToTextboxByID(driver,"LastName", lastName);

        registerPage.enterToTextboxByID(driver,"Email", emailAddress);
        registerPage.enterToTextboxByID(driver,"Company", company);

        registerPage.clickToCheckboxByID(driver, "NewsLetterSubscriptions_0__IsActive");

        registerPage.enterToTextboxByID(driver,"Password", password);
        registerPage.enterToTextboxByID(driver,"ConfirmPassword", password);

        registerPage.clickToButtonByText(driver, "Register");

        Assert.assertEquals(registerPage.getRegisterSuccessMessage(), "Your registration completed");

        userHomePage = registerPage.clickToLogoutPage();

        userLoginPage = userHomePage.openLoginPage();
        userLoginPage.enterToTextboxByID(driver,"Email", emailAddress);
        userLoginPage.enterToTextboxByID(driver,"Password", password);

        registerPage.clickToButtonByText(driver, "Log in");

        userHomePage = PageGenerator.getUserHomePage(driver);

        Assert.assertTrue(userHomePage.isMyAccountLinkDisplayed());

        // Get Cookies
        nopCommercecookies = userHomePage.getAllCookies(driver);

        driver.quit();

    }





    private WebDriver driver;
    private UserCustomerInfoPO customerInfoPage;
    private UserLoginPO userLoginPage;
    private UserRegisterPO registerPage;
    private UserHomePO userHomePage;
    private UserOrderPO orderPage;
    private UserRewardPointPO rewardPointPage;
    private UserAddressPO addressPage;
    private String emailAddress, firstName, lastName, password, company;
    public static Set<Cookie> nopCommercecookies;
}
