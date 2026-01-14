package com.nopcommerce.users;

import commons.BaseTest;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import jdk.jfr.Description;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import pageObjects.nopCommerce.PageGenerator;
import pageObjects.nopCommerce.users.*;

public class Level_15_AllureReport extends BaseTest {
    @Parameters("browser")
    @BeforeClass
    public void beforeClass(String browserName) {
        driver = getBrowserDriver(browserName);

        userHomePage = PageGenerator.getUserHomePage(driver);

        firstName = "binh";
        lastName = "nguyen";
        password = "Abc13579";
        company = "Goyoung";
        emailAddress = "nhubinh" + generateRandomNumber() + "@gmail.com";

    }

    @Description("Register to application")
    @Severity(SeverityLevel.NORMAL)
    @Test
    public void User_01_Register() {
        registerPage = userHomePage.clickToRegisterPage();
        registerPage.clickToFemaleRadio();
        registerPage.enterToFirstNameTextBox(firstName);
        registerPage.enterToLastNameTextBox(lastName);
        registerPage.enterToEmailTextBox(emailAddress);
        registerPage.enterToCompanyTextBox(company);
        registerPage.enterToPasswordTextBox(password);
        registerPage.enterToConfirmPasswordTextBox(password);
        registerPage.clickToRegisterButton();

        Assert.assertEquals(registerPage.getRegisterSuccessMessage(), "Your registration completed..");
    }

    @Description("Login to application")
    @Severity(SeverityLevel.MINOR)
    //@Test
    public void User_02_Login() {

        userHomePage = registerPage.clickToLogoutPage();
        userLoginPage = userHomePage.openLoginPage();

        userHomePage = userLoginPage.loginToSystem(emailAddress, password);
        Assert.assertTrue(userHomePage.isMyAccountLinkDisplayed());
    }

    @Description("Verify My Account Info")
    @Severity(SeverityLevel.CRITICAL)
    //@Test
    public void User_03_MyAccount() {
        customerInfoPage = userHomePage.clickToMyAccountPage();

        Assert.assertTrue(customerInfoPage.isGenderFemaleSelected());

        Assert.assertEquals(customerInfoPage.getFirstNameTextboxValue(), firstName);
        Assert.assertEquals(customerInfoPage.getLastNameTextboxValue(), lastName);
        Assert.assertEquals(customerInfoPage.getEmailTextboxValue(), emailAddress);
        Assert.assertEquals(customerInfoPage.getCompanyTextboxValue(), company);
    }


    @AfterClass
    public void afterClass() {
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
}
