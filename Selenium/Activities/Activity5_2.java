package activities;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Activity5_2 {
    public static void main(String[] args) {

        WebDriver driver = new FirefoxDriver();
        driver.get("https://training-support.net/selenium/dynamic-controls");
        String title = driver.getTitle();
        System.out.println("Page title is: " + title);
        WebElement check = driver.findElement(By.xpath("//input[@class='willDisappear']"));
        System.out.println("Checkbox input is selected on the page: " + check.isSelected());
        check.click();
        System.out.println("Checkbox input is selected on the page: " + check.isSelected());
        driver.close();


    }
}