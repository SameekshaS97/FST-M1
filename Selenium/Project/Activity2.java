package liveProject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Activity2 {
    WebDriver driver;
    @BeforeMethod
    public void setup() {
        driver = new FirefoxDriver();
        driver.get("http://alchemy.hguy.co/orangehrm");
    }
    @Test
    public void image() {
        WebElement img = driver.findElement(By.tagName("img"));
        System.out.println("Url of the header image is " + img.getAttribute("src"));
    }
    @AfterMethod
    public void teardown() {
        driver.close();
    }
}


