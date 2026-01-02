package pageFactory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CustomerInfoPageFactory extends BasePage {

    WebDriver driver;

    public CustomerInfoPageFactory(WebDriver driver) {
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

    public boolean isGenderFemaleSelected() {
        waitForElementVisible(driver, genderFemaleRadio);
        return isElementSelected(genderFemaleRadio);
    }

    public String getFirstNameTextboxValue() {
        waitForElementVisible(driver, firstNameTextBox);
        return getElementAttribute(firstNameTextBox, "value");
    }

    public String getLastNameTextboxValue() {
        waitForElementVisible(driver, lastNameTextBox);
        return getElementAttribute(lastNameTextBox, "value");
    }

    public String getEmailTextboxValue() {
        waitForElementVisible(driver, emailTextBox);
        return getElementAttribute(emailTextBox, "value");
    }


    public String getCompanyTextboxValue() {
        waitForElementVisible(driver, companyTextBox);
        return getElementAttribute(companyTextBox, "value");
    }
}
