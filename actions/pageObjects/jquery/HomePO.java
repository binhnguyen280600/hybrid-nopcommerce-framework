package pageObjects.jquery;

import commons.BasePage;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import pageUI.jquery.HomePageUI;

import java.util.ArrayList;
import java.util.List;

public class HomePO extends BasePage {
    WebDriver driver;

    public HomePO(WebDriver driver) {
        this.driver = driver;
    }

    public void openPageByNumber(String pageNumber) throws InterruptedException {
        waitForElementClickable(driver, HomePageUI.DYNAMIC_PAGE_LINK, pageNumber);
        clickToElement(driver, HomePageUI.DYNAMIC_PAGE_LINK, pageNumber);
        sleepInSeconds(2);
    }

    public boolean isPageNumberActive(String pageNumber) {
        waitForElementVisible(driver, HomePageUI.DYNAMIC_PAGE_LINK, pageNumber);
        return getElementAttribute(driver, HomePageUI.DYNAMIC_PAGE_LINK, "class", pageNumber)
                .endsWith("active");
    }

    public void enterToTextboxByHeaderName(String headerName, String valueToSendKey) {
        waitForElementVisible(driver, HomePageUI.DYNAMIC_TEXTBOX_BY_HEADER_NAME, headerName);
        sendKeysToElement(driver, HomePageUI.DYNAMIC_TEXTBOX_BY_HEADER_NAME, valueToSendKey, headerName);
        pressKeyToElement(driver, HomePageUI.DYNAMIC_TEXTBOX_BY_HEADER_NAME, Keys.ENTER, headerName);

    }

    public boolean isRowDataValueDisplayed(String female, String country, String male, String total) {
        waitForElementVisible(driver, HomePageUI.DYNAMIC_DATA_ROW, female, country, male, total);
        return isElementDisplayed(driver, HomePageUI.DYNAMIC_DATA_ROW, female, country, male, total);
    }

    public void deleteRowByCountryName(String countryName) throws InterruptedException {
        waitForElementClickable(driver, HomePageUI.DYNAMIC_DELETE_BUTTON_BY_COUNTRY_NAME, countryName);
        clickToElement(driver, HomePageUI.DYNAMIC_DELETE_BUTTON_BY_COUNTRY_NAME, countryName);
    }

    public void editRowByCountryName(String countryName) throws InterruptedException {
        waitForElementClickable(driver, HomePageUI.DYNAMIC_EDIT_BUTTON_BY_COUNTRY_NAME, countryName);
        clickToElement(driver, HomePageUI.DYNAMIC_EDIT_BUTTON_BY_COUNTRY_NAME, countryName);
    }

    public void clickToLoadDataButton() {
        waitForElementClickable(driver, HomePageUI.LOAD_DATA_BUTTON);
        clickToElement(driver, HomePageUI.LOAD_DATA_BUTTON);
    }

    public void enterToTextBoxByIndex(String rowIndex, String columnName, String valueToSendkey) {
        int columnIndexNumber = getListElement(driver, HomePageUI.DYNAMIC_PRECEDING_SIBLING_COLUMN_NUMBER, columnName).size() + 1;

        String columIndex = String.valueOf(columnIndexNumber);

        sendKeysToElement(driver, HomePageUI.DYNAMIC_TEXTBOX_BY_ROW_AND_COLUMN_INDEX, valueToSendkey, rowIndex, columIndex);
    }


    public void selectToDropDownByIndex(String rowIndex, String columnName, String valueToSelect) {
        int columnIndexNumber = getListElement(driver, HomePageUI.DYNAMIC_PRECEDING_SIBLING_COLUMN_NUMBER, columnName).size() + 1;

        String columIndex = String.valueOf(columnIndexNumber);

        selectItemInDropDown(driver, HomePageUI.DYNAMIC_DROPDOWN_BY_ROW_AND_COLUMN_INDEX, valueToSelect, rowIndex, columIndex);
    }

    public void checkToCheckboxByIndex(String rowIndex, String columnName, boolean checkOrUncheck) {
        int columnIndexNumber = getListElement(driver, HomePageUI.DYNAMIC_PRECEDING_SIBLING_COLUMN_NUMBER, columnName).size() + 1;

        String columIndex = String.valueOf(columnIndexNumber);

        if(checkOrUncheck) {
            checkToCheckboxRadio(driver, HomePageUI.DYNAMIC_CHECKBOX_BY_ROW_AND_COLUMN_INDEX, rowIndex, columIndex);
        } else {
            unCheckToCheckbox(driver, HomePageUI.DYNAMIC_CHECKBOX_BY_ROW_AND_COLUMN_INDEX, rowIndex, columIndex);
        }
    }

    public void clickToIconByIndex(String rowIndex, String iconName) {
        waitForElementClickable(driver, HomePageUI.DYNAMIC_ICON_BY_ROW_INDEX, rowIndex, iconName);
        clickToElement(driver, HomePageUI.DYNAMIC_ICON_BY_ROW_INDEX, rowIndex, iconName);
    }

    public List<String> getAllValueAtColumnName(String columnName) {
        int columnIndexNumber = getListElement(driver, HomePageUI.DYNAMIC_PRECEDING_SIBLING_COLUMN_NUMBER_2, columnName).size() + 1;

        String columIndex = String.valueOf(columnIndexNumber);

        List<WebElement> allValueAtColumn = getListElement(driver, HomePageUI.ALL_VALUE_BY_COLUMN_INDEX, columnName);

        List<String> allTextValue = new ArrayList<String>();

        for(WebElement element : allValueAtColumn) {
            allTextValue.add(element.getText());
        }

        return allTextValue;
    }

}
