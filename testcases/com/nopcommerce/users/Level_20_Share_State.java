package com.nopcommerce.users;

import com.nopcommerce.common.Login;
import commons.BaseTest;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import jdk.jfr.Description;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.*;
import pageObjects.nopCommerce.PageGenerator;
import pageObjects.nopCommerce.users.*;

import java.util.Set;

public class Level_20_Share_State extends BaseTest {
    @Parameters("browser")
    @BeforeClass
    public void beforeClass(String browserName) throws InterruptedException {
        driver = getBrowserDriver(browserName);
        userHomePage = PageGenerator.getUserHomePage(driver);


        //Pre-condition: login by cookie
        userHomePage.setCookies(driver, Login.nopCommercecookies);
        userHomePage.refreshToPage(driver);

        Assert.assertTrue(userHomePage.isMyAccountLinkDisplayed());

    }

    @Test
    public void User_01_MyAccount() {
        customerInfoPage = userHomePage.clickToMyAccountPage();
        Assert.assertTrue(customerInfoPage.isGenderFemaleSelected());

        Assert.assertTrue(customerInfoPage.isRadioByIDSelected(driver, "gender-female"));

//        Assert.assertEquals(customerInfoPage.getTextboxValueByID(driver, "FirstName"), firstName);
//        Assert.assertEquals(customerInfoPage.getTextboxValueByID(driver, "LastName"), lastName);
//        Assert.assertEquals(customerInfoPage.getTextboxValueByID(driver, "Email"), emailAddress);
//        Assert.assertEquals(customerInfoPage.getTextboxValueByID(driver, "Company") , company);

        Assert.assertTrue(customerInfoPage.isCheckboxByIDSelected(driver, "NewsLetterSubscriptions_0__IsActive"));
    }

    @Test
    public void User_02_Order() {

    }


    @Test
    public void User_03_Payment() {

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
