package pageObjects.facebook;

import commons.BasePage;
import org.openqa.selenium.WebDriver;
import pageUIs.facebook.LoginPageUI;

public class LoginPO extends BasePage {
    WebDriver driver;
    public LoginPO(WebDriver driver) {
        this.driver = driver;
    }

    public void clickToNewAccountButton() {
        waitForElementClickable(driver, LoginPageUI.CREATE_NEW_ACCOUNT_BUTTON);
        clickToElement(driver, LoginPageUI.CREATE_NEW_ACCOUNT_BUTTON);
    }

    public void enterToEmailTextbox(String emailAddress) {
        waitForElementClickable(driver, LoginPageUI.EMAIL_ADDRESS_TEXTBOX);
        sendKeysToElement(driver, LoginPageUI.EMAIL_ADDRESS_TEXTBOX, emailAddress);
    }

    public boolean isConfirmEmailTextboxDisplayed() {
        return isElementDisplayed(driver, LoginPageUI.CONFIRMATION_EMAIL_ADDRESS_TEXTBOX);
    }

    public boolean isConfirmEmailTextboxUndisplayed() {
        return isElementDisplayed(driver, LoginPageUI.CONFIRMATION_EMAIL_ADDRESS_TEXTBOX);
    }

    public void clickToCloseIcon() {
        waitForElementInvisible(driver, LoginPageUI.CLOSE_ICON);
        clickToElement(driver, LoginPageUI.CLOSE_ICON);
    }
}
