package com.nopcommerce.users;

import commons.BaseTest;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import pageObjects.nopCommerce.users.UserCustomerInfoPO;
import pageObjects.nopCommerce.users.UserHomePO;
import pageObjects.nopCommerce.users.UserLoginPO;
import pageObjects.nopCommerce.users.UserRegisterPO;

public class Level_04_Multiple_Browser extends BaseTest {
    private WebDriver driver;
    private UserCustomerInfoPO customerInfoPage;
    private UserLoginPO loginPage;
    private UserRegisterPO registerPage;
    private UserHomePO homePage;
    private String emailAddress, firstName, lastName, password, company;

    @Parameters("browser")
    @BeforeClass
    public void beforeClass(String browserName) {
        driver = getBrowserDriver(browserName);
        homePage = new UserHomePO(driver);
        firstName = "binh";
        lastName = "nguyen";
        password = "Abc13579";
        company = "Goyoung";
        emailAddress = "nhubinh" + generateRandomNumber ()  + "@gmail.com";

    }

    // Testcases
    @Test
    public void User_01_Register() {
        homePage.clickToRegisterPage();

        registerPage = new UserRegisterPO(driver);

        registerPage.clickToFemaleRadio();
        registerPage.enterToFirstNameTextBox(firstName);
        registerPage.enterToLastNameTextBox(lastName);
        registerPage.enterToEmailTextBox(emailAddress);
        registerPage.enterToCompanyTextBox(company);
        registerPage.enterToPasswordTextBox(password);
        registerPage.enterToConfirmPasswordTextBox(password);
        registerPage.clickToRegisterButton();

        Assert.assertEquals(registerPage.getRegisterSuccessMessage(), "Your registration completed");

    }

    @Test
    public void User_02_Login() {
        registerPage.clickToLogoutPage();

        loginPage = new UserLoginPO(driver);

        loginPage.clickToLoginPage();
        loginPage.enterToEmailTextbox(emailAddress);
        loginPage.enterToPasswordTextBox(password);
        loginPage.clickToLoginButton();

        homePage = new UserHomePO(driver);

        Assert.assertTrue(homePage.isMyAccountLinkDisplayed());
    }

    @Test
    public void User_03_MyAccount() {
        homePage.clickToMyAccountPage();

        customerInfoPage = new UserCustomerInfoPO(driver);

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
}
