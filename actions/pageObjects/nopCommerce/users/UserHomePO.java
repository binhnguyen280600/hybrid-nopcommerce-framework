package pageObjects.nopCommerce.users;

import commons.BasePage;
import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import pageObjects.nopCommerce.PageGenerator;
import pageUIs.nopCommerce.users.UserHomePageUI;

public class UserHomePO extends BasePage {

    private WebDriver driver;

    public UserHomePO(WebDriver driver) {
        this.driver = driver;
    }

    @Step("Open Register Page")
    public UserRegisterPO clickToRegisterPage() {
        waitForElementClickable(driver, UserHomePageUI.REGISTER_LINK);
        clickToElement(driver, UserHomePageUI.REGISTER_LINK);
        return PageGenerator.getUserRegisterPage(driver);
    }

    @Step("Verify My Account Link is displayed")
    public boolean isMyAccountLinkDisplayed() {
        waitForElementClickable(driver, UserHomePageUI.MY_ACCOUNT_LINK);
        return isElementDisplayed(driver, UserHomePageUI.MY_ACCOUNT_LINK);
    }

    @Step("Open Customer Info Page")
    public UserCustomerInfoPO clickToMyAccountPage() {
        waitForElementClickable(driver, UserHomePageUI.MY_ACCOUNT_LINK);
        clickToElement(driver, UserHomePageUI.MY_ACCOUNT_LINK);
        return PageGenerator.getUserCustomerInfoPage(driver);
    }

    @Step("Open Login Page")
    public UserLoginPO openLoginPage() {
        waitForElementClickable(driver, UserHomePageUI.LOGIN_LINK);
        clickToElement(driver, UserHomePageUI.LOGIN_LINK);
        return PageGenerator.getUserLoginPage(driver);
    }


}
