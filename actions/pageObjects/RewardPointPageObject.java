package pageObjects;

import commons.BasePage;
import org.openqa.selenium.WebDriver;
import pageUIs.AddressPageUI;
import pageUIs.RewardPointPageUI;

public class RewardPointPageObject extends BasePage {
    private WebDriver driver;

    public RewardPointPageObject(WebDriver driver) {
        this.driver = driver;
    }

    public OrderPageObject openOrderPage() {
        waitForElementClickable(driver, RewardPointPageUI.ORDER_PAGE_LINK);
        clickToElement(driver, RewardPointPageUI.ORDER_PAGE_LINK);
        return PageGenerator.getOrderPage(driver);

    }
}
