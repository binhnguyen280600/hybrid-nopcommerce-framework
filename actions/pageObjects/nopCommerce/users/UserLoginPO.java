package pageObjects.nopCommerce.users;

import commons.BasePage;
import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import pageObjects.nopCommerce.PageGenerator;
import pageUIs.nopCommerce.users.UserLoginPageUI;
import pojo.UserInfo;

public class UserLoginPO extends BasePage {

    private WebDriver driver;

    public UserLoginPO(WebDriver driver) {
        this.driver = driver;
    }

    @Step("Enter to Email address textbox with value: {0}")
    public void enterToEmailTextbox(String emailAddress) {
        waitForElementVisible(driver, UserLoginPageUI.EMAIL_TEXTBOX);
        sendKeysToElement(driver, UserLoginPageUI.EMAIL_TEXTBOX, emailAddress);
    }

    @Step("Enter to Password textbox with value: {0}")
    public void enterToPasswordTextBox(String passWord) {
        waitForElementVisible(driver, UserLoginPageUI.PASSWORD_TEXTBOX);
        sendKeysToElement(driver, UserLoginPageUI.PASSWORD_TEXTBOX, passWord);
    }

    @Step("Click to Login Button")
    public UserHomePO clickToLoginButton() {
        waitForElementVisible(driver, UserLoginPageUI.LOGIN_BUTTON);
        clickToElement(driver, UserLoginPageUI.LOGIN_BUTTON);
        return PageGenerator.getUserHomePage(driver);
    }

    @Step("Login to application with valid Email and Password")
    public UserHomePO loginToSystem(String emailAddress, String password) {
        enterToEmailTextbox(emailAddress);
        enterToPasswordTextBox(password);
        clickToLoginButton();
        return PageGenerator.getUserHomePage(driver);

    }

    @Step("Click to Login Page")
    public void clickToLoginPage() {
        waitForElementVisible(driver, UserLoginPageUI.LOGIN_LINK);
        clickToElement(driver, UserLoginPageUI.LOGIN_LINK);
    }


    public UserHomePO enterToLoginForm(UserInfo userInfo) {
        enterToEmailTextbox(userInfo.getEmailAddress());
        enterToPasswordTextBox(userInfo.getPassword());
        clickToLoginButton();
        return PageGenerator.getUserHomePage(driver);

    }
}
