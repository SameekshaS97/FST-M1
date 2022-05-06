package activities;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Activity3 {
    public static void main(String[] args) {
        WebDriver driver = new FirefoxDriver();
        driver.get("https://training-support.net/selenium/simple-form");
        System.out.println("Title is: " + driver.getTitle());
        WebElement firstname=driver.findElement(By.id("firstName"));
        firstname.sendKeys("Tom");
        WebElement lastname=driver.findElement(By.id("lastName"));
        lastname.sendKeys("J");
        driver.findElement(By.id("email")).sendKeys("ab@gmail.com");
        driver.findElement(By.id("number")).sendKeys("9373737383");
        driver.findElement(By.cssSelector(".green")).click();
        driver.close();



    }
}
