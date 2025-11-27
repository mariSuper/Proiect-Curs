package testts;
import helpMethods.ElementsMethod;
import helpMethods.TabMethods;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;
public class TabWindowTest {

    public WebDriver driver;
    ElementsMethod elementsMethod;
    TabMethods tabMethods;

    @Test
    public void metodaTest() {

        driver = new ChromeDriver();
        driver.get("https://demoqa.com/");
        driver.manage().window().maximize();

        //declaram obiectul
        elementsMethod = new ElementsMethod(driver);
        tabMethods = new TabMethods(driver);

        //Scroll în jos pentru a vedea cardul "Alerts, Frame & Windows"
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0, 500)");

        //Așteptăm până apare cardul "Alerts, Frame & Windows" ca sa facem click pe ea
        WebElement alertMenu = driver.findElement(By.xpath("//h5[text()='Alerts, Frame & Windows']"));
        elementsMethod.javaScriptElement(alertMenu);

        //Așteptăm până apare opțiunea "Browser Windows" ca sa facem click pe ea
        WebElement tabButton = driver.findElement(By.xpath("//span[text()='Browser Windows']"));
        elementsMethod.javaScriptElement(tabButton);

        WebElement newTabButton = driver.findElement(By.id("tabButton"));
        elementsMethod.javaScriptElement(newTabButton);

        WebElement newWindowElement = driver.findElement(By.id("windowButton"));
        elementsMethod.javaScriptElement(newWindowElement);

        tabMethods.switchSpecificTab(1);

        tabMethods.closeCurrentTab();
        tabMethods.switchSpecificTab(0);

        WebElement newWindowMessage = driver.findElement(By.id("messageWindowButton"));
        elementsMethod.javaScriptElement(newWindowMessage);

        tabMethods.switchSpecificTab(1);

        // Schimbăm focusul către noua fereastră
        tabMethods.switchSpecificTab(1);

        // Pentru "New Window Message", fereastra are text, nu HTML complet
        System.out.println(driver.getPageSource());

        // Închidem fereastra de mesaj
        tabMethods.closeCurrentTab();

        // Ne întoarcem la prima fereastră
        tabMethods.switchSpecificTab(0);

        //Așteptăm puțin pentru a vedea efectul (opțional, doar pentru observare)
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        // Test reușit — s-a deschis Tab-ul
        // driver.quit();
       }
        // 9️⃣ Închidem browserul
        //  driver.quit();
    }
