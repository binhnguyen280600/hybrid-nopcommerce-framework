package pageFactory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class RegisterPageFactory extends BasePage {

    WebDriver driver;

    public RegisterPageFactory(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
    @FindBy(id = "gender-female")
    private WebElement genderFemaleRadio;

    @FindBy(id = "FirstName")
    private WebElement firstNameTextBox;

    @FindBy(id = "LastName")
    private WebElement lastNameTextBox;

    @FindBy(id = "Email")
    private WebElement emailTextBox;

    @FindBy(id = "Company")
    private WebElement companyTextBox;

    @FindBy(id = "Password")
    private WebElement passwordTextBox;

    @FindBy(id = "ConfirmPassword")
    private WebElement confirmPasswordTextBox;

    @FindBy(id = "register-button")
    private WebElement registerButton;

    @FindBy(xpath = "//div[@class='result']")
    private WebElement registerSuccessMessage;

    @FindBy(xpath = "//a[@class='ico-logout']")
    private WebElement logoutLink;

    public void clickToFemaleRadio() {
        waitForElementClickable(driver, genderFemaleRadio);
        clickToElement(genderFemaleRadio);
    }

    public void enterToFirstNameTextBox(String firstName) {
        waitForElementClickable(driver, firstNameTextBox);
        sendKeyToElement(firstNameTextBox, firstName);
    }

    public void enterToLastNameTextBox(String lastName) {
        waitForElementClickable(driver, lastNameTextBox);
        sendKeyToElement(lastNameTextBox, lastName);
    }

    public void enterToEmailTextBox(String emailAddress) {
        waitForElementClickable(driver, emailTextBox);
        sendKeyToElement(emailTextBox, emailAddress);
    }

    public void enterToCompanyTextBox(String company) {
        waitForElementClickable(driver, companyTextBox);
        sendKeyToElement(companyTextBox,company);
    }

    public void enterToPasswordTextBox(String password) {
        waitForElementClickable(driver, passwordTextBox);
        sendKeyToElement(passwordTextBox, password);
    }

    public void enterToConfirmPasswordTextBox(String confirmPassword) {
        waitForElementClickable(driver, confirmPasswordTextBox);
        sendKeyToElement(confirmPasswordTextBox, confirmPassword);
    }

    public void clickToRegisterButton() {
        waitForElementClickable(driver, registerButton);
        clickToElement(registerButton);
    }

    public String getRegisterSuccessMessage() {
        waitForElementVisible(driver, registerSuccessMessage);
        return registerSuccessMessage.getText();
    }

    public void clickToLogoutLink() {
        waitForElementClickable(driver, logoutLink);
        clickToElement(logoutLink);
    }
}
