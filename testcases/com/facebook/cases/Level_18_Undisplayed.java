package com.facebook.cases;

import commons.BaseTest;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import pageObjects.facebook.LoginPO;
import pageObjects.facebook.PageGenerator;
import pageObjects.jquery.HomePO;

public class Level_18_Undisplayed extends BaseTest {
    @Parameters({"browser", "Url"})
    @BeforeClass
    public void beforeClass(String browserName, String url) {
        driver = getBrowserDriver(browserName, url);
        loginPage = PageGenerator.getLoginPage(driver);

        loginPage.clickToNewAccountButton();
    }

    @Test
    public void TC_01_Element_Undisplayed() {
        loginPage.enterToEmailTextbox("");

        //Case 1: Verify confirm Email textbox is displayed
        Assert.assertTrue(loginPage.isConfirmEmailTextboxDisplayed());

        //Case 2: Verify confirm Email textbox is not displayed
        Assert.assertFalse(loginPage.isConfirmEmailTextboxUndisplayed());

        //Case 3: Verify confirm Email textbox is not displayed
        loginPage.clickToCloseIcon();
    }
        @AfterClass
        public void afterClass () {
            driver.quit();
        }

        private WebDriver driver;
        private LoginPO loginPage;

}
