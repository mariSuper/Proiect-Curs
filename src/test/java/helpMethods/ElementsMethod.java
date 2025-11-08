package helpMethods;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

public class ElementsMethod {
    public WebDriver driver;

    ElementsMethod elementsMethod;
    TabMethods tabMethods;

    @Test

    public void metodaTest() {

        driver = new ChromeDriver();
        driver.get("https://demoqa.com/");
        driver.manage().window().maximize();
        elementsMethod = new ElementsMethod(driver);
        tabMethods = new TabMethods(driver);

        WebElement alertMenu = driver.findElement(By.xpath("//h5[text()='Alerts, Frame & Windows']"));
        elementsMethod.javaScriptElement(alertMenu);

        WebElement tabButton = driver.findElement(By.xpath("//span[text()='Browser Windows']"));
        elementsMethod.javaScriptElement(tabButton);

        WebElement newTabButton = driver.findElement(By.id("tabButton"));
        elementsMethod.clickElement(newTabButton);

        tabMethods.switchSpecificTab(1);

        tabMethods.closeCurrentTab();
        tabMethods.switchSpecificTab(0);

        WebElement newWindowElement = driver.findElement(By.id("windowButton"));
        elementsMethod.javaScriptElement(newWindowElement);
        tabMethods.switchSpecificTab(1);
    }
}




