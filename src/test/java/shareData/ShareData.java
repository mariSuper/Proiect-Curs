package shareData;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class ShareData {

    public WebDriver driver;

    public WebDriver getDriver(){
        return driver;
    }

    public void setupEnvironment(){
        driver = new ChromeDriver();
        driver.get("https://demoqa.com/");
    }
    public void quitDriver(){driver.quit();}
}
