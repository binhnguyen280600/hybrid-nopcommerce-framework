package pageObjects.orangehrm.pim.employee;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import pageUIs.orangehrm.pim.employee.PersonalDetailsPUI;

public class PersonalDetailsPO extends EmployeeTabs {

    private WebDriver driver;

    public PersonalDetailsPO(WebDriver driver) {
        super(driver);
        this.driver = driver;
    }


    public Dimension getAvatarSize() {
        return getElementSize(driver, PersonalDetailsPUI.EMPLOYEE_AVATAR_IMAGE);
    }

    public void clickToEmployeeAvatarImage() {
        waitForElementClickable(driver, PersonalDetailsPUI.EMPLOYEE_AVATAR_IMAGE);
        clickToElement(driver, PersonalDetailsPUI.EMPLOYEE_AVATAR_IMAGE);
    }

    public void clickToSaveButtonAtProfilePictureContainer() {
        waitForElementClickable(driver, PersonalDetailsPUI.SAVE_BUTTON_AT_PROFILE_PICTURE_CONTAINER);
        clickToElement(driver, PersonalDetailsPUI.SAVE_BUTTON_AT_PROFILE_PICTURE_CONTAINER);
    }

    public boolean isProfileAvatarUpdateSuccess(Dimension beforeUpload) {
        waitForElementVisible(driver, PersonalDetailsPUI.EMPLOYEE_AVATAR_IMAGE);
        Dimension afterUpload = getAvatarSize();
        return !beforeUpload.equals(afterUpload);
    }

    public void enterToFirstNameTextbox(String firstName) {
        waitForElementVisible(driver, PersonalDetailsPUI.FIRST_NAME_TEXTBOX);
        sendKeysToElement(driver, PersonalDetailsPUI.FIRST_NAME_TEXTBOX, firstName);
    }

    public void enterToLastNameTextbox(String lastName) {
        waitForElementVisible(driver, PersonalDetailsPUI.LAST_NAME_TEXTBOX);
        sendKeysToElement(driver, PersonalDetailsPUI.LAST_NAME_TEXTBOX, lastName);
    }

    public String getEmployeeID() {
        waitForElementVisible(driver, PersonalDetailsPUI.EMPLOYEE_ID_TEXTBOX);
        return getElementAttribute(driver, PersonalDetailsPUI.EMPLOYEE_ID_TEXTBOX, "value");
    }

    public void enterToDriverLicenseTextbox(String LicenseNumber) {
        waitForElementVisible(driver, PersonalDetailsPUI.DRIVER_LICENSE_TEXTBOX);
        sendKeysToElement(driver, PersonalDetailsPUI.DRIVER_LICENSE_TEXTBOX, LicenseNumber);
    }

    public void enterToLicenseExpiryDateTextbox(String LicenseExpiryDate) {
        waitForElementVisible(driver, PersonalDetailsPUI.LICENSE_EXPIRY_TEXTBOX);
        sendKeysToElement(driver, PersonalDetailsPUI.LICENSE_EXPIRY_TEXTBOX, LicenseExpiryDate);
    }

    public void selectNationalityDropdown(String nationality) {
        waitForElementClickable(driver, PersonalDetailsPUI.NATIONALITY_DROPDOWN_PARENT);
        selectItemInCustomDropdown(driver, PersonalDetailsPUI.NATIONALITY_DROPDOWN_PARENT, PersonalDetailsPUI.NATIONALITY_DROPDOWN_CHILD, nationality);
    }

    public void selectMaritalStatusDropdown(String maritalStatus) {
        waitForElementClickable(driver, PersonalDetailsPUI.MARITAL_STATUS_DROPDOWN_PARENT);
        selectItemInCustomDropdown(driver, PersonalDetailsPUI.MARITAL_STATUS_DROPDOWN_PARENT, PersonalDetailsPUI.MARITAL_STATUS_DROPDOWN_CHILD, maritalStatus);
    }

    public void enterToDateOfBirthTextbox(String dateOfBirth) {
        waitForElementVisible(driver, PersonalDetailsPUI.DATE_OF_BIRTH_TEXTBOX);
        sendKeysToElement(driver, PersonalDetailsPUI.DATE_OF_BIRTH_TEXTBOX, dateOfBirth);
    }

    public void selectGenderMaleRadioButton(String gender) throws InterruptedException {
        clickToElementByJS(driver,PersonalDetailsPUI.GENDER_RADIO_BUTTON, gender);
    }

    public void clickSaveButtonAtPersonalDetailContainer() {
        waitForElementClickable(driver, PersonalDetailsPUI.SAVE_BUTTON_AT_CHANGE_PERSONAL_DETAILS);
        clickToElement(driver, PersonalDetailsPUI.SAVE_BUTTON_AT_CHANGE_PERSONAL_DETAILS);
    }

    public String getFirstNameTextboxValue() {
        waitForElementVisible(driver, PersonalDetailsPUI.FIRST_NAME_TEXTBOX);
        return getElementAttribute(driver, PersonalDetailsPUI.FIRST_NAME_TEXTBOX, "value");
    }

    public String getLastNameTextboxValue() {
        waitForElementVisible(driver, PersonalDetailsPUI.LAST_NAME_TEXTBOX);
        return getElementAttribute(driver, PersonalDetailsPUI.LAST_NAME_TEXTBOX, "value");
    }

    public String getDriverLicenseTextboxValue() {
        waitForElementVisible(driver, PersonalDetailsPUI.DRIVER_LICENSE_TEXTBOX);
        return getElementAttribute(driver, PersonalDetailsPUI.DRIVER_LICENSE_TEXTBOX, "value");
    }

    public String getLicenseExpiryDateTextboxValue() {
        waitForElementVisible(driver, PersonalDetailsPUI.LICENSE_EXPIRY_TEXTBOX);
        return getElementAttribute(driver, PersonalDetailsPUI.LICENSE_EXPIRY_TEXTBOX, "value");
    }

    public String getNationalityDropdownValue() {
        waitForElementVisible(driver, PersonalDetailsPUI.NATIONALITY_DROPDOWN_ITEM_SELECTED);
        return getElementText(driver, PersonalDetailsPUI.NATIONALITY_DROPDOWN_ITEM_SELECTED);
    }

    public String getMarialStatusDropdownValue() {
        waitForElementVisible(driver, PersonalDetailsPUI.MARITAL_STATUS_DROPDOWN_ITEM_SELECTED);
        return getElementText(driver, PersonalDetailsPUI.MARITAL_STATUS_DROPDOWN_ITEM_SELECTED);
    }

    public String getDateOfBirthTextboxValue() {
        waitForElementVisible(driver, PersonalDetailsPUI.DATE_OF_BIRTH_TEXTBOX);
        return getElementAttribute(driver, PersonalDetailsPUI.DATE_OF_BIRTH_TEXTBOX, "value");
    }

    public boolean isGenderMaleRadioSelected(String gender) throws InterruptedException {
        clickToElementByJS(driver, PersonalDetailsPUI.GENDER_RADIO_BUTTON, gender);
        return isElementSelected(driver, PersonalDetailsPUI.GENDER_RADIO_BUTTON, gender);
    }


}
