package activities;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Activity7_1 {
    public static void main(String[] args) {
        WebDriver driver = new FirefoxDriver();
        driver.get("https://training-support.net/selenium/dynamic-attributes");
        String title = driver.getTitle();
        System.out.println("Page title is: " + title);
        driver.findElement(By.xpath("//input[@type='text']")).sendKeys("admin");
        driver.findElement(By.xpath("//input[@type='password']")).sendKeys("password");
        driver.findElement(By.xpath("//button[@type='submit']")).click();
        WebElement message= driver.findElement(By.id("action-confirmation"));
        System.out.println("Login message is: "+message.getText());
        driver.close();

    }
}
