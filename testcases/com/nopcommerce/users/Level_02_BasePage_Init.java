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

public class Level_02_BasePage_Init {
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
        basePage = new BasePage();
        driver.get("https://demo.nopcommerce.com/");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        firstName = "binh";
        lastName = "nguyen";
        password = "Abc13579";
        company = "Goyoung";
        emailAddress = "nhubinh" + generateRandomNumber() + "gmail.com";
    }

    @Test
    public void user_01_Register() {
        basePage.waitForElementClickable(driver, "//a[@class='ico-register']");
        basePage.clickToElement(driver, "//a[@class='ico-register']");

        basePage.waitForElementClickable(driver, "//input[@id='gender-female']");
        basePage.clickToElement(driver, "//input[@id='gender-female']");

        basePage.sendKeysToElement(driver, "//input[@id='FirstName']", "binh");
        basePage.sendKeysToElement(driver, "//input[@id='LastName']", "nguyen");

        basePage.sendKeysToElement(driver, "//input[@id='Email']", emailAddress);
        basePage.sendKeysToElement(driver, "//input[@id='Company']", company);

        basePage.sendKeysToElement(driver, "//input[@id='Password']", password);
        basePage.sendKeysToElement(driver, "//input[@id='ConfirmPassword']", password);

        basePage.waitForElementClickable(driver, "//button[@id='register-button']");

        basePage.clickToElement(driver, "//button[@id='register-button']");

        Assert.assertEquals(basePage.getText(driver, "//div[@class='result']"), "Your registration completed");
    }

    public void user_02_Login() {
        basePage.waitForElementClickable(driver, "//a[@class='ico-login']");
        basePage.clickToElement(driver, "//a[@class='ico-login']");

        basePage.sendKeysToElement(driver, "//input[@id='Email']", emailAddress);
        basePage.sendKeysToElement(driver, "//input[@id='Password']", password);

        basePage.waitForElementClickable(driver, "");
        basePage.clickToElement(driver, "");


    }

    public void user_03_MyAccount() {

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
