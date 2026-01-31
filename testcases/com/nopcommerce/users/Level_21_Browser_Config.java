package com.nopcommerce.users;

import com.nopcommerce.common.Login;
import commons.BaseTest;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import pageObjects.nopCommerce.PageGenerator;
import pageObjects.nopCommerce.users.*;

public class Level_21_Browser_Config extends BaseTest {
    @Parameters("browser")
    @BeforeClass
    public void beforeClass(String browserName) throws InterruptedException {
        driver = getBrowserDriver(browserName);


    }

    @Test
    public void User_01_MyAccount() {

    }

    @Test
    public void User_02_Order() {

    }


    @Test
    public void User_03_Payment() {

    }

    @AfterClass
    public void afterClass() {
//        driver.quit();
    }

    private WebDriver driver;


}
