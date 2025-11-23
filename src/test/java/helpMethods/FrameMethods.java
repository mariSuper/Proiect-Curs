package helpMethods;

import org.openqa.selenium.WebDriver;

public class FrameMethods {
    public WebDriver driver;

    public FrameMethods(WebDriver driver) {
        this.driver = driver;
    }
    public void switchToSpecificFrame(String frame){
        driver.switchTo().frame(frame);
    }
    public void switchToParent(){
        driver.switchTo().parentFrame();
    }
}
