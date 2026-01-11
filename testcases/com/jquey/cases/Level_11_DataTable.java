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

public class Level_11_DataTable extends BaseTest {

    @Parameters({"browser", "url"})
    @BeforeClass
    public void beforeClass(String browserName, String url) {
        driver = getBrowserDriver(browserName, url);

        homePage = PageGenerator.getHomePage(driver);
    }

    //@Test
    public void Table_01_Paging() throws InterruptedException {
        homePage.openPageByNumber("12");
        Assert.assertTrue(homePage.isPageNumberActive("12"));

        homePage.openPageByNumber("15");
        Assert.assertTrue(homePage.isPageNumberActive("15"));

        homePage.openPageByNumber("11");
        Assert.assertTrue(homePage.isPageNumberActive("11"));
    }

   // @Test
    public void Table_02_Search() throws InterruptedException {
        homePage.enterToTextboxByHeaderName("Country", "Albania");
        homePage.sleepInSeconds(2);
        Assert.assertTrue(homePage.isRowDataValueDisplayed("24128", "Albania","25266","49397"));
        homePage.refreshToPage(driver);

        homePage.enterToTextboxByHeaderName("Males", "12599691");
        homePage.sleepInSeconds(2);
        Assert.assertTrue(homePage.isRowDataValueDisplayed("12253515", "AFRICA","12599691","24853148"));
        homePage.refreshToPage(driver);

        homePage.enterToTextboxByHeaderName("Females", "764956");
        Assert.assertTrue(homePage.isRowDataValueDisplayed("764956", "Arab Rep of Egypt","802948","1567904"));

        homePage.sleepInSeconds(2);
        homePage.refreshToPage(driver);

    }

    //@Test
    public void Table_03_Edit_Delete() throws InterruptedException {
        homePage.enterToTextboxByHeaderName("Country", "AFRICA");
        homePage.sleepInSeconds(2);
        homePage.deleteRowByCountryName("AFRICA");
        homePage.refreshToPage(driver);

        homePage.enterToTextboxByHeaderName("Country", "Angola");
        homePage.sleepInSeconds(2);
        homePage.deleteRowByCountryName("Angola");
        homePage.refreshToPage(driver);
        homePage.sleepInSeconds(2);

        homePage.enterToTextboxByHeaderName("Country", "Armenia");
        homePage.sleepInSeconds(2);
        homePage.editRowByCountryName("Armenia");
        homePage.sleepInSeconds(2);
    }
    @Test
    public void Table_04_Get_All_Value_Row_Or_Column() throws InterruptedException {
        homePage.getAllValueAtColumnName("Country");
    }
//    @Test
    public void Table_05_Action_By_Index() throws InterruptedException {
        homePage.openPageUrl(driver, "https://www.jqueryscript.net/demo/jQuery-Dynamic-Data-Grid-Plugin-appendGrid/#google_vignette");

        homePage.clickToLoadDataButton();
        homePage.sleepInSeconds(2);

        homePage.enterToTextBoxByIndex("4", "Contact Person", "Binh");
        homePage.sleepInSeconds(2);

        homePage.enterToTextBoxByIndex("2", "Company", "Go young");
        homePage.sleepInSeconds(2);

        homePage.enterToTextBoxByIndex("3", "Order Placed", "984");
        homePage.sleepInSeconds(2);

        homePage.selectToDropDownByIndex("6", "Country", "Hong Kong");

        homePage.selectToDropDownByIndex("8", "Country", "United Kingdom");

        homePage.checkToCheckboxByIndex("6", "NPO?", true);

        homePage.checkToCheckboxByIndex("5", "NPO?", false);

        homePage.clickToIconByIndex("8", "Move Up");

        homePage.clickToIconByIndex("6", "Remove");

        homePage.clickToIconByIndex("4", "Insert");

    }

    @AfterClass
    public void afterClass() {
        driver.quit();
    }

    private WebDriver driver;
    private HomePO homePage;
}
