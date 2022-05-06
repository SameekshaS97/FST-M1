package activities;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;

public class Activity3 {
        AndroidDriver<MobileElement> driver;
        @BeforeClass
        public void setUp() throws MalformedURLException {
            //Desired capabilities
            DesiredCapabilities caps=new DesiredCapabilities();
            caps.setCapability("platformName","android" );
            caps.setCapability("automationName","UiAutomator2" );
            caps.setCapability("deviceName","TestEmulator" );
            caps.setCapability("appPackage","com.android.calculator2" );
            caps.setCapability("appActivity",".Calculator" );
            caps.setCapability("noReset",true);
            //Server URL
            URL serverURL=new URL("http://localhost:4723/wd/hub");
            driver=new AndroidDriver<>(serverURL,caps);

        }
    @Test
    public void add() {
        driver.findElementById("digit_5").click();
        driver.findElementById("op_add").click();
        driver.findElementById("digit_9").click();
        driver.findElementById("eq").click();

        String result = driver.findElementById("result").getText();
        System.out.println(result);
        Assert.assertEquals(result, "14");
    }

    @Test
    public void subtract() {
        driver.findElementById("digit_1").click();
        driver.findElementById("digit_0").click();
        driver.findElementById("op_sub").click();
        driver.findElementById("digit_5").click();
        driver.findElementById("eq").click();
        String result = driver.findElementById("result").getText();
        System.out.println(result);
        Assert.assertEquals(result, "5");
    }

    @Test
    public void multiply() {
        driver.findElementById("digit_5").click();
        driver.findElementById("op_mul").click();
        driver.findElementById("digit_1").click();
        driver.findElementById("digit_0").click();
        driver.findElementById("digit_0").click();
        driver.findElementById("eq").click();

        String result = driver.findElementById("result").getText();
        System.out.println(result);
        Assert.assertEquals(result, "500");
    }

    @Test
    public void divide() {
        driver.findElementById("digit_5").click();
        driver.findElementById("digit_0").click();
        driver.findElementById("op_div").click();
        driver.findElementById("digit_2").click();
        driver.findElementById("eq").click();

        String result = driver.findElementById("result").getText();
        System.out.println(result);
        Assert.assertEquals(result, "25");
    }

    @AfterClass
    public void afterClass() {
        driver.quit();
    }

}
