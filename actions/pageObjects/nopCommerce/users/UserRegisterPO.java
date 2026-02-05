package pageObjects.nopCommerce.users;

import commons.BasePage;
import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import pageObjects.nopCommerce.PageGenerator;
import pageUIs.nopCommerce.users.UserLoginPageUI;
import pageUIs.nopCommerce.users.UserRegisterPageUI;
import pojo.UserInfo;

import java.util.List;

public class UserRegisterPO extends BasePage {
    private WebDriver driver;

    public UserRegisterPO(WebDriver driver) {
        this.driver = driver;
    }

    @Step("Click to Female radio button")
    public void clickToFemaleRadio() {
        waitForElementClickable(driver, UserRegisterPageUI.GENDER_FEMALE_RADIO);
        checkToCheckboxRadio(driver, UserRegisterPageUI.GENDER_FEMALE_RADIO);
    }

    @Step("Enter to First name textbox with value: {0}")
    public void enterToFirstNameTextBox(String firstName) {
        waitForElementClickable(driver, UserRegisterPageUI.FIRST_NAME_TEXTBOX);
        sendKeysToElement(driver, UserRegisterPageUI.FIRST_NAME_TEXTBOX, firstName);
    }

    @Step("Enter to Last name textbox with value: {0}")
    public void enterToLastNameTextBox(String lastName) {
        waitForElementClickable(driver, UserRegisterPageUI.LAST_NAME_TEXTBOX);
        sendKeysToElement(driver, UserRegisterPageUI.LAST_NAME_TEXTBOX, lastName);
    }

    @Step("Enter to Email address textbox with value: {0}")
    public void enterToEmailTextBox(String emailAddress) {
        waitForElementClickable(driver, UserRegisterPageUI.EMAIL_TEXTBOX);
        sendKeysToElement(driver, UserRegisterPageUI.EMAIL_TEXTBOX, emailAddress);
    }

    @Step("Enter to Company textbox with value: {0}")

    public void enterToCompanyTextBox(String company) {
        waitForElementClickable(driver, UserRegisterPageUI.COMPANY_TEXTBOX);
        sendKeysToElement(driver, UserRegisterPageUI.COMPANY_TEXTBOX, company);
    }

    @Step("Enter to Password textbox with value: {0}")
    public void enterToPasswordTextBox(String password) {
        waitForElementClickable(driver, UserRegisterPageUI.PASSWORD_TEXTBOX);
        sendKeysToElement(driver, UserRegisterPageUI.PASSWORD_TEXTBOX, password);
    }

    @Step("Enter to Confirm Password textbox with value: {0}")
    public void enterToConfirmPasswordTextBox(String confirmPassword) {
        waitForElementClickable(driver, UserRegisterPageUI.CONFIRM_PASSWORD_TEXTBOX);
        sendKeysToElement(driver, UserRegisterPageUI.CONFIRM_PASSWORD_TEXTBOX, confirmPassword);
    }

    @Step("Click to Register Button")
    public void clickToRegisterButton() {
        waitForElementClickable(driver, UserRegisterPageUI.REGISTER_BUTTON);
        clickToElement(driver, UserRegisterPageUI.REGISTER_BUTTON);
    }

    @Step("Get Register success message")
    public String getRegisterSuccessMessage() {
        waitForElementClickable(driver, UserRegisterPageUI.REGISTER_SUCCESS_MESSAGE);
        return getElementText(driver, UserRegisterPageUI.REGISTER_SUCCESS_MESSAGE);
    }

    @Step("Click to logout link")
    public UserHomePO clickToLogoutPage() {
        waitForElementClickable(driver, UserRegisterPageUI.LOGOUT_LINK);
        clickToElement(driver, UserRegisterPageUI.LOGOUT_LINK);
        return PageGenerator.getUserHomePage(driver);
    }

    @Step("Get Register Page Title")
    public String getRegisterPageTitle() {
        waitForElementVisible(driver, UserRegisterPageUI.REGISTER_PAGE_TITLE);
        return getElementText(driver, UserRegisterPageUI.REGISTER_PAGE_TITLE);
    }


    public void enterToRegisterForm(UserInfo userInfo) {
        clickToFemaleRadio();
        enterToFirstNameTextBox(userInfo.getFirstName());
        enterToLastNameTextBox(userInfo.getLastName());
        enterToEmailTextBox(userInfo.getEmailAddress());
        enterToCompanyTextBox(userInfo.getCompany());
        clickToCheckboxByID(driver, "NewsLetterSubscriptions_0__IsActive");
        enterToPasswordTextBox(userInfo.getPassword());
        enterToConfirmPasswordTextBox(userInfo.getPassword());
    }

    public void isLanguageDisplayed(List<String> skillTree) {
        for(String skill : skillTree);
    }
}
