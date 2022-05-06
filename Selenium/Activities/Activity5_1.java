package activities;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Activity5_1 {
    public static void main(String[] args) {

        WebDriver driver = new FirefoxDriver();
        driver.get("https://training-support.net/selenium/dynamic-controls");
        String title = driver.getTitle();
        System.out.println("Page title is: " + title);
        WebElement check=driver.findElement(By.xpath("//input[@class='willDisappear']"));
        System.out.println("Checkbox input is visible on the page: "+check.isDisplayed());
        driver.findElement(By.id("toggleCheckbox")).click();
        System.out.println("Checkbox input is visible on the page: "+check.isDisplayed());
        driver.close();

    }
}