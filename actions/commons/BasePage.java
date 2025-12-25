package commons;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import javax.lang.model.element.Element;
import java.time.Duration;
import java.util.List;
import java.util.Set;


public class BasePage {
    //function (Hàm dùng chung) cho nhiều class khác
    public boolean isElementDisplayed(WebDriver driver) {
        return driver.findElement(By.cssSelector("")).isDisplayed();
    }

    //function (Hàm dùng chung) cho nhiều class khác
    public void openPageUrl(WebDriver driver, String url) {
        driver.get(url);
    }

//    openPageUrl(driver, "https://demo.nopcommerce.com/")
//    openPageUrl(driver, "https://demo.nopcommerce.com/electronics")
//    openPageUrl(driver, "https://demo.nopcommerce.com/digital-downloads")

    //Ko truyền 1 dữ liệu cụ thể riêng tư vào đc
    public void openUrl(WebDriver driver) {
        driver.get("https://demo.nopcommerce.com/");
    }

    public String getPageTilte(WebDriver driver) {
        return driver.getTitle();
    }

    public String getPageUrl(WebDriver driver) {
        return driver.getCurrentUrl();
    }

    public String getPageSource(WebDriver driver) {
        return driver.getPageSource();
    }

    public void backToPage(WebDriver driver) {
        driver.navigate().back();
    }

    public void forwardToPage(WebDriver driver) {
        driver.navigate().forward();
    }

    public void refreshToPage(WebDriver driver) {
        driver.navigate().refresh();
    }

    public Alert waitAlertPresence(WebDriver driver) {
        return new WebDriverWait(driver, Duration.ofSeconds(15))
                .until(ExpectedConditions.alertIsPresent());
    }

    public void acceptToAlert(WebDriver driver) {
        //chỉ switch ko wait
        driver.switchTo().alert().accept();

        //wait cho xuất hiện alert rồi switch vào
        waitAlertPresence(driver).accept();
    }

    public void cancelToAlert(WebDriver driver) {
        waitAlertPresence(driver).dismiss();
    }

    public String getAlertText(WebDriver driver) {
        return waitAlertPresence(driver).getText();
    }

    public void getAlertText(WebDriver driver, String keyToSend) {
        waitAlertPresence(driver).sendKeys("");
    }

    public void switchToWindowByID(WebDriver driver, String parentID) {
        Set<String> allWindows = driver.getWindowHandles();
        for (String runWindow : allWindows) {
            if (!runWindow.equals(parentID)) {
                driver.switchTo().window(runWindow);
                break;
            }
        }
    }

    public void switchToWindowByTitle(WebDriver driver, String title) {
        Set<String> allWindows = driver.getWindowHandles();
        for (String runWindows : allWindows) {
            driver.switchTo().window(runWindows);
            String currentWin = driver.getTitle();
            if (currentWin.equals(title)) {
                break;
            }
        }
    }

    public void closeAllWindowsWithoutParent(WebDriver driver, String parentID) {
        Set<String> allWindows = driver.getWindowHandles();
        for (String runWindows : allWindows) {
            if (!runWindows.equals(parentID)) {
                driver.switchTo().window(runWindows);
                driver.close();
            }
        }
        driver.switchTo().window(parentID);
    }

    public WebElement getElement(WebDriver driver, String locator) {
        return driver.findElement(By.xpath(locator));
    }

    public void clickToElement(WebDriver driver, String locator) {
        getElement(driver, locator).click();
    }

    public void sendKeysToElement(WebDriver driver, String keysToSend, String locator) {
        getElement(driver, locator).sendKeys(keysToSend);
    }

    public void selectItemInDropDown(WebDriver driver, String locator, String textItem) {
        new Select(getElement(driver, locator))
                .selectByVisibleText(textItem);
    }

    public String getSelectItemInDropDown(WebDriver driver, String locator) {
       return new Select(getElement(driver, locator))
                .getFirstSelectedOption().getText();
    }

    public boolean dropDownMultiple(WebDriver driver, String locator) {
        return new Select(getElement(driver, locator)).isMultiple();
    }

    public void selectItemInCustomDropdown(WebDriver driver, String parentLocator, String childItemLocator, String expectedItem) throws InterruptedException {
        driver.findElement(By.xpath(parentLocator)).click();
        sleepInSecond(2);
        List<WebElement> allItems = new WebDriverWait(driver, Duration.ofSeconds(15))
                .until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath(childItemLocator)));
        sleepInSecond(2);
        for (WebElement item : allItems) {
            if (item.getText().trim().equals(expectedItem)) {
                item.click();
                break;
            }
        }
    }

    public void sleepInSecond(long timeInSeconds ) throws InterruptedException {
        Thread.sleep(timeInSeconds *1000);
    }

}
