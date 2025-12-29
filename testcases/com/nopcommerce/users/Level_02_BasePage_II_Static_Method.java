package com.nopcommerce.users;

import commons.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.Random;

public class Level_02_BasePage_II_Static_Method {
    WebDriver driver;
    BasePage basePage;
    String emailAddress;
    String firstName;
    String lastName;
    String password;
    String company;

    @BeforeClass
    public void beforeClass() {
        driver = new FirefoxDriver();
        driver.get("http://localhost:8082/");
        basePage = BasePage.getBasePage();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        firstName = "binh";
        lastName = "nguyen";
        password = "Abc13579";
        company = "Goyoung";
        emailAddress = "nhubinh" + generateRandomNumber() + "@gmail.com";
    }

    @Test
    public void user_01_Register() {
        basePage.waitForElementClickable(driver, "//a[@class='ico-register']");
        basePage.clickToElement(driver, "//a[@class='ico-register']");

        basePage.waitForElementClickable(driver, "//input[@id='gender-female']");
        basePage.clickToElement(driver, "//input[@id='gender-female']");

        basePage.sendKeysToElement(driver, "//input[@id='FirstName']", firstName);
        basePage.sendKeysToElement(driver, "//input[@id='LastName']", lastName);

        basePage.sendKeysToElement(driver, "//input[@id='Email']", emailAddress);
        basePage.sendKeysToElement(driver, "//input[@id='Company']", company);

        basePage.sendKeysToElement(driver, "//input[@id='Password']", password);
        basePage.sendKeysToElement(driver, "//input[@id='ConfirmPassword']", password);

        basePage.waitForElementClickable(driver, "//button[@id='register-button']");

        basePage.clickToElement(driver, "//button[@id='register-button']");

        Assert.assertEquals(basePage.getText(driver, "//div[@class='result']"), "Your registration completed");
    }

    @Test
    public void user_02_Login() {
        basePage.waitForElementClickable(driver, "//a[@class='ico-logout']");
        basePage.clickToElement(driver, "//a[@class='ico-logout']");

        basePage.waitForElementClickable(driver, "//a[@class='ico-login']");
        basePage.clickToElement(driver, "//a[@class='ico-login']");

        basePage.sendKeysToElement(driver, "//input[@id='Email']", emailAddress);
        basePage.sendKeysToElement(driver, "//input[@id='Password']", password);

        basePage.waitForElementClickable(driver, "//button[text()='Log in']");
        basePage.clickToElement(driver, "//button[text()='Log in']");

        Assert.assertTrue(basePage.isElementDisplayed(driver, "//a[@class='ico-account' and text()='My account']"));
    }

    @Test
    public void user_03_MyAccount() {
        basePage.waitForElementClickable(driver, "//a[@class='ico-account']");
        basePage.clickToElement(driver, "//a[@class='ico-account']");

        Assert.assertTrue(basePage.isElementSelected(driver, "//input[@id='gender-female']"));
        Assert.assertEquals(basePage.getElementAttribute(driver, "//input[@id='FirstName']", "value"), firstName);
        Assert.assertEquals(basePage.getElementAttribute(driver, "//input[@id='LastName']", "value"), lastName);
        Assert.assertEquals(basePage.getElementAttribute(driver, "//input[@id='Email']", "value"), emailAddress);
        Assert.assertEquals(basePage.getElementAttribute(driver, "//input[@id='Company']", "value"), company);
    }


    @AfterClass
    public void afterClass() {
        driver.quit();
    }


    private int generateRandomNumber() {
        Random rand = new Random();
        int randomNumber = rand.nextInt(99999);
        return randomNumber;
    }


}
