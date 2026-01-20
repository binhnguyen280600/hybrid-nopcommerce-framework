package pageObjects.orangehrm.pim.employee;

import commons.BasePage;
import org.openqa.selenium.WebDriver;
import pageObjects.orangehrm.PageGenerator;
import pageUIs.orangehrm.pim.employee.EmployeeTabsPUI;

public class EmployeeTabs extends BasePage {
    private WebDriver driver;

    public EmployeeTabs(WebDriver driver) {
        this.driver = driver;
    }

    public PersonalDetailsPO openPersonalDetailsPage() {
        waitForElementVisible(driver, EmployeeTabsPUI.PERSONAL_DETAIL_LINK);
        clickToElement(driver, EmployeeTabsPUI.PERSONAL_DETAIL_LINK);
        return PageGenerator.getPersonalDetailsPage(driver);
    }

    public ContactDetailsPO openContactDetailsPage() {
        waitForElementVisible(driver, EmployeeTabsPUI.CONTACT_DETAIL_LINK);
        clickToElement(driver, EmployeeTabsPUI.CONTACT_DETAIL_LINK);
        return PageGenerator.getContactDetailsPage(driver);
    }

    public EmergencyContactsPO openEmergencyContactPage() {
        waitForElementVisible(driver, EmployeeTabsPUI.EMERGENCY_CONTACT_LINK);
        clickToElement(driver, EmployeeTabsPUI.EMERGENCY_CONTACT_LINK);
        return PageGenerator.getEmercencyContactPage(driver);
    }
}
