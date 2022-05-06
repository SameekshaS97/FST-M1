package activities;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Activity6_2 {
    public static void main(String[] args) {

        WebDriver driver = new FirefoxDriver();
        WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(10));

        driver.get("https://training-support.net/selenium/ajax");
        String title = driver.getTitle();
        System.out.println("Page title is: " + title);
        driver.findElement(By.xpath("//button[@class='ui violet button']")).click();
        wait.until(ExpectedConditions.textToBePresentInElementLocated(By.id("ajax-content"), "HELLO!"));
        String hello = driver.findElement(By.id("ajax-content")).getText();
        System.out.println(hello);
        wait.until(ExpectedConditions.textToBePresentInElementLocated(By.id("ajax-content"), "I'm late!"));

        String late = driver.findElement(By.id("ajax-content")).getText();
        System.out.println(late);
        driver.close();
    }
}




