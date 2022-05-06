package liveProject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.*;

public class Activity1 {
       WebDriver driver;
        @BeforeMethod
        public void setup() {
            driver = new FirefoxDriver();
            driver.get("http://alchemy.hguy.co/orangehrm");
        }
        @Test
         public void title() {
             String title = driver.getTitle();
             Assert.assertEquals(title, "OrangeHRM");
         }
         @AfterMethod
         public void teardown(){
            driver.close();
        }

    }
