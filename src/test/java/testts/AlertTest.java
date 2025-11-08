package testts;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;

public class AlertTest {

    public WebDriver driver;

    // ✅ Metoda helper - trebuie să fie aici, în clasă, dar în afara metodei @Test
    public void safeClick(WebElement element) {
        try {
            element.click();
        } catch (ElementClickInterceptedException e) {
            System.out.println("Elementul este acoperit, folosesc click JavaScript...");
            ((JavascriptExecutor) driver).executeScript("arguments[0].click();", element);
        }
    }

    @Test
    public void metodaTest() {

        // 1️⃣ Deschidem browserul Chrome
        driver = new ChromeDriver();

        // 2️⃣ Accesăm site-ul DemoQA și maximizăm fereastra
        driver.get("https://demoqa.com/");
        driver.manage().window().maximize();

        //wait implicit (vegheaza asupra codului)
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        // 3️⃣ Scroll în jos pentru a vedea cardul "Alerts, Frame & Windows"
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0, 500)");

        // 4️⃣ Așteptăm până apare cardul "Alerts, Frame & Windows"
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement alertMeniu = wait.until(
                ExpectedConditions.elementToBeClickable(By.xpath("//h5[text()='Alerts, Frame & Windows']")));

        // 5️⃣ Facem click pe cardul "Alerts, Frame & Windows" folosind JavaScript
        js.executeScript("arguments[0].click();", alertMeniu);

        // 6️⃣ Așteptăm până apare opțiunea "Browser Windows"
        WebElement tabButton = wait.until(
                ExpectedConditions.elementToBeClickable(By.xpath("//span[text()='Alerts']"))
        );

        // 7️⃣ Facem click pe "Browser Windows"
        js.executeScript("arguments[0].click();", tabButton);

        // 8️⃣ Așteptăm puțin pentru a vedea efectul (opțional, doar pentru observare)
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        //dam click pe butonul New Tab
        WebElement firstAlertElement = driver.findElement(By.id("alertButton"));
        safeClick(firstAlertElement);
        Alert firstAlert = driver.switchTo().alert();
        firstAlert.accept();

        //skiped second alert
        WebElement secondAlert  = driver.findElement(By.id("timerAlertButton"));
        secondAlert.click();

        //wait explicit
        WebDriverWait waitExplicit = new WebDriverWait(driver,Duration.ofSeconds(10));
        waitExplicit.until(ExpectedConditions.alertIsPresent());
        Alert secondAlertElement = driver.switchTo().alert();
        System.out.println(secondAlertElement.getText());
        secondAlertElement.accept();

        // Click pe butonul pentru alerta a treia
        WebElement thirdAlertElement = driver.findElement(By.id("confirmButton"));
        safeClick(thirdAlertElement);

// Comutăm pe alertă
        Alert thirdAlert = driver.switchTo().alert();

// Definim dacă vrem să alegem OK sau Cancel
        boolean chooseAccept = false; // schimbă în true dacă vrei OK

        if (chooseAccept) {
            thirdAlert.accept();
            System.out.println("Ai ales OK");
        } else {
            thirdAlert.dismiss();
            System.out.println("Ai ales Cancel");
        }

// Validare pentru alerta a treia
        WebElement textThirdAlert = driver.findElement(By.id("confirmResult"));
        String actualText = textThirdAlert.getText();

        if (chooseAccept) {
            Assert.assertEquals(actualText, "You selected Ok");
            System.out.println("Validare reușită: textul este 'You selected Ok'");
        } else {
            Assert.assertEquals(actualText, "You selected Cancel");
            System.out.println("Validare reușită: textul este 'You selected Cancel'");
        }
    }
}


