package liveProject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;

public class Activity5 {
    WebDriver driver;
    @BeforeClass
    public void setup() {
        driver = new FirefoxDriver();

        driver.get("http://alchemy.hguy.co/orangehrm");
    }
    @Test(priority =0)
    public void login() {
        driver.findElement(By.id("txtUsername")).sendKeys("orange");
        driver.findElement(By.id("txtPassword")).sendKeys("orangepassword123");
        driver.findElement(By.id("btnLogin")).click();

    }
    @Test(priority =1)
    public void editEmployeeDetails() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        wait.until(ExpectedConditions.elementToBeClickable(By.id("menu_pim_viewMyDetails")));
        driver.findElement(By.id("menu_pim_viewMyDetails")).click();
        driver.findElement(By.id("menu_pim_viewMyDetails")).click();
        driver.findElement(By.id("btnSave")).click();
        driver.findElement(By.id("personal_txtEmpFirstName")).clear();
        driver.findElement(By.id("personal_txtEmpFirstName")).sendKeys("Tom");
        driver.findElement(By.id("personal_txtEmpLastName")).clear();
        driver.findElement(By.id("personal_txtEmpLastName")).sendKeys("J");
        driver.findElement(By.id("personal_optGender_1")).click();
        WebElement dropElement = driver.findElement(By.id("personal_cmbNation"));
        Select dropdown = new Select(dropElement);
        dropdown.selectByVisibleText("Indian");
        driver.findElement(By.id("personal_DOB")).clear();
        driver.findElement(By.id("personal_DOB")).sendKeys("1997-02-11");
        driver.findElement(By.id("btnSave")).click();
    }
    @AfterClass
    public void teardown(){
        driver.close();



    }

}
