package liveProject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.*;

public class Activity3 {
    WebDriver driver;
    @BeforeClass
    public void setup() {
        driver = new FirefoxDriver();
        driver.get("http://alchemy.hguy.co/orangehrm");
    }
    @Test(priority=0)
     public void a() {

        driver.findElement(By.id("txtUsername")).sendKeys("orange");
        driver.findElement(By.id("txtPassword")).sendKeys("orangepassword123");
        driver.findElement(By.id("btnLogin")).click();
    }
    @Test(priority=1)
    public void homePage() {

        String currentURL = driver.getCurrentUrl();
        System.out.println(currentURL);
        Assert.assertEquals(currentURL, "http://alchemy.hguy.co:8080/orangehrm/symfony/web/index.php/dashboard");
    }
    @AfterClass
    public void teardown(){

        driver.close();
        }
}


