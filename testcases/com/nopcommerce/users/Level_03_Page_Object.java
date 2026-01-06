package com.nopcommerce.users;

import commons.BaseTest;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pageObjects.users.UserCustomerInfoPO;
import pageObjects.users.UserHomePO;
import pageObjects.users.UserLoginPageObject;
import pageObjects.users.UserRegisterPO;

import java.time.Duration;

    public class Level_03_Page_Object extends BaseTest {
        private WebDriver driver;
        private UserCustomerInfoPO customerInfoPage;
        private UserLoginPageObject loginPage;
        private UserRegisterPO registerPage;
        private UserHomePO homePage;
        private String emailAddress, firstName, lastName, password, company;

        // Pre-Condition
        @BeforeClass
        public void beforeClass() {
            driver = new FirefoxDriver();
            driver.get("http://localhost:8082/");
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
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

            loginPage = new UserLoginPageObject(driver);

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
