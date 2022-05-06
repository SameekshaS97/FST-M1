package activities;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Activity7_2 {
    public static void main(String[] args) {
        WebDriver driver = new FirefoxDriver();
        driver.get("https://training-support.net/selenium/dynamic-attributes");
        String title = driver.getTitle();
        System.out.println("Page title is: " + title);
        driver.findElement(By.xpath("//input[contains(@class, '-username')]")).sendKeys("User");
        driver.findElement(By.xpath("//input[contains(@class, '-password')]")).sendKeys("Password");
        driver.findElement(By.xpath("//label[text() = 'Confirm Password']/following::input")).sendKeys("Password");
        driver.findElement(By.xpath("//label[contains(text(), 'mail')]/following-sibling::input")).sendKeys("abc@gmail.com");
        driver.findElement(By.xpath("//button[contains(text(), 'Sign Up')]")).click();
        String message = driver.findElement(By.id("action-confirmation")).getText();
        System.out.println("Login message: " + message);
        driver.close();
    }

}
