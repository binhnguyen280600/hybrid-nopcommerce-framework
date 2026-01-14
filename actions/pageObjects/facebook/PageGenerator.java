package pageObjects.facebook;

import org.openqa.selenium.WebDriver;
import pageObjects.facebook.LoginPO;

public class PageGenerator {

    public static LoginPO getLoginPage(WebDriver driver) {
        return new LoginPO(driver);
    }

}
