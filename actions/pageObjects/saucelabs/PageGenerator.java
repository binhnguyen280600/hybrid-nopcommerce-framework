package pageObjects.saucelabs;

import org.openqa.selenium.WebDriver;
import pageObjects.orangehrm.DashboardPO;
import pageObjects.orangehrm.LoginPO;
import pageObjects.orangehrm.pim.employee.*;

public class PageGenerator {

    public static LoginPageObject getLoginPage(WebDriver driver) {
        return new LoginPageObject(driver);
    }

    public static InventoryPageObject getInventoryPage(WebDriver driver) {
        return new InventoryPageObject(driver);
    }


}
