package pageObjects;

import commons.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import pageUIs.AddressPageUI;
import pageUIs.CustomerInfoPageUI;
import pageUIs.OrderPageUI;

public class AddressPageObject extends BasePage {
    private WebDriver driver;

    public AddressPageObject(WebDriver driver) {
        this.driver = driver;
    }

    public RewardPointPageObject openRewardPointPage() {
        waitForElementClickable(driver, AddressPageUI.REWARD_POINT_LINK);
        clickToElement(driver, AddressPageUI.REWARD_POINT_LINK);
        return PageGenerator.getRewardPointPage(driver);
    }

    public CustomerInfoPageObject openCustomerInfoPage() {
        waitForElementClickable(driver, OrderPageUI.ADDRESS_LINK);
        clickToElement(driver, OrderPageUI.ADDRESS_LINK);
        return PageGenerator.getCustomerInfoPage(driver);
    }
}
