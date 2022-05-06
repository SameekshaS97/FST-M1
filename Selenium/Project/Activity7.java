package liveProject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;

public class Activity7 {
    WebDriver driver;
    @BeforeClass
    public void setup(){
            driver = new FirefoxDriver();
            driver.get("http://alchemy.hguy.co/orangehrm");
    }
    @Test
    public void addExperience() {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
            driver.findElement(By.id("txtUsername")).sendKeys("orange");
            driver.findElement(By.id("txtPassword")).sendKeys("orangepassword123");
            driver.findElement(By.id("btnLogin")).click();
            wait.until(ExpectedConditions.elementToBeClickable(By.id("menu_pim_viewMyDetails")));
            driver.findElement(By.id("menu_pim_viewMyDetails")).click();
            driver.findElement(By.id("menu_pim_viewMyDetails")).click();
            wait.until(ExpectedConditions.elementToBeClickable(By.linkText("Qualifications")));
            driver.findElement(By.linkText("Qualifications")).click();
            driver.findElement(By.id("addWorkExperience")).click();
            driver.findElement(By.id("experience_employer")).sendKeys("IBM");
            driver.findElement(By.id("experience_jobtitle")).sendKeys("Test Analyst");
            driver.findElement(By.id("experience_from_date")).clear();
            driver.findElement(By.id("experience_from_date")).sendKeys("2017-06-11");
            driver.findElement(By.id("experience_to_date")).clear();
            driver.findElement(By.id("experience_to_date")).sendKeys("2022-04-11");
            driver.findElement(By.id("btnWorkExpSave")).click();
    }
    @AfterClass
    public void teardown(){
        driver.close();
    }
}

