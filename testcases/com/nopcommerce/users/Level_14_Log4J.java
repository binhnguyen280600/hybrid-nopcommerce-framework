package com.nopcommerce.users;


import commons.BaseTest;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import pageObjects.nopCommerce.PageGenerator;
import pageObjects.nopCommerce.users.*;


public class Level_14_Log4J extends BaseTest {
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

    // Testcases
    @Test
    public void User_01_Register() {
        log.info("User_01_Register - STEP 01: Open Register page");
        registerPage = userHomePage.clickToRegisterPage();

        log.info("User_01_Register - STEP 02: Click to Female radio button");
        registerPage.clickToFemaleRadio();

        log.info("User_01_Register - STEP 03: Enter to Firstname textbox with value" + firstName);
        registerPage.enterToFirstNameTextBox(firstName);

        log.info("User_01_Register - STEP 04: Enter to Lastname textbox with value" + lastName);
        registerPage.enterToLastNameTextBox(lastName);

        log.info("User_01_Register - STEP 05: Enter to Email Address textbox with value" + emailAddress);
        registerPage.enterToEmailTextBox(emailAddress);

        log.info("User_01_Register - STEP 06: Enter to Company textbox with value" + company);
        registerPage.enterToCompanyTextBox(company);

        log.info("User_01_Register - STEP 07: Enter to Password textbox with value" + password);
        registerPage.enterToPasswordTextBox(password);

        log.info("User_01_Register - STEP 08: Enter to Confirm Password textbox with value" + password);
        registerPage.enterToConfirmPasswordTextBox(password);

        log.info("User_01_Register - STEP 09: Click to Register button");
        registerPage.clickToRegisterButton();

        log.info("User_01_Register - STEP 10: Enter to Firstname textbox with value" );
        Assert.assertEquals(registerPage.getRegisterSuccessMessage(), "Your registration completed");
    }

    @Test
    public void User_02_Login() {

        userHomePage = registerPage.clickToLogoutPage();
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

    @Test
    public void User_04_Dynamic_Page() {
        addressPage = (UserAddressPO) customerInfoPage.openSidebarLinkByPageName("Addresses");

        rewardPointPage = (UserRewardPointPO) addressPage.openSidebarLinkByPageName("Reward points");

        orderPage = (UserOrderPO) rewardPointPage.openSidebarLinkByPageName("Orders");

        addressPage = (UserAddressPO) orderPage.openSidebarLinkByPageName("Addresses");

        customerInfoPage = (UserCustomerInfoPO) addressPage.openSidebarLinkByPageName("Customer info");

        rewardPointPage = (UserRewardPointPO) customerInfoPage.openSidebarLinkByPageName("Reward points");

        addressPage = (UserAddressPO) rewardPointPage.openSidebarLinkByPageName("Addresses");
    }

    @Test
    public void User_05_Dynamic_Page() {
        addressPage.openSidebarLinkByPageNames("Reward points");
        rewardPointPage = PageGenerator.getUserRewardPointPage(driver);

        rewardPointPage.openSidebarLinkByPageNames("Orders");
        orderPage = PageGenerator.getUserOrderPage(driver);

        orderPage.openSidebarLinkByPageNames("Addresses");
        addressPage = PageGenerator.getUserAddressPage(driver);

        addressPage.openSidebarLinkByPageNames("Customer info");
        customerInfoPage = PageGenerator.getUserCustomerInfoPage(driver);

        customerInfoPage.openSidebarLinkByPageNames("Reward points");
        rewardPointPage = PageGenerator.getUserRewardPointPage(driver);

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
