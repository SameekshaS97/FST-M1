package liveProject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;

public class Activity4 {
    WebDriver driver;
    @BeforeClass
    public void setup() {
        driver = new FirefoxDriver();
        driver.get("http://alchemy.hguy.co/orangehrm");
    }
    @Test
    public void addEmployee() {
        driver.findElement(By.id("txtUsername")).sendKeys("orange");
        driver.findElement(By.id("txtPassword")).sendKeys("orangepassword123");
        driver.findElement(By.id("btnLogin")).click();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        wait.until(ExpectedConditions.elementToBeClickable(By.id("menu_pim_viewPimModule")));
        driver.findElement(By.id("menu_pim_viewPimModule")).click();
        driver.findElement(By.id("menu_pim_viewPimModule")).click();
        driver.findElement(By.id("btnAdd")).click();
        driver.findElement(By.id("firstName")).sendKeys("Sam");
        driver.findElement(By.id("lastName")).sendKeys("Suv");
        driver.findElement(By.id("btnSave")).click();
        driver.findElement(By.id("menu_pim_viewPimModule")).click();
        driver.findElement(By.id("menu_pim_viewPimModule")).click();
        driver.findElement(By.id("empsearch_employee_name_empName")).sendKeys("Sam");
        driver.findElement(By.id("searchBtn")).click();
    }
    @AfterMethod
    public void teardown(){
        driver.close();

    }
}
