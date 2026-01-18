package commons;

import com.google.common.base.Verify;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.Color;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import pageObjects.nopCommerce.PageGenerator;
import pageObjects.nopCommerce.users.UserAddressPO;
import pageObjects.nopCommerce.users.UserCustomerInfoPO;
import pageObjects.nopCommerce.users.UserOrderPO;
import pageObjects.nopCommerce.users.UserRewardPointPO;
import pageUIs.nopCommerce.UserBasePageUI;
import pageUIs.nopCommerce.users.UserSidebarPageUI;

import java.time.Duration;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;


public class BasePage {
    public static BasePage getBasePage() {
        return new BasePage();
    }

    public boolean isElementDisplayed(WebDriver driver) {
        return driver.findElement(By.cssSelector("")).isDisplayed();
    }

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
        return new WebDriverWait(driver, Duration.ofSeconds(GlobalConstants.LONG_TIMEOUT))
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

    protected WebElement getElement(WebDriver driver, String locator) {
        return driver.findElement(getByLocator(locator));
    }

    protected List<WebElement> getListElement(WebDriver driver, String locator) {
        return driver.findElements(getByLocator(locator));
    }

    protected List<WebElement> getListElement(WebDriver driver, String locator, String... restParameter) {
        return driver.findElements(getByLocator(castParameter(locator, restParameter)));
    }

    private String castParameter(String locator, String... restParameter) {
        return String.format(locator, (Object[]) restParameter);
    }

    private By getByLocator(String prefixLocator) {
        By by = null;
        if (prefixLocator.toUpperCase().startsWith("CSS")) {
            by = By.cssSelector(prefixLocator.substring(4));
        } else if (prefixLocator.toUpperCase().startsWith("ID")) {
            by = By.id(prefixLocator.substring(3));
        } else if (prefixLocator.toUpperCase().startsWith("CLASS")) {
            by = By.className(prefixLocator.substring(6));
        } else if (prefixLocator.toUpperCase().startsWith("TAGNAME")) {
            by = By.tagName(prefixLocator.substring(8));
        } else if (prefixLocator.toUpperCase().startsWith("XPATH")) {
            by = By.xpath(prefixLocator.substring(6));
        } else {
            throw new RuntimeException("Locator type is not support!!!");
        }
        return by;
    }

    public By getByXpath(String locator) {
        return getByLocator(locator);
    }

    public void clickToElement(WebDriver driver, String locator) {
        getElement(driver, locator).click();
    }

    public void clickToElement(WebDriver driver, String locator, String... restParameter) {
        getElement(driver, castParameter(locator, restParameter)).click();
    }

    public void sendKeysToElement(WebDriver driver, String locator, String valueToSendkey) {
        getElement(driver, locator).clear();
        getElement(driver, locator).sendKeys(valueToSendkey);
    }

    public void sendKeysToElement(WebDriver driver, String locator, String valueToSendkey, String... restParameter) {
        getElement(driver, castParameter(locator, restParameter)).clear();
        getElement(driver, castParameter(locator, restParameter)).sendKeys(valueToSendkey);
    }

    public void selectItemInDropDown(WebDriver driver, String locator, String textItem) {
        new Select(getElement(driver, locator))
                .selectByVisibleText(textItem);
    }

    public void selectItemInDropDown(WebDriver driver, String locator, String textItem, String... restParameter) {
        new Select(getElement(driver, castParameter(locator, restParameter)))
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
        driver.findElement(getByLocator(parentLocator)).click();
        sleepInSecond(2);
        List<WebElement> allItems = new WebDriverWait(driver, Duration.ofSeconds(GlobalConstants.LONG_TIMEOUT))
                .until(ExpectedConditions.presenceOfAllElementsLocatedBy(getByLocator(childItemLocator)));
        sleepInSecond(2);
        for (WebElement item : allItems) {
            if (item.getText().trim().equals(expectedItem)) {
                item.click();
                break;
            }
        }
    }

    private void sleepInSecond(int i) {
    }

    public void sleepInSeconds(long timeInSeconds) throws InterruptedException {
        Thread.sleep(timeInSeconds * 1000);
    }

    public String getElementAttribute(WebDriver driver, String locator, String attributeName) {
        return getElement(driver, locator).getAttribute(attributeName);
    }

    public String getElementAttribute(WebDriver driver, String locator, String attributeName, String... restParameter) {
        return getElement(driver, castParameter(locator, restParameter)).getAttribute(attributeName);
    }

    public String getElementText(WebDriver driver, String locator) {
        return getElement(driver, locator).getText();
    }

    public String getElementText(WebDriver driver, String locator, String... restParameter) {
        return getElement(driver, castParameter(locator, restParameter)).getText();
    }

