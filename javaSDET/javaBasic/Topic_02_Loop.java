package javaBasic;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public final class Topic_02_Loop { //final: ko cho class khác kế thừa nó

    //final ko cho phép gán lại giá trị mới
    public static final String PI = "3.143434";

    public final void clickToELement() {

    }

    public static void clickButton() {

    }

    public static void main(String[] args) {

        Topic_02_Loop topic02 = new Topic_02_Loop();
        topic02.clickToELement();
        topic02.isELementDislayed();
        System.out.println(Topic_02_Loop.PI);

        System.out.println("---FOR---");
        for (int i = 0; i < 10; i++) {
            if (i == 5) {
                System.out.println(i);
                break;
            }
        }

        System.out.println("---WHILE---");
        int i = 0;
        while (i < 10) { //kiểm tra trước
            System.out.println(i); //action
            i++;
        }

        System.out.println("---D0---");
        i = 1;
        do {
            System.out.println(i); //action
            i++;
        } while (i <= 0); // kiểm tra sau
    }

    public boolean isELementDislayed() {
        WebDriver driver = new FirefoxDriver();
        WebElement element = driver.findElement(By.cssSelector(""));
        boolean status = false;
        try {
            status = element.isDisplayed();
        } catch (NoSuchElementException exception) {
            exception.printStackTrace();
            throw new RuntimeException(exception.getMessage());
        } finally { //step bắt buôc phải chạy
            //Đóng kết nối vào DB/ clean dữ liệu1
        }
        return false;
    }
}

