package com.nopcommerce.users;

import commons.BaseTest;
import data.UserData;
import employee.EmployeeData;
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
import utilities.ExcelConfig;
import utilities.FakerConfig;

public class Level_25_Manage_Data_04_JSON_Excel extends BaseTest {
    @Parameters("browser")
    @BeforeClass
    public void beforeClass(String browserName) {
        driver = getBrowserDriver(browserName);
        userHomePage = PageGenerator.getUserHomePage(driver);

        excelConfig = ExcelConfig.getExcelData();

        excelConfig.switchToSheet("Employee");
        emailAddress = excelConfig.getCellData("EmailAddress", 1) + "@gmail.com";
    }

    @Test
    public void User_01_Register() {
        registerPage = userHomePage.clickToRegisterPage();

        registerPage.clickToRadioByID(driver, "gender-female");

        registerPage.isLanguageDisplayed(employeeData.getSkillTree());

        registerPage.enterToTextboxByID(driver, "FirstName", excelConfig.getCellData("FirstName", 1));
        registerPage.enterToTextboxByID(driver,"LastName", excelConfig.getCellData("LastName", 1));

        registerPage.enterToTextboxByID(driver,"Email", emailAddress);
        registerPage.enterToTextboxByID(driver,"Company", excelConfig.getCellData("Company", 1));

        registerPage.clickToCheckboxByID(driver, "NewsLetterSubscriptions_0__IsActive");

        registerPage.enterToTextboxByID(driver,"Password", excelConfig.getCellData("Password", 1));
        registerPage.enterToTextboxByID(driver,"ConfirmPassword", excelConfig.getCellData("Password", 1));

        registerPage.clickToButtonByText(driver, "Register");

        Assert.assertEquals(registerPage.getRegisterSuccessMessage(), "Your registration completed");
    }

    @Description("Login to application")
    @Severity(SeverityLevel.MINOR)
   // @Test
    public void User_02_Login() {

        userHomePage = registerPage.clickToLogoutPage();

        userLoginPage.enterToTextboxByID(driver,"Email", emailAddress);

        userLoginPage.enterToTextboxByID(driver,"Password", userData.getPassword());

        userLoginPage.clickToButtonByText(driver, "Log in");

        userHomePage = PageGenerator.getUserHomePage(driver);

        Assert.assertTrue(userHomePage.isMyAccountLinkDisplayed());

    }

    @Description("Verify My Account Info")
    @Severity(SeverityLevel.CRITICAL)
    //@Test
    public void User_03_MyAccount() {
        customerInfoPage = userHomePage.clickToMyAccountPage();

        Assert.assertTrue(customerInfoPage.isGenderFemaleSelected());

        Assert.assertTrue(customerInfoPage.isRadioByIDSelected(driver, "gender-female"));

        Assert.assertEquals(customerInfoPage.getTextboxValueByID(driver, "FirstName"), userData.getFirstName());
        Assert.assertEquals(customerInfoPage.getTextboxValueByID(driver, "LastName"), userData.getLastName());
        Assert.assertEquals(customerInfoPage.getTextboxValueByID(driver, "Email"), userData.getEmailAddress());
        Assert.assertEquals(customerInfoPage.getTextboxValueByID(driver, "Company") , userData.getCompany());
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
    private String emailAddress;
    private EmployeeData employeeData;
    private UserData userData;
    private ExcelConfig excelConfig ;
}
