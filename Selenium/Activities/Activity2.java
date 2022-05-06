package activities;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Activity2 {
    public static void main(String[] args) {
        WebDriver driver = new FirefoxDriver();
        driver.get("https://www.training-support.net");
        System.out.println("Title is: " + driver.getTitle());
        WebElement id=driver.findElement(By.id("about-link"));
        System.out.println("Text in WebElement: " + id.getText());
        WebElement className=driver.findElement(By.className("green"));
        System.out.println("Text in WebElement: " + className.getText());
        WebElement link=driver.findElement(By.linkText("About Us"));
        System.out.println("Text in WebElement: " + link.getText());
        WebElement css=driver.findElement(By.cssSelector(".green"));
        System.out.println("Text in WebElement: " + css.getText());
        driver.close();
    }
}