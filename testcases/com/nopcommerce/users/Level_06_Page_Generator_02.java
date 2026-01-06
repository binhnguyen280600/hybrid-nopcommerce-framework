package com.nopcommerce.users;

import commons.BaseTest;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import pageObjects.users.UserCustomerInfoPO;
import pageObjects.users.UserHomePO;
import pageObjects.users.UserLoginPageObject;
import pageObjects.users.UserRegisterPO;

public class Level_06_Page_Generator_02 extends BaseTest {
    private WebDriver driver;
    private UserCustomerInfoPO customerInfoPage;
    private UserLoginPageObject userLoginPage;
    private UserRegisterPO userRegisterPage;
    private UserHomePO userHomePage;
    private String emailAddress, firstName, lastName, password, company;

    @Parameters("browser")
    @BeforeClass
    public void beforeClass(String browserName) {
        driver = getBrowserDriver(browserName);
        userHomePage = new UserHomePO(driver);
        firstName = "binh";
        lastName = "nguyen";
        password = "Abc13579";
        company = "Goyoung";
        emailAddress = "nhubinh" + generateRandomNumber() + "@gmail.com";

    }

    // Testcases
    @Test
    public void User_01_Register() {
        userRegisterPage = userHomePage.clickToRegisterPage();

        userRegisterPage.clickToFemaleRadio();
        userRegisterPage.enterToFirstNameTextBox(firstName);
        userRegisterPage.enterToLastNameTextBox(lastName);
        userRegisterPage.enterToEmailTextBox(emailAddress);
        userRegisterPage.enterToCompanyTextBox(company);
        userRegisterPage.enterToPasswordTextBox(password);
        userRegisterPage.enterToConfirmPasswordTextBox(password);
        userRegisterPage.clickToRegisterButton();

        Assert.assertEquals(userRegisterPage.getRegisterSuccessMessage(), "Your registration completed");

    }

    @Test
    public void User_02_Login() {

        userHomePage = userRegisterPage.clickToLogoutPage();
        userLoginPage = userHomePage.openLoginPage();

        userHomePage = userLoginPage.loginToSystem(emailAddress, password);
        Assert.assertTrue(userHomePage.isMyAccountLinkDisplayed());
    }

    @Test
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
}
