package testts;
import helpMethods.ElementsMethod;
import helpMethods.FrameMethods;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class Frames {
    public WebDriver driver;
    ElementsMethod elementsMethod;
    FrameMethods frameMethods;

    @Test
    public void metodaTest() {
        //deschidem un browser
        driver = new ChromeDriver();

        //Creează obiectele
        elementsMethod = new ElementsMethod(driver);
        frameMethods = new FrameMethods(driver);

        // Accesează site-ul DemoQA
        driver.get("https://demoqa.com/");
        driver.manage().window().maximize();

        //Face click pe meniul “Alerts, Frame & Windows”
        WebElement alertMenu = driver.findElement(By.xpath("//h5[text()='Alerts, Frame & Windows']"));
        elementsMethod.javaScriptElement(alertMenu);

        //Face click pe sub-meniul “Frames”
        WebElement framesButton = driver.findElement(By.xpath("//span[text()='Frames']"));
        elementsMethod.javaScriptElement(framesButton);

        //Lucru cu frame-uri
        //Intră în iframe-ul cu id "frame1"
        frameMethods.switchToSpecificFrame("frame1");

        //Se întoarce la pagina principală (părăsește frame-ul)
        frameMethods.switchToParent();

        //Intră în al doilea frame: "frame2"
        frameMethods.switchToSpecificFrame("frame2");
    }
}