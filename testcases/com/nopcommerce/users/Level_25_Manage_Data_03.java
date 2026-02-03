package com.nopcommerce.users;

import pojo.UserInfo;
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
import utilities.FakerConfig;

public class Level_25_Manage_Data_03 extends BaseTest {
    @Parameters("browser")
    @BeforeClass
    public void beforeClass(String browserName) {
        driver = getBrowserDriver(browserName);
        userHomePage = PageGenerator.getUserHomePage(driver);
        userInfo = UserInfo.getUserData();

        userInfo.setFirstName("Binh");
        userInfo.setLastName("Tester");
        userInfo.setCompany("TCL");
        userInfo.setEmailAddress("binh" + generateRandomNumber() + "@gmail.com");
        userInfo.setPassword("1223453");
    }

    @Test
    public void User_01_Register() {
        registerPage = userHomePage.clickToRegisterPage();

        registerPage.clickToRadioByID(driver, "gender-female");

        registerPage.enterToRegisterForm(userInfo);
        registerPage.clickToButtonByText(driver, "Register");

        Assert.assertEquals(registerPage.getRegisterSuccessMessage(), "Your registration completed");
    }

    @Description("Login to application")
    @Severity(SeverityLevel.MINOR)
    @Test
    public void User_02_Login() {

        userHomePage = registerPage.clickToLogoutPage();

        userLoginPage = userHomePage.openLoginPage();

        userHomePage = userLoginPage.enterToLoginForm(userInfo);

        Assert.assertTrue(userHomePage.isMyAccountLinkDisplayed());
    }

    @Description("Verify My Account Info")
    @Severity(SeverityLevel.CRITICAL)
    @Test
    public void User_03_MyAccount() {
        customerInfoPage = userHomePage.clickToMyAccountPage();

        Assert.assertTrue(customerInfoPage.isGenderFemaleSelected());

        Assert.assertTrue(customerInfoPage.isRadioByIDSelected(driver, "gender-female"));

        Assert.assertEquals(customerInfoPage.getTextboxValueByID(driver, "FirstName"), userInfo.getFirstName());
        Assert.assertEquals(customerInfoPage.getTextboxValueByID(driver, "LastName"), userInfo.getLastName());
        Assert.assertEquals(customerInfoPage.getTextboxValueByID(driver, "Email"), userInfo.getEmailAddress());
        Assert.assertEquals(customerInfoPage.getTextboxValueByID(driver, "Company") , userInfo.getCompany());

        Assert.assertTrue(customerInfoPage.isCheckboxByIDSelected(driver, "NewsLetterSubscriptions_0__IsActive"));
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
    private FakerConfig faker;
    private UserInfo userInfo;
}
