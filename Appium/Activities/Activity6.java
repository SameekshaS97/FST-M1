package activities;

import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;

public class Activity6 {
    AndroidDriver<MobileElement> driver;
    WebDriverWait wait;
    @BeforeClass
    public void setUp() throws MalformedURLException {
        DesiredCapabilities caps = new DesiredCapabilities();
        caps.setCapability("platformName","android");
        caps.setCapability("automationName","UiAutomator2");
        caps.setCapability("deviceName","TestEmulator");
        caps.setCapability("appPackage","com.android.chrome" );
        caps.setCapability("appActivity","com.google.android.apps.chrome.Main" );
        caps.setCapability("noReset",true);
        URL serverURL=new URL("http://localhost:4723/wd/hub");
        driver = new AndroidDriver<>(serverURL,caps);
        wait = new WebDriverWait(driver, 5);

    }
    @Test
    public void imageScrollTest() {
        driver.get("https://www.training-support.net/selenium/lazy-loading");
        MobileElement pageTitle = driver.findElementByClassName("android.widget.TextView");
        wait.until(ExpectedConditions.textToBePresentInElement(pageTitle, "Lazy Loading"));

        // Count the number of images shown on the screen
        List<MobileElement> numberOfImages = driver.findElementsByXPath("//android.view.View/android.view.View/android.widget.Image");
        System.out.println("Number of image shown currently: " + numberOfImages.size());

        // Assertion before scrolling
        Assert.assertEquals(numberOfImages.size(), 4);

        // Scroll to Helen's post
        driver.findElement(MobileBy.AndroidUIAutomator("UiScrollable(UiSelector()).scrollTextIntoView(\"helen\")"));

        // Find the number of images shown after scrolling
        numberOfImages = driver.findElementsByXPath("//android.view.View/android.view.View/android.widget.Image");
        System.out.println("Number of image shown currently: " + numberOfImages.size());

        // Assertion after scrolling
        Assert.assertEquals(((List<?>) numberOfImages).size(), 4);
    }

    @AfterClass
    public void afterClass() {
        driver.quit();
    }

}
