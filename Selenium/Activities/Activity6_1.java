package activities;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;


public class Activity6_1 {
    public static void main(String[] args) {

        WebDriver driver = new FirefoxDriver();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        driver.get("https://training-support.net/selenium/dynamic-controls");
        String title = driver.getTitle();
        System.out.println("Page title is: " + title);
        WebElement button = driver.findElement(By.id("toggleCheckbox"));
        WebElement check = driver.findElement(By.xpath("//input[@class='willDisappear']"));
        button.click();
        wait.until(ExpectedConditions.invisibilityOf(check));
        button.click();
        wait.until(ExpectedConditions.visibilityOf(check));
        check.click();
        driver.close();


    }
}
