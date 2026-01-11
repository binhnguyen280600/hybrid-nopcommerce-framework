package com.jquey.cases;

import commons.BaseTest;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import pageObjects.jquery.HomePO;
import pageObjects.jquery.PageGenerator;

public class Level_12_Upload extends BaseTest {

    @Parameters({"browser", "url"})
    @BeforeClass
    public void beforeClass(String browserName, String url) {
        driver = getBrowserDriver(browserName, url);

        homePage = PageGenerator.getHomePage(driver);

        hue = "HaNoi.jpg";
        hanoi = "HoChiMinh.jpg";
        hochiminh = "Hue.jpg";
    }

    @Test
    public void Upload_01() throws InterruptedException {

        homePage.uploadMultipleFiles(driver, hue);
        homePage.sleepInSeconds(3);
        homePage.refreshToPage(driver);


        homePage.uploadMultipleFiles(driver, hue, hanoi, hochiminh);
        homePage.sleepInSeconds(3);

        Assert.assertTrue(homePage.isFileLoadedByName(hue));
        Assert.assertTrue(homePage.isFileLoadedByName(hanoi));
        Assert.assertTrue(homePage.isFileLoadedByName(hochiminh));

        homePage.clickToUpLoadButton(driver);

        Assert.assertTrue(homePage.isFileUploadedByName(hue));
        Assert.assertTrue(homePage.isFileUploadedByName(hanoi));
        Assert.assertTrue(homePage.isFileUploadedByName(hochiminh));
    }

   @Test
    public void Table_02_Search()  {


    }

    @AfterClass
    public void afterClass() {
        driver.quit();
    }

    private WebDriver driver;
    private HomePO homePage;
    private String hue, hanoi, hochiminh;
}
