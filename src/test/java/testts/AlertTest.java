package testts;
import helpMethods.AlertsMethod;
import helpMethods.ElementsMethod;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;
import java.time.Duration;

public class AlertTest {

    public WebDriver driver;
    ElementsMethod elementsMethod;
    AlertsMethod alertsMethod;

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
        // apelam Obiectul
        elementsMethod = new ElementsMethod(driver);
        alertsMethod = new AlertsMethod(driver);

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
        WebElement alertMeniu = wait.until(ExpectedConditions.elementToBeClickable
                (By.xpath("//h5[text()='Alerts, Frame & Windows']")));

        // 5️⃣ Facem click pe cardul "Alerts, Frame & Windows" folosind JavaScript
        elementsMethod.javaScriptElement(alertMeniu);

        // 6️⃣ Așteptăm până apare opțiunea "Browser Windows"
        WebElement alertButton = wait.until(ExpectedConditions.elementToBeClickable
                (By.xpath("//span[text()='Alerts']")));

        // 7️⃣ Facem click pe "Alerts"
        elementsMethod.javaScriptElement(alertButton);

        // 8️⃣ Așteptăm puțin pentru a vedea efectul (opțional, doar pentru observare)
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        //dam click pe prima alerta
        WebElement firstAlertElement = driver.findElement(By.id("alertButton"));
        elementsMethod.javaScriptElement(firstAlertElement);
        alertsMethod.acceptAlert(false);

        //skiped second alert
        WebElement secondAlertElement  = driver.findElement(By.id("timerAlertButton"));
        elementsMethod.javaScriptElement(secondAlertElement);

        //wait explicit folosit pentru al doilea alert, care se deschide cu întârziere.
        alertsMethod.acceptAlert(false);

        // Click pe butonul pentru alerta a treia
        WebElement thirdAlertElement = driver.findElement(By.id("confirmButton"));
        elementsMethod.javaScriptElement(thirdAlertElement);

        // Comutăm pe alertă
        Alert thirdAlert = driver.switchTo().alert();

        // Definim dacă vrem să alegem OK sau Cancel
        boolean chooseAccept = false; // schimbă în true dacă vrei OK

        // apăsăm alerta
        alertsMethod.acceptAlert(chooseAccept);

        // După închiderea alertei, citim textul din pagină
        WebElement textThirdAlert = driver.findElement(By.id("confirmResult"));
        String actualText = textThirdAlert.getText();

        // Validăm alerta a 3-a
        alertsMethod.verifyConfirmAlert(actualText, false);

        // Alerta a patra: inspectam id-ul butonului 'Ckick me'
        WebElement fourthAlertElement = driver.findElement(By.id("promtButton"));
        elementsMethod.javaScriptElement(fourthAlertElement);

       // comutăm pe alertă
        Alert fourthAlert = driver.switchTo().alert();

        // scriem textul
        elementsMethod.fillAlert("Text123");

        // confirmăm alerta
        fourthAlert.accept();

        // După ce apăsăm OK, verificăm textul afișat în pagină
        WebElement textFourthAlert = driver.findElement(By.id("promptResult"));

        // validăm textul
        String expectedTextFourth = "You entered Text123";

        // compară textul din pagină cu cel așteptat.
        Assert.assertEquals(textFourthAlert.getText(), expectedTextFourth);

        if (chooseAccept) {
            Assert.assertEquals(actualText, "You selected Ok");
            System.out.println("Validare reușită: textul este 'You selected Ok'");
        } else {
            Assert.assertEquals(actualText, "You selected Cancel");
            System.out.println("Validare reușită: textul este 'You selected Cancel'");
        }
    }
}


