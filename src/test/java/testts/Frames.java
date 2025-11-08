package testts;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import java.time.Duration;

public class Frames {
    public WebDriver driver;

    @Test
    public void metodaTest() {
        //deschidem un browser
        driver = new ChromeDriver();

        JavascriptExecutor js = (JavascriptExecutor) driver;


        //accesam un URL

        driver.get("https://demoqa.com/");
        driver.manage().window().maximize();

        WebElement alertMenu = driver.findElement(By.xpath("//h5[text()='Alerts, Frame & Windows']"));
        js.executeScript("arguments[0].click();", alertMenu);

        WebElement framesButton = driver.findElement(By.xpath("//span[text()='Frames']"));
        js.executeScript("arguments[0].click();", framesButton);

        driver.switchTo().frame("frame1");
        WebElement sampleTextElement = driver.findElement(By.id("sampleHeading"));
        System.out.println(sampleTextElement.getText());
        driver.switchTo().parentFrame();

        driver.switchTo().frame("frame2");
        WebElement frameTwoElement = driver.findElement(By.id("sampleHeading"));
        System.out.println(frameTwoElement.getText());
    }
}