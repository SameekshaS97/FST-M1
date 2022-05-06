package liveProject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.List;

public class Activity9 {
    WebDriver driver;
    WebDriverWait wait;

    @BeforeClass
    public void setup() {
        driver = new FirefoxDriver();
        driver.get("http://alchemy.hguy.co/orangehrm");
    }

    @Test
    public void login() {
        driver.findElement(By.id("txtUsername")).sendKeys("orange");
        driver.findElement(By.id("txtPassword")).sendKeys("orangepassword123");
        driver.findElement(By.id("btnLogin")).click();
    }

    @Test(dependsOnMethods = { "login" })
    public void emergencyContacts() {
        wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        wait.until(ExpectedConditions.elementToBeClickable(By.id("menu_pim_viewMyDetails")));
        driver.findElement(By.id("menu_pim_viewMyDetails")).click();
        driver.findElement(By.id("menu_pim_viewMyDetails")).click();
        wait.until(ExpectedConditions.elementToBeClickable(By.linkText("Emergency Contacts")));
        driver.findElement(By.linkText("Emergency Contacts")).click();
        List<WebElement> rows = driver.findElements(By.id("emgcontact_list"));
        for (WebElement row : rows) {
            System.out.println(row.getText());
        }
        //for (int i = 1; i <= rows.size(); i++) {
        // WebElement row = driver.findElement(By.xpath("//table/tbody/tr[" + i + "]"));
        //System.out.println("Row " + i + ": " + row.getText());
    }
    @AfterClass
    public void teardown(){
        driver.close();
    }

    }

