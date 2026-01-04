package com.nopcommerce.users;

import commons.BaseTest;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import pageObjects.*;

public class Level_08_Page_Navigation extends BaseTest {
    @Parameters("browser")
    @BeforeClass
    public void beforeClass(String browserName) {
        driver = getBrowserDriver(browserName);

        homePage = PageGenerator.getHomePage(driver);

        firstName = "binh";
        lastName = "nguyen";
        password = "Abc13579";
        company = "Goyoung";
        emailAddress = "nhubinh" + generateRandomNumber() + "@gmail.com";

    }

    // Testcases
    @Test
    public void User_01_Register() {
        registerPage = homePage.clickToRegisterPage();
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

        loginPage = registerPage.clickToLogoutPage();
        loginPage.clickToLoginPage();

        homePage = loginPage.loginToSystem(emailAddress, password);
        Assert.assertTrue(homePage.isMyAccountLinkDisplayed());
    }

    @Test
    public void User_03_MyAccount() {
        customerInfoPage = homePage.clickToMyAccountPage();

        Assert.assertTrue(customerInfoPage.isGenderFemaleSelected());

        Assert.assertEquals(customerInfoPage.getFirstNameTextboxValue(), firstName);
        Assert.assertEquals(customerInfoPage.getLastNameTextboxValue(), lastName);
        Assert.assertEquals(customerInfoPage.getEmailTextboxValue(), emailAddress);
        Assert.assertEquals(customerInfoPage.getCompanyTextboxValue(), company);
    }

    @Test
    public void User_04_Switch_Page() {
        addressPage = customerInfoPage.openAddressPage();

        rewardPointPage = addressPage.openRewardPointPage();

        orderPage = rewardPointPage.openOrderPage();

        addressPage = orderPage.openAddressPage();

        customerInfoPage = addressPage.openCustomerInfoPage();

        rewardPointPage = customerInfoPage.openRewardPointPage();

        addressPage = rewardPointPage.openAddressPage();
    }


        @AfterClass
    public void afterClass() {
        driver.quit();
    }

    private WebDriver driver;
    private CustomerInfoPageObject customerInfoPage;
    private LoginPageObject loginPage;
    private RegisterPageObject registerPage;
    private HomePageObject homePage;
    private OrderPageObject orderPage;
    private RewardPointPageObject rewardPointPage;
    private AddressPageObject addressPage;
    private String emailAddress, firstName, lastName, password, company;
}
