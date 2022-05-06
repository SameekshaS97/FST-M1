package liveProject;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

public class Activity2 {
    AndroidDriver<MobileElement> driver;
    @BeforeClass
    public void setUp() throws MalformedURLException {
        DesiredCapabilities caps = new DesiredCapabilities();
        caps.setCapability("platformName","android");
        caps.setCapability("automationName","UiAutomator2");
        caps.setCapability("deviceName","TestEmulator");
        caps.setCapability("appPackage","com.google.android.keep" );
        caps.setCapability("appActivity",".activities.BrowseActivity" );
        caps.setCapability("noReset",true);
        URL serverURL=new URL("http://localhost:4723/wd/hub");
        driver = new AndroidDriver<>(serverURL,caps);
    }
    @Test
    public void createNote() {
        MobileElement addNote = driver.findElementById("new_note_button");
        addNote.click();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        WebDriverWait wait = new WebDriverWait(driver, 20);
        MobileElement addNoteTitle = driver.findElementById("editable_title");
        wait.until(ExpectedConditions.elementToBeClickable(addNoteTitle));
        addNoteTitle.click();
        addNoteTitle.sendKeys("Note1");
        MobileElement addDescription = driver.findElementById("edit_note_text");
        addDescription.sendKeys("This is the description for Note1");
        driver.findElementByAccessibilityId("Open navigation drawer").click();
        driver.findElementById("open_search_bar_text_view").click();
        driver.findElementById("search_actionbar_query_text").sendKeys("Note1");
        driver.findElementById("browse_text_note").click();
        String note =driver.findElementById("editable_title").getText();
        Assert.assertEquals(note,"Note1");
    }
    @AfterClass
    public void tearDown(){
        driver.quit();
    }
}
