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
import utilities.FakerConfig;

public class Level_24_Data_Faker extends BaseTest {
    @Parameters("browser")
    @BeforeClass
    public void beforeClass(String browserName) {
        driver = getBrowserDriver(browserName);
        userHomePage = PageGenerator.getUserHomePage(driver);
        faker = FakerConfig.getFaker();

        firstName = faker.getFirstName();
        lastName = faker.getLastName();
        password = faker.getPassword();
        company = faker.getCompanyName();
        emailAddress = faker.getEmailAddress();

    }

    @Test
    public void User_01_Register() {
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
    }

    @Description("Login to application")
    @Severity(SeverityLevel.MINOR)
    @Test
    public void User_02_Login() {

        userHomePage = registerPage.clickToLogoutPage();
        userLoginPage = userHomePage.openLoginPage();

        userLoginPage.enterToTextboxByID(driver,"Email", emailAddress);

        userLoginPage.enterToTextboxByID(driver,"Password", password);

        userLoginPage.clickToButtonByText(driver, "Log in");

        userHomePage = PageGenerator.getUserHomePage(driver);

        Assert.assertTrue(userHomePage.isMyAccountLinkDisplayed());
    }

    @Description("Verify My Account Info")
    @Severity(SeverityLevel.CRITICAL)
    @Test
    public void User_03_MyAccount() {
        customerInfoPage = userHomePage.clickToMyAccountPage();

        Assert.assertTrue(customerInfoPage.isGenderFemaleSelected());

        Assert.assertTrue(customerInfoPage.isRadioByIDSelected(driver, "gender-female"));

        Assert.assertEquals(customerInfoPage.getTextboxValueByID(driver, "FirstName"), firstName);
        Assert.assertEquals(customerInfoPage.getTextboxValueByID(driver, "LastName"), lastName);
        Assert.assertEquals(customerInfoPage.getTextboxValueByID(driver, "Email"), emailAddress);
        Assert.assertEquals(customerInfoPage.getTextboxValueByID(driver, "Company") , company);

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
    private String emailAddress, firstName, lastName, password, company;
}
