package com.orangehrm.pim;

import commons.BaseTest;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
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
    private String employeeID, firstName, lastName;
    private String avatarImageName = "Hue.jpg";

    @Parameters({"browser", "url"})
    @BeforeClass
    public void beforeClass(String browserName, String url) {
        driver = getBrowserDriver(browserName);

        loginPage = PageGenerator.getLoginPage(driver);

        firstName = "John";
        lastName = "Wick";

        loginPage.enterToUsernameTextbox("nhubinh@gmail.com");
        loginPage.EnterToPasswordTextbox("Haveaniceday1@");
        dashboardPage = loginPage.clickToLoginButton();
    }

    @Test
    public void Employee_01_Add_New() {

        employeeListPage = dashboardPage.clickToPIMPage();

        addNewEmployeePage = employeeListPage.clickToAddEmployeeButton();

        addNewEmployeePage.enterToFirstNameTextbox(firstName);
        addNewEmployeePage.enterToLastNameTextbox(lastName);
        employeeID = addNewEmployeePage.getEmployeeID();

        System.out.println("Employee ID = " + employeeID);

        personalDetailsPage = addNewEmployeePage.clickToSaveButtonAtEmployeeContainer();
    }

    @Test
    public void Employee_02_Upload_Avatar() {

        personalDetailsPage.clickToEmployeeAvatarImage();

        //lấy ra height/ width của element (avatar A)
        Dimension beforeUpload = personalDetailsPage.getAvatarSize();

        personalDetailsPage.uploadMultipleFiles(driver, avatarImageName);

        personalDetailsPage.clickToSaveButtonAtProfilePictureContainer();

        personalDetailsPage.isSuccessMessageIsDisplayed();

        personalDetailsPage.waitAllLoadingIconInvisible(driver);

        Assert.assertTrue(personalDetailsPage.isProfileAvatarUpdateSuccess(beforeUpload));

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
