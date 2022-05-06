package activities;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Activity4_3 {
    public static void main(String[] args) {

        WebDriver driver = new FirefoxDriver();
        driver.get(" https://www.training-support.net/selenium/target-practice");
        String title = driver.getTitle();
        System.out.println("Page title is: " + title);
        String third=driver.findElement(By.xpath("//h3[@id='third-header']")).getText();
        System.out.println("Third header test is: "+third);
        String fifth=driver.findElement(By.xpath("//h5[@class='ui green header']")).getCssValue("color");
        System.out.println("Fifth header: "+fifth);
        String violet=driver.findElement(By.xpath("//button[@class='ui violet button']")).getAttribute("class");
        System.out.println("Class are: "+violet);
        String grey=driver.findElement(By.xpath("/html/body/div/div[2]/div/div[2]/div/div/div/div[2]/div[3]/button[2]")).getText();
        System.out.println("Grey button text is: "+grey);
        driver.close();
    }
}
