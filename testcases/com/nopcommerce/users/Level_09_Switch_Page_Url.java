package com.nopcommerce.users;

import commons.BaseTest;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import pageObjects.*;
import pageObjects.admin.AdminDashboardPO;
import pageObjects.admin.AdminLoginPO;
import pageObjects.users.UserCustomerInfoPO;
import pageObjects.users.UserHomePO;
import pageObjects.users.UserLoginPageObject;
import pageObjects.users.UserRegisterPO;

public class Level_09_Switch_Page_Url extends BaseTest {
    @Parameters({"browser", "userUrl", "adminUrl"})
    @BeforeClass
    public void beforeClass(String browserName, String userUrl, String adminUrl) {
        this.userUrl = userUrl;
        this.adminUrl = adminUrl;

        driver = getBrowserDriver(browserName, this.userUrl);

        userHomePage = PageGenerator.getUserHomePage(driver);

        firstName = "binh";
        lastName = "nguyen";
        password = "Abc13579";
        company = "Goyoung";
        emailAddress = "nhubinh" + generateRandomNumber() + "@gmail.com";

        emailAdminAddress = "admin@yourstore.com";
        adminPassword = "admin";
        //Pre condition
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

        userHomePage = userRegisterPage.clickToLogoutPage();
    }

    // Testcases
    @Test
    public void Role_01_User_Site_To_Admin_Site() {
        userLoginPage = userHomePage.openLoginPage();

        userHomePage = userLoginPage.loginToSystem(emailAddress, password);
        Assert.assertTrue(userHomePage.isMyAccountLinkDisplayed());

        userHomePage.openPageUrl(driver, this.adminUrl);

        adminLoginPage = PageGenerator.getAdminLoginPage(driver);

        adminLoginPage.enterToUsernameTextbox(emailAddress);
        adminLoginPage.enterToPasswordTextbox(password);
        adminDashboardPage = adminLoginPage.clickToLoginButton();


    }

    @Test
    public void Role_02_Admin_Site_To_User_Site() {
        adminDashboardPage.openPageUrl(driver, this.adminUrl);
        userHomePage = PageGenerator.getUserHomePage(driver);
        userCustomerInfoPage = userHomePage.openCustomerInfoPage(driver);

        Assert.assertTrue(userCustomerInfoPage.isGenderFemaleSelected());

        Assert.assertEquals(userCustomerInfoPage.getFirstNameTextboxValue(), firstName);
        Assert.assertEquals(userCustomerInfoPage.getLastNameTextboxValue(), lastName);
        Assert.assertEquals(userCustomerInfoPage.getEmailTextboxValue(), emailAddress);
        Assert.assertEquals(userCustomerInfoPage.getCompanyTextboxValue(), company);

    }

    @Test
    public void User_03_MyAccount() {

    }

    @Test
    public void User_04_Switch_Page() {

    }


        @AfterClass
    public void afterClass() {
        driver.quit();
    }

    private WebDriver driver;
    private UserLoginPageObject userLoginPage;
    private UserRegisterPO userRegisterPage;
    private UserCustomerInfoPO userCustomerInfoPage;
    private UserHomePO userHomePage;
    private AdminLoginPO adminLoginPage;
    private AdminDashboardPO adminDashboardPage;
    private String emailAdminAddress, adminPassword;
    private String userUrl, adminUrl, emailAddress, firstName, lastName, password, company;
}
