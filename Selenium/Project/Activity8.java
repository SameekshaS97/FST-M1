package liveProject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;

public class Activity8 {
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

    @Test(dependsOnMethods = {"login"})
    public void applyLeave() {
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.elementToBeClickable(By.id("menu_dashboard_index")));
        driver.findElement(By.id("menu_dashboard_index")).click();
        driver.findElement(By.id("menu_dashboard_index")).click();
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[contains(text(),'Apply Leave')]")));
        driver.findElement(By.xpath("//span[contains(text(),'Apply Leave')]")).click();
        driver.findElement(By.xpath("//span[contains(text(),'Apply Leave')]")).click();
        WebElement dropElement = driver.findElement(By.id("applyleave_txtLeaveType"));
        Select dropdown = new Select(dropElement);
        dropdown.selectByVisibleText("DayOff");
        driver.findElement(By.id("applyleave_txtFromDate")).clear();
        driver.findElement(By.id("applyleave_txtFromDate")).sendKeys("2022-05-11");
        driver.findElement(By.id("applyleave_txtToDate")).clear();
        driver.findElement(By.id("applyleave_txtToDate")).sendKeys("2022-05-19");
        driver.findElement(By.id("applyBtn")).click();
        driver.findElement(By.id("applyBtn")).click();
    }
    @Test(dependsOnMethods = {"applyLeave"})
    public void checkStatus(){
        driver.findElement(By.id("menu_leave_viewMyLeaveList")).click();
        driver.findElement(By.id("calFromDate")).clear();
        driver.findElement(By.id("calFromDate")).sendKeys("2022-05-11");
        driver.findElement(By.id("calToDate")).clear();
        driver.findElement(By.id("calToDate")).sendKeys("2022-05-19");
        driver.findElement(By.id("btnSearch")).click();
        WebElement status=driver.findElement(By.xpath("//table/tbody/tr/td[6]"));
        System.out.println("Leave status is: "+status.getText());
    }
    @AfterClass
    public void teardown(){
        driver.close();
    }
}
