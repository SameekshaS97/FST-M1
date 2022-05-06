package activities;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Activity4_2 {
    public static void main(String[] args) {

        WebDriver driver = new FirefoxDriver();

        driver.get("https://www.training-support.net/selenium/simple-form");

        String title = driver.getTitle();

        System.out.println("Page title is: " + title);
        driver.findElement(By.xpath("//input[@id='firstName']")).sendKeys("Tom");
        driver.findElement(By.xpath("//input[@id='lastName']")).sendKeys("J");
        driver.findElement(By.xpath("//input[@id='email']")).sendKeys("ab@gmail.com");
        driver.findElement(By.xpath("//input[@id='number']")).sendKeys("9898989898");
        driver.findElement(By.xpath("//input[@class='ui green button']")).click();



    }
}