    public String getElementCssValue(WebDriver driver, String locator, String propertyName) {
        return getElement(driver, locator).getCssValue(propertyName);
    }

    public String getHexaColorFromRGBA(String rgbaValue) {
        return Color.fromString(rgbaValue).asHex().toUpperCase();
    }

    public int getListElementNumber(WebDriver driver, String locator) {
        return getListElement(driver, locator).size();
    }

    public void checkToCheckboxRadio(WebDriver driver, String locator) {
        if (!getElement(driver, locator).isSelected()) {
            getElement(driver, locator).click();
        }
    }

    public void checkToCheckboxRadio(WebDriver driver, String locator, String... restParameter) {
        if (!getElement(driver, castParameter(locator, restParameter)).isSelected()) {
            getElement(driver, castParameter(locator, restParameter)).click();
        }
    }

    public void unCheckToCheckbox(WebDriver driver, String locator) {
        if (getElement(driver, locator).isSelected()) {
            getElement(driver, locator).click();
        }
    }

    public void unCheckToCheckbox(WebDriver driver, String locator, String... restParameter) {
        if (getElement(driver, castParameter(locator, restParameter)).isSelected()) {
            getElement(driver, castParameter(locator, restParameter)).click();
        }
    }

    public void overrideGlobalTimeout(WebDriver driver, long timeoutInSeconds) {
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(timeoutInSeconds));
    }

    public boolean isElementDisplayed(WebDriver driver, String locator) {

        return getElement(driver, locator).isDisplayed();
    }

    public boolean isElementUndisplayed(WebDriver driver, String locator) {
        overrideGlobalTimeout(driver, GlobalConstants.SHORT_TIMEOUT);
        List<WebElement> elements = getListElement(driver, locator);
        overrideGlobalTimeout(driver, GlobalConstants.LONG_TIMEOUT);

        if (elements.size() == 0) { //Case 3: Verify confirm Email textbox is not displayed
            return true;
        } else if (elements.size() > 0 && !elements.get(0).isDisplayed()) { //Case 2: Verify confirm Email textbox is not displayed
            return true;
        } else { //Case 1: Verify confirm Email textbox is displayed
            return false;
        }
    }

    public boolean isElementDisplayed(WebDriver driver, String locator, String... restParameter) {
        return getElement(driver, castParameter(locator, restParameter)).isDisplayed();
    }

    public boolean isElementSelected(WebDriver driver, String locator) {
        return getElement(driver, locator).isSelected();
    }

    public boolean isElementSelected(WebDriver driver, String locator, String... restParameter) {
        return getElement(driver, castParameter(locator, restParameter)).isSelected();
    }

    public void switchToFrame(WebDriver driver, String locator) {
        new Actions(driver).moveToElement(getElement(driver, locator)).perform();
    }

    public void clickAndHoldToElement(WebDriver driver, String locator) {
        new Actions(driver).clickAndHold(getElement(driver, locator)).perform();
    }

    public void releaseLeftMouse(WebDriver driver) {
        new Actions(driver).release();
    }

    public void clickToElementByAction(WebDriver driver, String locator) {
        new Actions(driver).click(getElement(driver, locator)).perform();
    }

    public void doubleClickToElement(WebDriver driver, String locator) {
        new Actions(driver).doubleClick(getElement(driver, locator)).perform();
    }

    public void rightClickToElement(WebDriver driver, String locator) {
        new Actions(driver).contextClick(getElement(driver, locator)).perform();
    }

    public void dragAndDropElement(WebDriver driver, String sourceLocator, String targetLocator) {
        new Actions(driver).dragAndDrop(getElement(driver, sourceLocator), getElement(driver, targetLocator)).perform();
    }

    public void pressKeyToElement(WebDriver driver, String locator, Keys keys) {
        new Actions(driver).sendKeys(getElement(driver, locator), keys).perform();
    }

    public void pressKeyToElement(WebDriver driver, String locator, Keys keys, String... restParameter) {
        new Actions(driver).sendKeys(getElement(driver,
                castParameter(locator, restParameter)), keys).perform();
    }

    public void scrollToElement(WebDriver driver, String locator) {
        new Actions(driver).scrollToElement(getElement(driver, locator)).perform();
    }

    public void hightlightElement(WebDriver driver, String locator) throws InterruptedException {
        WebElement element = getElement(driver, locator);
        String originalStyle = element.getAttribute("style");
        ((JavascriptExecutor) driver).executeScript("arguments[0].setAttribute('style', arguments[1])", element, "border: 2px solid red; border-style: dashed;");
        sleepInSeconds(2);
        ((JavascriptExecutor) driver).executeScript("arguments[0].setAttribute('style', arguments[1])", element, originalStyle);
    }

    public void clickToElementByJS(WebDriver driver, String locator) throws InterruptedException {
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", getElement(driver, locator));
        sleepInSeconds(3);
    }

    public void scrollToElementOnTopByJS(WebDriver driver, String locator) {
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", getElement(driver, locator));
    }

    public void scrollToElementOnDownByJS(WebDriver driver, String locator) {
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(false);", getElement(driver, locator));
    }

    public void scrollToBottomPageByJS(WebDriver driver) {
        ((JavascriptExecutor) driver).executeScript("window.scrollBy(0,document.body.scrollHeight)");
    }

    public void setAttributeInDOM(WebDriver driver, String locator, String attributeName, String attributeValue) {
        ((JavascriptExecutor) driver).executeScript("arguments[0].setAttribute('" + attributeName + "', '" + attributeValue + "');", getElement(driver, locator));
    }

    public void removeAttributeInDOM(WebDriver driver, String locator, String attributeRemove) {
        ((JavascriptExecutor) driver).executeScript("arguments[0].removeAttribute('" + attributeRemove + "');", getElement(driver, locator));
    }

    public void sendkeyToElementByJS(WebDriver driver, String locator, String value) {
        ((JavascriptExecutor) driver).executeScript("arguments[0].setAttribute('value', '" + value + "')", getElement(driver, locator));
    }

    public String getAttributeInDOMByJS(WebDriver driver, String locator, String attributeName) {
        return (String) ((JavascriptExecutor) driver).executeScript("return arguments[0].getAttribute('" + attributeName + "');", getElement(driver, locator));
    }

    public String getElementValidationMessage(WebDriver driver, String locator) {
        return (String) ((JavascriptExecutor) driver).executeScript("return arguments[0].validationMessage;", getElement(driver, locator));
    }

    public boolean isImageLoaded(WebDriver driver, String locator) {
        return (boolean) ((JavascriptExecutor) driver).executeScript("return arguments[0].complete " +
                        "&& typeof arguments[0].naturalWidth != 'undefined' && arguments[0].naturalWidth > 0",
                getElement(driver, locator));
    }

    public void waitForElementVisible(WebDriver driver, String locator) {
        new WebDriverWait(driver, Duration.ofSeconds(GlobalConstants.LONG_TIMEOUT))
                .until(ExpectedConditions.visibilityOfElementLocated(getByLocator(locator)));
    }

    public void waitForElementVisible(WebDriver driver, String locator, String... restParameter) {
        new WebDriverWait(driver, Duration.ofSeconds(GlobalConstants.LONG_TIMEOUT))
                .until(ExpectedConditions.visibilityOfElementLocated(getByLocator(castParameter(locator, restParameter))));
    }

    public void waitForElementAttribute(WebDriver driver, String locator, String attributeName, String attributeValue) {
        new WebDriverWait(driver, Duration.ofSeconds(GlobalConstants.LONG_TIMEOUT))
                .until(ExpectedConditions.attributeToBe(getByLocator(locator), attributeName, attributeValue));
    }

    public void waitForElementAttribute(WebDriver driver, String locator, String attributeName, String attributeValue,String... restParameter) {
        new WebDriverWait(driver, Duration.ofSeconds(GlobalConstants.LONG_TIMEOUT))
                .until(ExpectedConditions.attributeToBe(getByLocator(castParameter(locator, restParameter)), attributeName, attributeValue));
    }

    public void waitForElementSelected(WebDriver driver, String locator) {
        new WebDriverWait(driver, Duration.ofSeconds(GlobalConstants.LONG_TIMEOUT))
                .until(ExpectedConditions.elementToBeSelected(getByLocator(locator)));
    }

    public void waitForElementSelected(WebDriver driver, String locator, String... restParameter) {
        new WebDriverWait(driver, Duration.ofSeconds(GlobalConstants.LONG_TIMEOUT))
                .until(ExpectedConditions.elementToBeSelected(getByLocator(castParameter(locator, restParameter))));
    }

    public void waitForElementPresence(WebDriver driver, String locator) {
        new WebDriverWait(driver, Duration.ofSeconds(GlobalConstants.LONG_TIMEOUT))
                .until(ExpectedConditions.presenceOfElementLocated(getByLocator(locator)));
    }

    public void waitForElementInvisible(WebDriver driver, String locator) {
        new WebDriverWait(driver, Duration.ofSeconds(GlobalConstants.LONG_TIMEOUT))
                .until(ExpectedConditions.invisibilityOfElementLocated(getByLocator(locator)));
    }

    public void waitForElementClickable(WebDriver driver, String locator) {
        new WebDriverWait(driver, Duration.ofSeconds(GlobalConstants.LONG_TIMEOUT))
                .until(ExpectedConditions.elementToBeClickable(getByLocator(locator)));
    }

    public void waitForElementClickable(WebDriver driver, String locator, String... restParameter) {
        new WebDriverWait(driver, Duration.ofSeconds(GlobalConstants.LONG_TIMEOUT))
                .until(ExpectedConditions.elementToBeClickable(getByLocator(castParameter(locator, restParameter))));
    }

    public Set<Cookie> getAllCookies(WebDriver driver) {
        return driver.manage().getCookies();
    }

    public void setCookies(WebDriver driver, Set<Cookie> cookies) throws InterruptedException {
        for (Cookie cookie : cookies) {
            driver.manage().addCookie(cookie);
        }

        sleepInSeconds(3);
    }

    public void uploadMultipleFiles(WebDriver driver, String... fileNames) {
        String filePath = GlobalConstants.UPLOAD_PATH;
        String fullFileName = "";
        for (String file : fileNames) {
            fullFileName += filePath + file + "\n";
        }
        fullFileName = fullFileName.trim();
        getElement(driver, UserBasePageUI.UPLOAD_FILE_TYPE).sendKeys(fullFileName);
    }

    //Only use for Level_07
    public UserRewardPointPO openRewardPointPage(WebDriver driver) {
        waitForElementClickable(driver, UserBasePageUI.REWARD_POINT_LINK);
        clickToElement(driver, UserBasePageUI.REWARD_POINT_LINK);
        return PageGenerator.getUserRewardPointPage(driver);
    }

    public UserCustomerInfoPO openCustomerInfoPage(WebDriver driver) {
        waitForElementClickable(driver, UserBasePageUI.CUSTOMER_INFO_LINK);
        clickToElement(driver, UserBasePageUI.CUSTOMER_INFO_LINK);
        return PageGenerator.getUserCustomerInfoPage(driver);
    }

    public UserAddressPO openAddressPage(WebDriver driver) {
        waitForElementClickable(driver, UserSidebarPageUI.ADDRESS_LINK);
        clickToElement(driver, UserBasePageUI.ADDRESS_LINK);
        return PageGenerator.getUserAddressPage(driver);
    }

    public UserOrderPO openOrderPage(WebDriver driver) {
        waitForElementClickable(driver, UserSidebarPageUI.ORDER_PAGE_LINK);
        clickToElement(driver, UserBasePageUI.ORDER_PAGE_LINK);
        return PageGenerator.getUserOrderPage(driver);
    }


    public void enterToTextboxByID(WebDriver driver, String textboxID, String value) {
        waitForElementVisible(driver, UserBasePageUI.TEXTBOX_BY_ID, textboxID);
        sendKeysToElement(driver, UserBasePageUI.TEXTBOX_BY_ID, value, textboxID);
    }

    public void clickToButtonByText(WebDriver driver, String buttonText) {
        waitForElementClickable(driver, UserBasePageUI.BUTTON_BY_TEXT, buttonText);
        clickToElement(driver, UserBasePageUI.BUTTON_BY_TEXT, buttonText);

    }

    public void clickToRadioByID(WebDriver driver, String radioID) {
        waitForElementClickable(driver, UserBasePageUI.RADIO_BY_ID, radioID);
        checkToCheckboxRadio(driver, UserBasePageUI.RADIO_BY_ID, radioID);
    }

    public void clickToCheckboxByID(WebDriver driver, String checkboxID) {
        waitForElementClickable(driver, UserBasePageUI.CHECKBOX_BY_ID, checkboxID);
        checkToCheckboxRadio(driver, UserBasePageUI.CHECKBOX_BY_ID, checkboxID);
    }

    public String getTextboxValueByID(WebDriver driver, String textboxID) {
        waitForElementVisible(driver, UserBasePageUI.TEXTBOX_BY_ID, textboxID);
        return getElementAttribute(driver, UserBasePageUI.TEXTBOX_BY_ID, "value", textboxID);
    }

    public boolean isRadioByIDSelected(WebDriver driver, String radioID) {
        waitForElementSelected(driver, UserBasePageUI.RADIO_BY_ID, radioID);
        return isElementSelected(driver, UserBasePageUI.RADIO_BY_ID, radioID);
    }

    public boolean isCheckboxByIDSelected(WebDriver driver, String checkboxID) {
        waitForElementSelected(driver, UserBasePageUI.CHECKBOX_BY_ID, checkboxID);
        return isElementSelected(driver, UserBasePageUI.CHECKBOX_BY_ID, checkboxID);
    }
}