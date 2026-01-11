package pageObjects.nopCommerce.users;

import commons.BasePage;
import org.openqa.selenium.WebDriver;
import pageObjects.nopCommerce.PageGenerator;
import pageUIs.nopCommerce.users.UserLoginPageUI;

public class UserLoginPO extends BasePage {

    private WebDriver driver;

    public UserLoginPO(WebDriver driver) {
        this.driver = driver;
    }
    public void enterToEmailTextbox(String emailAddress) {
        waitForElementVisible(driver, UserLoginPageUI.EMAIL_TEXTBOX);
        sendKeysToElement(driver, UserLoginPageUI.EMAIL_TEXTBOX, emailAddress);
    }

    public void enterToPasswordTextBox(String passWord) {
        waitForElementVisible(driver, UserLoginPageUI.PASSWORD_TEXTBOX);
        sendKeysToElement(driver, UserLoginPageUI.PASSWORD_TEXTBOX, passWord);
    }
    public void clickToLoginButton() {
        waitForElementVisible(driver, UserLoginPageUI.LOGIN_BUTTON);
        clickToElement(driver, UserLoginPageUI.LOGIN_BUTTON);
    }
    public UserHomePO loginToSystem(String emailAddress, String password) {
        enterToEmailTextbox(emailAddress);
        enterToPasswordTextBox(password);
        clickToLoginButton();
        return PageGenerator.getUserHomePage(driver);

    }



    public void clickToLoginPage() {
        waitForElementVisible(driver, UserLoginPageUI.LOGIN_LINK);
        clickToElement(driver, UserLoginPageUI.LOGIN_LINK);
    }


}
