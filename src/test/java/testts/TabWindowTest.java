package testts;


import helpMethods.ElementsMethod;
import helpMethods.TabMethods;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.devtools.v125.network.model.ServiceWorkerRouterInfo;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

public class TabWindowTest {

    public WebDriver driver;
    ElementsMethod elementsMethod;

    @Test
    public void metodaTest() {

        driver = new ChromeDriver();
        driver.get("https://demoqa.com/");
        driver.manage().window().maximize();

        //declaram obiectul
        elementsMethod = new ElementsMethod(driver);

        //Scroll în jos pentru a vedea cardul "Alerts, Frame & Windows"
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0, 500)");

        //Așteptăm până apare cardul "Alerts, Frame & Windows" ca sa facem click pe ea
        WebElement alertMenu = driver.findElement(By.xpath("//h5[text()='Alerts, Frame & Windows']"));
        elementsMethod.javaScriptElement(alertMenu);

        //Așteptăm până apare opțiunea "Browser Windows" ca sa facem click pe ea
        WebElement tabButton = driver.findElement(By.xpath("//span[text()='Browser Windows']"));
        elementsMethod.javaScriptElement(tabButton);

//Așteptăm puțin pentru a vedea efectul (opțional, doar pentru observare)
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

//dam click pe butonul New Tab
        WebElement tubButtonElement = driver.findElement(By.id("tabButton"));
        tubButtonElement.click();

        // Test reușit — s-a deschis Tab-ul
//        driver.quit();
    }
//         9️⃣ Închidem browserul
//        driver.quit();
    }
