package pageObjects.nopCommerce.users;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import pageUIs.nopCommerce.users.UserCustomerInfoPageUI;

public class UserCustomerInfoPO extends UserSidebarPO {
    private WebDriver driver;

    public UserCustomerInfoPO(WebDriver driver) {
        super(driver);
        this.driver = driver;
    }

    @Step("Verify Gender Female radio button is selected")
    public boolean isGenderFemaleSelected() {
        waitForElementSelected(driver, UserCustomerInfoPageUI.GENDER_FEMALE_RADIO);
        return isElementSelected(driver, UserCustomerInfoPageUI.GENDER_FEMALE_RADIO);
    }

    @Step("Get Firstname textbox Value")
    public String getFirstNameTextboxValue() {
        waitForElementVisible(driver, UserCustomerInfoPageUI.FIRST_NAME_TEXTBOX);
        return getElementAttribute(driver, UserCustomerInfoPageUI.FIRST_NAME_TEXTBOX, "value");
    }
    @Step("Get Lastname textbox Value")
    public String getLastNameTextboxValue() {
        waitForElementVisible(driver, UserCustomerInfoPageUI.LAST_NAME_TEXTBOX);
        return getElementAttribute(driver, UserCustomerInfoPageUI.LAST_NAME_TEXTBOX, "value");
    }

    @Step("Get Email textbox value")
    public String getEmailTextboxValue() {
        waitForElementVisible(driver, UserCustomerInfoPageUI.EMAIL_TEXTBOX);
        return getElementAttribute(driver, UserCustomerInfoPageUI.EMAIL_TEXTBOX, "value");
    }

    @Step("GetCompany textbox v  alue")
    public String getCompanyTextboxValue() {
        waitForElementVisible(driver, UserCustomerInfoPageUI.COMPANY_TEXTBOX);
        return getElementAttribute(driver, UserCustomerInfoPageUI.COMPANY_TEXTBOX, "value");
    }


}
