package com.orangehrm.pim;

import commons.BaseTest;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import pageObjects.orangehrm.DashboardPO;
import pageObjects.orangehrm.LoginPO;
import pageObjects.orangehrm.PageGenerator;
import pageObjects.orangehrm.pim.employee.AddNewEmployeePO;
import pageObjects.orangehrm.pim.employee.EmployeeListPO;
import pageObjects.orangehrm.pim.employee.PersonalDetailsPO;

public class PIM_01_Employee extends BaseTest {
    private WebDriver driver;
    private LoginPO loginPage;
    private DashboardPO dashboardPage;
    private EmployeeListPO employeeListPage;
    private PersonalDetailsPO personalDetailsPage;
    private AddNewEmployeePO addNewEmployeePage;
    private String employeeID;

    @Parameters({"browser", "url"})
    @BeforeClass
    public void beforeClass(String browserName, String url) {
        driver = getBrowserDriver(browserName);

        loginPage = PageGenerator.getLoginPage(driver);

        loginPage.enterToUsernameTextbox("nhubinh@gmail.com");
        loginPage.EnterToPasswordTextbox("Haveaniceday1@");
        dashboardPage = loginPage.clickToLoginButton();
    }

    @Test
    public void Employee_01_Add_New() {

        employeeListPage = dashboardPage.clickToPIMPage();

        addNewEmployeePage = employeeListPage.clickToAddEmployeeButton();

        addNewEmployeePage.enterToFirstNameTextbox("");
        addNewEmployeePage.enterToLastNameTextbox("");
        employeeID = addNewEmployeePage.getEmployeeID();

        personalDetailsPage = addNewEmployeePage.clickToSaveButton();
    }

    @Test
    public void Employee_02_Upload_Avatar() {

    }

    @Test
    public void Employee_03_Personal_Details() {

    }

    @Test
    public void Employee_04_Contact_Details() {

    }

    @Test
    public void Employee_05_Emergency_Details() {

    }

    @Test
    public void Employee_06_Dependents() {

    }



    @AfterClass
    public void afterClass() {
        driver.quit();
    }

}
