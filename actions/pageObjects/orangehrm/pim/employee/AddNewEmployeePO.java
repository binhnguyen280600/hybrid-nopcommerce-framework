package pageObjects.orangehrm.pim.employee;

import commons.BasePage;
import org.openqa.selenium.WebDriver;
import pageObjects.orangehrm.PageGenerator;

public class AddNewEmployeePO extends BasePage {

    private WebDriver driver;

    public AddNewEmployeePO(WebDriver driver) {
        this.driver = driver;
    }


    public void enterToFirstNameTextbox(String s) {
    }

    public void enterToLastNameTextbox(String s) {
    }

    public String getEmployeeID() {
        return null;
    }

    public PersonalDetailsPO clickToSaveButton() {
        return PageGenerator.getPersonalDetailsPage(driver);
    }
}
