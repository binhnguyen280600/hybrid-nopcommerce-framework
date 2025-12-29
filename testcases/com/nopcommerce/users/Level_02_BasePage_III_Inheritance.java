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

public class Level_02_BasePage_III_Inheritance extends BasePage{
    WebDriver driver;
    String emailAddress;
    String firstName;
    String lastName;
    String password;
    String company;

    @BeforeClass
    public void beforeClass() {
        driver = new FirefoxDriver();
        driver.get("http://localhost:8082/");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        firstName = "binh";
        lastName = "nguyen";
        password = "Abc13579";
        company = "Goyoung";
        emailAddress = "nhubinh" + generateRandomNumber() + "@gmail.com";
    }

    @Test
    public void user_01_Register() {
        waitForElementClickable(driver, "//a[@class='ico-register']");
        clickToElement(driver, "//a[@class='ico-register']");

        waitForElementClickable(driver, "//input[@id='gender-female']");
        clickToElement(driver, "//input[@id='gender-female']");

        sendKeysToElement(driver, "//input[@id='FirstName']", firstName);
        sendKeysToElement(driver, "//input[@id='LastName']", lastName);

        sendKeysToElement(driver, "//input[@id='Email']", emailAddress);
        sendKeysToElement(driver, "//input[@id='Company']", company);

        sendKeysToElement(driver, "//input[@id='Password']", password);
        sendKeysToElement(driver, "//input[@id='ConfirmPassword']", password);

        waitForElementClickable(driver, "//button[@id='register-button']");

        clickToElement(driver, "//button[@id='register-button']");

        Assert.assertEquals(getText(driver, "//div[@class='result']"), "Your registration completed");
    }

    @Test
    public void user_02_Login() {
        waitForElementClickable(driver, "//a[@class='ico-logout']");
        clickToElement(driver, "//a[@class='ico-logout']");

        waitForElementClickable(driver, "//a[@class='ico-login']");
        clickToElement(driver, "//a[@class='ico-login']");

        sendKeysToElement(driver, "//input[@id='Email']", emailAddress);
        sendKeysToElement(driver, "//input[@id='Password']", password);

        waitForElementClickable(driver, "//button[text()='Log in']");
        clickToElement(driver, "//button[text()='Log in']");

        Assert.assertTrue(isElementDisplayed(driver, "//a[@class='ico-account' and text()='My account']"));
    }

    @Test
    public void user_03_MyAccount() {
        waitForElementClickable(driver, "//a[@class='ico-account']");
        clickToElement(driver, "//a[@class='ico-account']");

        Assert.assertTrue(isElementSelected(driver, "//input[@id='gender-female']"));
        Assert.assertEquals(getElementAttribute(driver, "//input[@id='FirstName']", "value"), firstName);
        Assert.assertEquals(getElementAttribute(driver, "//input[@id='LastName']", "value"), lastName);
        Assert.assertEquals(getElementAttribute(driver, "//input[@id='Email']", "value"), emailAddress);
        Assert.assertEquals(getElementAttribute(driver, "//input[@id='Company']", "value"), company);
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
