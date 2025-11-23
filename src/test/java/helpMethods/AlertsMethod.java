package helpMethods;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;
import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class AlertsMethod {

    public WebDriver driver;

    public AlertsMethod(WebDriver driver) {
        this.driver = driver;
    }
    // 1️⃣ Așteaptă până apare alerta
    public void waitForAlert() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.alertIsPresent());
    }
    // 2️⃣ Completează text într-o alertă de tip prompt + accept
    public void fillAlert(String text) {
        waitForAlert();
        Alert alert = driver.switchTo().alert();
        alert.sendKeys(text);
        alert.accept();
    }
    // 3️⃣ Acceptă o alertă simplă
    public void acceptAlert(){
        waitForAlert();
        Alert secondAlertElement = driver.switchTo().alert();
        secondAlertElement.accept();
    }
    // 4️⃣ Închide alerta cu Cancel
    public void dismissAlert(){
        waitForAlert();
        Alert secondAlertElement = driver.switchTo().alert();
        secondAlertElement.dismiss();
    }
    // 5️⃣ Acceptă sau închide alerta în funcție de boolean
    public void acceptAlert(boolean chooseAccept) {
        waitForAlert();
        Alert alert = driver.switchTo().alert();

        if (chooseAccept) {
            alert.accept();
        } else {
            alert.dismiss();
        }
    }
    // 6️⃣ Verifică mesajul primit după confirm alert
    public void verifyConfirmAlert(String actualText, boolean chooseAccept) {
        if (chooseAccept) {
            Assert.assertEquals(actualText, "You selected Ok");
            System.out.println("Validare: User a selectat OK");
        } else {
            Assert.assertEquals(actualText, "You selected Cancel");
            System.out.println("Validare: User a selectat Cancel");
        }
    }
}