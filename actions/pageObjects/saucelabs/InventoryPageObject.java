package pageObjects.saucelabs;

import commons.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import pageUIs.saucelabs.InventoryPageUI;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class InventoryPageObject extends BasePage {
    private WebDriver driver;

    public InventoryPageObject(WebDriver driver) {
        this.driver = driver;
    }


    public void selectSortDropdown(String sortItem) {
        waitForElementClickable(driver, InventoryPageUI.SORT_DROPDOWN);
        selectItemInDropDown(driver, InventoryPageUI.SORT_DROPDOWN, sortItem);
    }

//    Java 7
    public boolean isNameSortAscending() {
        List<WebElement> productNameElement = getListElement(driver, InventoryPageUI.PRODUCT_NAME);

        List<String> productNameText = new ArrayList<String>();

        for(WebElement productName: productNameElement) {
            productNameText.add(productName.getText());
        }

        List<String> productNameTextClone = new ArrayList<>(productNameText);

        Collections.sort(productNameTextClone);

        return productNameTextClone.equals(productNameText);
    }

    public boolean isNameSortDescending() {
        List<WebElement> productNameElement = getListElement(driver, InventoryPageUI.PRODUCT_NAME);

        List<String> productNameText = new ArrayList<String>();

        for(WebElement productName: productNameElement) {
            productNameText.add(productName.getText());
        }

        List<String> productNameTextClone = new ArrayList<>(productNameText);

        Collections.sort(productNameTextClone);
        Collections.reverse(productNameTextClone);

        return productNameTextClone.equals(productNameText);
    }

    public boolean isPriceSortAscending() {
        List<WebElement> productPriceElement = getListElement(driver, InventoryPageUI.PRODUCT_PRICE);

        List<Float> productPriceText = new ArrayList<Float>();

        for(WebElement productName: productPriceElement) {
            productPriceText.add(Float.valueOf(productName.getText().replace("$", "")));
        }

        List<Float> productPriceTextClone = new ArrayList<Float>(productPriceText);

        Collections.sort(productPriceTextClone);

        return productPriceTextClone.equals(productPriceText);
    }

    public boolean isPriceSortDescending() {
        List<WebElement> productPriceElement = getListElement(driver, InventoryPageUI.PRODUCT_PRICE);

        List<Float> productPriceText = new ArrayList<Float>();

        for(WebElement productName: productPriceElement) {
            productPriceText.add(Float.valueOf(productName.getText().replace("$", "")));
        }

        List<Float> productPriceTextClone = new ArrayList<Float>(productPriceText);

        Collections.sort(productPriceTextClone);
        Collections.reverse(productPriceTextClone);

        return productPriceTextClone.equals(productPriceText);
    }
}
