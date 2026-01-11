package pageObjects.nopCommerce.users;

import commons.BasePage;
import org.openqa.selenium.WebDriver;
import pageObjects.nopCommerce.PageGenerator;
import pageUIs.nopCommerce.users.UserRegisterPageUI;

public class UserRegisterPO extends BasePage {
    private WebDriver driver;

    public UserRegisterPO(WebDriver driver) {
        this.driver = driver;
    }

    public void clickToFemaleRadio() {
        waitForElementClickable(driver, UserRegisterPageUI.GENDER_FEMALE_RADIO);
        checkToCheckboxRadio(driver, UserRegisterPageUI.GENDER_FEMALE_RADIO);
    }

    public void enterToFirstNameTextBox(String firstName) {
        waitForElementClickable(driver, UserRegisterPageUI.FIRST_NAME_TEXTBOX);
        sendKeysToElement(driver, UserRegisterPageUI.FIRST_NAME_TEXTBOX, firstName);
    }

    public void enterToLastNameTextBox(String lastName) {
        waitForElementClickable(driver, UserRegisterPageUI.LAST_NAME_TEXTBOX);
        sendKeysToElement(driver, UserRegisterPageUI.LAST_NAME_TEXTBOX, lastName);
    }

    public void enterToEmailTextBox(String emailAddress) {
        waitForElementClickable(driver, UserRegisterPageUI.EMAIL_TEXTBOX);
        sendKeysToElement(driver, UserRegisterPageUI.EMAIL_TEXTBOX, emailAddress);
    }

    public void enterToCompanyTextBox(String company) {
        waitForElementClickable(driver, UserRegisterPageUI.COMPANY_TEXTBOX);
        sendKeysToElement(driver, UserRegisterPageUI.COMPANY_TEXTBOX, company);
    }

    public void enterToPasswordTextBox(String password) {
        waitForElementClickable(driver, UserRegisterPageUI.PASSWORD_TEXTBOX);
        sendKeysToElement(driver, UserRegisterPageUI.PASSWORD_TEXTBOX, password);
    }

    public void enterToConfirmPasswordTextBox(String confirmPassword) {
        waitForElementClickable(driver, UserRegisterPageUI.CONFIRM_PASSWORD_TEXTBOX);
        sendKeysToElement(driver, UserRegisterPageUI.CONFIRM_PASSWORD_TEXTBOX, confirmPassword);
    }

    public void clickToRegisterButton() {
        waitForElementClickable(driver, UserRegisterPageUI.REGISTER_BUTTON);
        clickToElement(driver, UserRegisterPageUI.REGISTER_BUTTON);
    }

    public String getRegisterSuccessMessage() {
        waitForElementClickable(driver, UserRegisterPageUI.REGISTER_SUCCESS_MESSAGE);
        return getElementText(driver, UserRegisterPageUI.REGISTER_SUCCESS_MESSAGE);
    }

    public UserHomePO clickToLogoutPage() {
        waitForElementClickable(driver, UserRegisterPageUI.LOGOUT_LINK);
        clickToElement(driver, UserRegisterPageUI.LOGOUT_LINK);
        return PageGenerator.getUserHomePage(driver);
    }

    public String getRegisterPageTitle() {
        waitForElementVisible(driver, UserRegisterPageUI.REGISTER_PAGE_TITLE);
        return getElementText(driver, UserRegisterPageUI.REGISTER_PAGE_TITLE);
    }
}
