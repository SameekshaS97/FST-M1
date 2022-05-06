package liveProject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;
import java.time.Duration;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Activity6 {
        WebDriver driver;
        @BeforeClass
        public void setup(){
            driver = new FirefoxDriver();
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
            driver.get("http://alchemy.hguy.co/orangehrm");
        }
        @Test
        public void loginandVerify() {
            driver.findElement(By.id("txtUsername")).sendKeys("orange");
            driver.findElement(By.id("txtPassword")).sendKeys("orangepassword123");
            driver.findElement(By.id("btnLogin")).click();
            boolean visible = driver.findElement(By.id("menu_directory_viewDirectory")).isDisplayed();
            boolean clickable = driver.findElement(By.id("menu_directory_viewDirectory")).isEnabled();

            if (visible == true && clickable == true) {
                //If clickable, click on the menu item.
                driver.findElement(By.id("menu_directory_viewDirectory")).click();
                driver.findElement(By.id("menu_directory_viewDirectory")).click();
            }
            String searchtext = driver.findElement(By.xpath("/html/body/div[1]/div[3]/div[1]/div[1]/h1")).getText();
            Assert.assertEquals(searchtext, "Search Directory");
        }
        @AfterClass
        public void teardown(){
            driver.close();

    }
}
