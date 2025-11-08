//package testts;
//
//import net.bytebuddy.asm.Advice;
//import org.openqa.selenium.*;
//import org.openqa.selenium.chrome.ChromeDriver;
//import org.testng.annotations.Test;
//
//import javax.lang.model.util.Elements;
//import javax.swing.*;
//import java.io.File;
//import java.util.Arrays;
//import java.util.List;
//
//public class PracticeForms {
//    public WebDriver driver;
//
//    @Test
//
//    public void metodaTest() {
//
//        //deschidem un browser
//        driver = new ChromeDriver();
//        JavascriptExecutor js = (JavascriptExecutor) driver;
//
//        //accesam un URL
//        driver.get("https://demoqa.com/");
//        driver.manage().window().maximize();
//
//        WebElement formsMenu = driver.findElement(By.xpath("//h5[text()='Forms']"));
//        js.executeScript("arguments[0].click();", formsMenu);
//
//        WebElement practiceForm = driver.findElement(By.xpath("//span[text()='Practice Form']"));
//        js.executeScript("arguments[0].click();", practiceForm);
//
//        WebElement firstNameElement = driver.findElement(By.id("firstName"));
//        String firstName = "Mari";
//        firstNameElement.sendKeys(firstName);
//
//        WebElement lastNameElement = driver.findElement(By.id("lastName"));
//        String lastName = "Mreana";
//        lastNameElement.sendKeys(lastName);
//
//        WebElement userEmailElement = driver.findElement(By.id("userEmail"));
//        String email = "Man@yahoo.com";
//        userEmailElement.sendKeys(email);
//
//        WebElement userNumberElement = driver.findElement(By.id("userNumber"));
//        String mobile = "0772451333";
//        userNumberElement.sendKeys(mobile);
//
//        WebElement currentAddressElement = driver.findElement(By.id("currentAddress"));
//        String address = "Bd. Kogalniceanu nr 200";
//        currentAddressElement.sendKeys(address);
//
//        //Facem o lista pentru radio checkboxes
//        List<WebElement> genderOptionsList= driver.findElements(By.xpath("//input[@name='gender']"));
//
//        //Declaram o variabila de tip String
//        String genderValue = "Female";
//
//        switch (genderValue){
//            case "Male":
//                js.executeScript("arguments[0].click();", genderOptionsList.get(0));
//                break;
//
//            case "Female":
//                js.executeScript("arguments[0].click();", genderOptionsList.get(1));
//                break;
//
//            case "Other":
//                js.executeScript("arguments[0].click();", genderOptionsList.get(2));
//                break;
//        }
//        //Skip Date of Birth
//
//        //FIELD text cu listă predefinită (autocomplete)
//        WebElement subjectElementField = driver.findElement(By.id("subjectsInput"));
////        String subjectValue = "Accounting";
////        subjectElementField.sendKeys(subjectValue);
////        subjectElementField.sendKeys(Keys.ENTER);
//
//        List<String> subjectElements = Arrays.asList("Accounting","Maths","English");
//        for (int index=0; index<subjectElements.size(); index++){
//            subjectElementField.sendKeys(subjectElements.get(index));
//            subjectElementField.sendKeys(Keys.ENTER);
//        }
//        List<String> hobbiesElements = Arrays.asList("Sports","Reading", "Music");
//        List<WebElement> hobbiesCheckList = driver.findElements(By.xpath("//input[@type='checkbox']"));
//        for(int index=0; index<hobbiesElements.size(); index++){
//            js.executeScript("arguments[0].click();", hobbiesCheckList.get(index));
//        }
//        WebElement photoElementField = driver.findElement(By.id("uploadPicture"));
//        File resourcesDirectory = new File("src/test/resources/cursors.jpg");
//        photoElementField.sendKeys(resourcesDirectory.getAbsolutePath());
//
//        WebElement stateElement = driver.findElement(By.xpath("//div[text()='Select State']"));
//        js.executeScript("arguments[0].click();", stateElement);
//
//        WebElement stateInputElement = driver.findElement(By.id("react-select-3-input"));
//        String stateValue = "NCR";
//        stateInputElement.sendKeys(stateValue);
//        stateInputElement.sendKeys(Keys.ENTER);
//    }
//}

