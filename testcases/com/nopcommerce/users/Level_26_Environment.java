package com.nopcommerce.users;

import commons.BaseTest;
import org.aeonbits.owner.ConfigFactory;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import utilities.EnvironmentConfig;
import utilities.PropertiesConfig;

public class Level_26_Environment extends BaseTest {
    EnvironmentConfig environmentConfig;

    @Parameters({"browser", "environment"})
    @BeforeClass
    public void beforeClass(String browserName, String environment) {
        ConfigFactory.setProperty("environment", environment);
        environmentConfig = ConfigFactory.create(EnvironmentConfig.class);
        driver = getBrowserDriver(browserName, environmentConfig.getAppUrl());

        System.out.println(environmentConfig.getAppUrl());
        System.out.println(environmentConfig.getAppUsername());
        System.out.println(environmentConfig.getAppPassword());

    }

    @Test
    public void User_01_Register() {

    }


    @Test
    public void User_02_Login() {


    }

    @Test
    public void User_03_MyAccount() {

    }


    @AfterClass
    public void afterClass() {
        driver.quit();
    }

    private WebDriver driver;
    private PropertiesConfig propertiesConfig;
}
