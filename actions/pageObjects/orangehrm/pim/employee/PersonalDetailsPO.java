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

    public boolean isSuccessMessageIsDisplayed() {
        waitForElementVisible(driver, PersonalDetailsPUI.SUCCESS_MESSAGE);
        return isElementDisplayed(driver, PersonalDetailsPUI.SUCCESS_MESSAGE);
    }

    public boolean isProfileAvatarUpdateSuccess(Dimension beforeUpload) {
        waitForElementVisible(driver, PersonalDetailsPUI.EMPLOYEE_AVATAR_IMAGE);
        Dimension afterUpload = getAvatarSize();
        return !beforeUpload.equals(afterUpload);
    }
}
